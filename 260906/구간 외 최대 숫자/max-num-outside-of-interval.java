import java.util.Scanner;

// N개의 숫자 주어진다, Q개의 질의 구간 밖에 있는 숫자들 중 최댓값을 출력
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] prefixMax = new int[n];
        prefixMax[0] = arr[0];
        int[] suffixMax = new int[n];
        suffixMax[n-1] = arr[n-1];
        for(int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);
        }
        for(int i = n-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], arr[i]);
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            int res = Math.max(prefixMax[a - 1], suffixMax[b + 1]);
            System.out.println(res);
        }
    }
}