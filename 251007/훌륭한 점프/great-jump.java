import java.util.Scanner;
public class Main {

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
        int minimax = 0;
        for(int a = 1; a < n; a++) {
            if(isPossible(a))
                minimax = Math.max(minimax, a);
        }

        System.out.println(minimax);
    }

    static boolean isPossible(int maxValue) {
        int cnt = 0;
        int[] availableIndicies = new int[n];

        for(int i = 0; i < n; i++) {
            if(arr[i] >= maxValue)
                availableIndicies[cnt++] = i;
        }

        for(int i = 1; i < cnt; i++) {
            int dist = availableIndicies[i] - availableIndicies[i-1];
            if(dist > k) return false;
        }

        return true;
    }
}