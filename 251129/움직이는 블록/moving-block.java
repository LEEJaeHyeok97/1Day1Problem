import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        // Please write your code here.
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += blocks[i];
        }

        int target = total / n;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(blocks[i] < target) {
                ans += (target - blocks[i]);
            }
            if(blocks[i] > target) {
                ans += Math.abs(target - blocks[i]);
            }
        }

        System.out.println(ans/2);
    }
}