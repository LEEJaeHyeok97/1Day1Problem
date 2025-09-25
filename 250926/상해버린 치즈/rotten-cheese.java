import java.util.Scanner;
// 각각의 치즈가 상했다고 가정했을 때의 아플수 있는 최대 사람의 수를 구하면 된다.
// 모순이 발생하면 해당 치즈는 상할 수 없으므로 가능한 답에서 제외한다.
// 1. 단서로 주어진 아픈 사람으로 주어진 사람이 치즈를 먹은 기록이 없다면 모순이 생긴다.
// 2. 단서로 주어진 사람의 아프기 시작한 시간이 그 사람이 치즈를 먹은 시간보다 빠르다면 모순이 생김

//치지를 먹은 정보를 나타내는 클래스 선언
class Info1 {
        int p, m, t;

        public Info1(int p, int m, int t) {
            this.p = p;
            this.m = m;
            this.t = t;
        }
    };
    
    // 치즈를 먹은 정보를 나타내는 클래스 선언
    class Info2 {
        int p, t;

        public Info2(int p, int t) {
            this.p = p;
            this.t = t;
        }
    };

public class Main {
    static final int MAX_N = 50;
    static final int MAX_D = 1000;

    static int n, m, d, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 사람수
        m = sc.nextInt(); // 치즈 수
        d = sc.nextInt(); // 치즈먹은 기록 수
        s = sc.nextInt(); // 아팠던 기록 수

        Info1[] info1 = new Info1[MAX_D]; // 치즈 먹은 기록 p m t
        Info2[] info2 = new Info2[MAX_N]; //아픈 사람 기록 p t

        for (int i = 0; i < d; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            info1[i] = new Info1(p, m, t); // 사람p 치즈m 언제t
        }
        for (int i = 0; i < s; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();
            info2[i] = new Info2(p, t);
        }
        // Please write your code here.

        int ans = 0;

        for(int i = 1; i <= m; i++) {
            int[] time = new int[MAX_N + 1];
            for(int j = 0; j < d; j++) {
                if(info1[j].m != i)
                    continue;
                
                int person = info1[j].p;
                if(time[person] == 0)
                    time[person] = info1[j].t;
                else if(time[person] > info1[j].t) {
                    time[person] = info1[j].t;
                }
            }

            boolean possible = true;
            for(int j = 0; j < s; j++) {
                int person = info2[j].p;
                if(time[person] == 0)
                    possible = false;
                if(time[person] >= info2[j].t)
                    possible = false;
            }

            int pill = 0;
            if(possible) {
                for(int j = 1; j <= n; j++) {
                    if(time[j] != 0)
                        pill++;
                }
            }

            ans = Math.max(ans, pill);
        }
        
        System.out.println(ans);
    }
}