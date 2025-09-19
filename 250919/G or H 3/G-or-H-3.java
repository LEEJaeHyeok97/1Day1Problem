import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[10001];
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            arr[pos] = c;
        }
        // Please write your code here.
        int ans = 0;
        for(int i = 1; i <= 10000 - k; i++) {
            int tmp = 0;
            for(int j = i; j <= i + k; j++) {
                if(arr[j] == 'G') {
                    tmp += 1;
                } else if(arr[j] == 'H') {
                    tmp += 2;
                }
            }
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }
}