import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int tmp1 = arr[i]; int tmp2 = arr[j];
                arr[i] = 0; arr[j] = 0;

                diff = Math.min(diff, Math.abs(s - Arrays.stream(arr).sum()));

                arr[i] = tmp1; arr[j] = tmp2;
            }
        }
        System.out.println(diff);
    }
}