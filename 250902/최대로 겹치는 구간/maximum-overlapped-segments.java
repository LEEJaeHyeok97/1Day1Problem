import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x1;
        int x2;
        int[] arr = new int[201];
        for(int i = 0; i < 201; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            x1 = sc.nextInt() + 100;
            x2 = sc.nextInt() + 100;
            for(int j = x1; j <= x2 - 1; j++) {
                arr[j] += 1;
            }
        }

        int maxValue = 0;
        for(int i = 0; i < 200; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        // Please write your code here.
        System.out.println(maxValue);
    }
}