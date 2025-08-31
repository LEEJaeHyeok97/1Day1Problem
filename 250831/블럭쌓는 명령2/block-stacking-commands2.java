import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] arr = new int[N + 1];
        for(int i = 0; i < N+1; i++) {
            arr[i] = 0;
        }

        int maxValue = 0;
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            for(int ai = A; ai <= B; ai++) {
                arr[ai] += 1;
                maxValue = Math.max(maxValue, arr[ai]);
            }
        }
        // Please write your code here.

        System.out.println(maxValue);
    }
}