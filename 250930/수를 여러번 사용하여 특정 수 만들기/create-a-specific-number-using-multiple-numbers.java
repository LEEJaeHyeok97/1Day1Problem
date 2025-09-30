import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.

        int ans = 0;
        for(int i = 0; i < 1001; i++) {
            for(int j = 0; j < 1001; j++) {
                if(i*A + j*B <= C) {
                    ans = Math.max(ans, i*A + j*B);
                }
            }
        }

        System.out.println(ans);
    }
}