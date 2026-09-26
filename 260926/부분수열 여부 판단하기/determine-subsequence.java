import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n+1];
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[m+1];
        for (int i = 1; i <= m; i++) {
            B[i] = sc.nextInt();
        }

        // B가 A의 부분수열인지 판단
        int i = 1;
        for(int j = 1; j <= B.length-1; j++) {
            while(i <= A.length-1 && A[i] != B[j]) {
                i++;
            }

            if(i == A.length) {
                System.out.println("No");
                return;
            }

            else {
                i++;
            }
        }

        System.out.println("Yes");
    }
}