import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int answer = 1;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > t && arr[i-1] > t) {
                cnt += 1;
            } else {
                cnt = 1;
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}