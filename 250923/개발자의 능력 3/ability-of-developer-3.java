import java.util.Scanner;

public class Main {

    static int[] ability = new int[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            ability[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 6; i++) {
            for(int j = i +1 ;j< 6; j++) {
                for(int k = j + 1; k < 6; k++) {
                    ans = Math.min(ans, getDiff(i, j, k));
                }
            }
        }

        System.out.println(ans);
    }
    
    static int getDiff(int a, int b, int c) {
        int sum1 = 0; int sum2 = 0;
        for(int i = 0; i < 6; i++) sum1 += ability[i];
        sum2 = ability[a] + ability[b] + ability[c];
        sum1 = Math.abs(sum1 - sum2);

        return Math.abs(sum1 - sum2);
    }
}