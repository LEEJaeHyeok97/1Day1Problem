import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 86; i++) {
            int downLimit = i;
            int upLimit = i + 17;

            int tmp = 0;
            for(int j = 0; j < n; j++) {
                if(!inRange(arr[j], downLimit, upLimit)) {
                    if(arr[j] < downLimit) {
                        tmp += (downLimit - arr[j])*(downLimit - arr[j]);
                    }
                    if(arr[j] > upLimit) {
                        tmp += (arr[j] - upLimit)*(arr[j] - upLimit);
                    }
                }
            }

            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
    }

    static boolean inRange(int x, int downLimit, int upLimit) {
        return downLimit <= x && upLimit >= x;
    }
}