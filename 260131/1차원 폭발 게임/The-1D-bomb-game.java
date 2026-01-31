import java.util.Scanner;

public class Main {

    static int[] bombs;
    static int[] tmpList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }
        // Please write your code here.
        boolean flag = true;
        while(flag) { // bomb 발생 시 flag는 true로 설정
            flag = false;
            int cnt = 0;
            int prev = -2;
            for(int i = 0; i < bombs.length; i++) {
                if(prev == bombs[i]) {
                    cnt++;
                }
                else {
                    if(cnt >= m) {
                        for(int j = i - cnt; j < i; j++) {
                            bombs[j] = -1;
                        }
                    }

                    cnt = 1;
                }

                prev = bombs[i];
            }

            if(cnt > 1) {
                if(cnt >= m) {
                    for(int j = bombs.length - cnt; j < bombs.length; j++) {
                            bombs[j] = -1;
                        }
                }
            }

            int cntDelete = cntDel();
            if(cntDelete > 0) {
                // System.out.println("test");
                flag = true;
            }
            tmpList = new int[bombs.length - cntDelete];
            int idx = 0;
            for(int k = 0; k < bombs.length; k++) {
                if(bombs[k] != -1) {
                    tmpList[idx++] = bombs[k];
                }
            }

            bombs = tmpList;
        }

        int cnt = 0;
        for(int i = 0; i < bombs.length; i++) {
            if(bombs[i] != -1) cnt++;
        }
        System.out.println(cnt);

        for(int i = 0; i < bombs.length; i++) {
            if(bombs[i] != -1) System.out.println(bombs[i]);
        }
    }

    static int cntDel() {
        int cnt = 0;
        for(int i = 0; i < bombs.length; i++) {
            if(bombs[i] == -1) cnt++;
        }

        return cnt;
    }
}