import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int ans = 0;
        if(n < 3) {
            System.out.println(0);
            return;
        }
        if(n == 3) {
            System.out.println(1);
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                for(int k = j + 1; k < arr.length; k++) {
                    if(arr[i] <= arr[j] && arr[j] <= arr[k])
                        ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}