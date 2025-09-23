import java.util.Scanner;

// 1~9 서로 다른 숫자 세 개
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] count1 = new int[n];
        int[] count2 = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }
        // Please write your code here.
        
        int cnt = 0;
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                for(int k = 1; k <= 9; k++) {
                    if(i == j || j == k || i == k) continue;

                    boolean succeeded = true;
                    for(int q = 0; q < n; q++) {
                        int x = num[q] / 100;
                        int y = num[q] / 10 % 10;
                        int z = num[q] % 10;
                         
                        int cnt1 = 0; int cnt2 = 0;
                        if(x == i) {
                            cnt1++;
                        }
                        if(y == j) {
                            cnt1++;
                        }
                        if(z == k) {
                            cnt1++;
                        }
                        if(x == j || x == k) {
                            cnt2++;
                        }
                        if(y == i || y == k) {
                            cnt2++;
                        }
                        if(z == i || z == j) {
                            cnt2++;
                        }

                        if(cnt1 != count1[q] || cnt2 != count2[q]) {
                            succeeded = false;
                            break;
                        }
                    }

                    if(succeeded) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}