import java.util.Scanner;
public class Main {

    static final int MAX_N = 100;
    static final int MAX_NUM = 100;

    static int n, k;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        for(int a = Math.max(arr[0], arr[n-1]); a <= MAX_NUM; a++) {
            if(isPossible(a)){
                System.out.println(a);
                break;
            }
        }
    }

    static boolean isPossible(int limit) {
        int lastIdx = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i] <= limit) {
                if(i - lastIdx > k)
                    return false;
                lastIdx = i;
            }
        }

        return true;
    }
}