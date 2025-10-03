import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[][] = new int[M][2];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
        }

        // Please write your code here.
        int ans = 0;
        for(int i = 0; i < M; i++) {
            int cnt = 0;
            for(int j = 0; j < M; j++) {
                if((arr[i][0] == arr[j][0] && arr[i][1] == arr[j][1]) || (arr[i][0] == arr[j][1] && arr[i][1] == arr[j][0])) {
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}