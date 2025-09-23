import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        arr[4] = sc.nextInt();
        // Please write your code here.
        int ans = -1;
        // 모든 팀의 능력치가 서로 다르게 만들 수 있어야함.
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    for(int s = 0; s < 5; s++) {
                        for(int t = 0; t < 5; t++) {
                            if(i != j && i != k && i != s && i != t && j != k && j != s && j != t && k != s && k != t && s != t) {
                                int t1 = arr[i] + arr[j]; int t2 = arr[k] + arr[s]; int t3 = arr[t];
                                if(t1 != t2 && t1 != t3 && t2 != t3 ) {
                                    int maxValue = Math.max(t1, Math.max(t2, t3));
                                    int minValue = Math.min(t1, Math.min(t2, t3));
                                    ans = maxValue - minValue;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}