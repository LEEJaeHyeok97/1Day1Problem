import java.util.Scanner;
public class Main {

    static int[] arr = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int cnt = 1;
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int j = a; j < b+1; j++) {
                arr[j]++;
            }
        }

        for(int i = 0; i < 101; i++) {
            if(arr[i] == n) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}