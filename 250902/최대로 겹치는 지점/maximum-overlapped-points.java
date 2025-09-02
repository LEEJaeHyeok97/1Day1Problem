import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start;
        int end;
        int[] arr = new int[101];
        for (int i = 0; i < 101; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            for (int j = start; j <= end; j++) {
                arr[j] += 1;
            }
        }
        // Please write your code here.
        int maxValue = 0;
        for (int i = 0; i < 101; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        System.out.println(maxValue);
        
    }
}