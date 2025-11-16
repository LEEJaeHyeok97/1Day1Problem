import java.util.Scanner;

public class Main {
    static int MAX_N = 100;

    static int[] arr = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int j = a; j < b + 1; j++) {
                arr[j]++;
            }
        }
        // Please write your code here.
        for(int i = 0; i < MAX_N; i++) {
            if(arr[i] == n - 1) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}