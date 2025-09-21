import java.util.Scanner;

// 0 5 2 0 0 0 0 4 0 0 0 0 0 0 0 10
public class Main {

    static int[] positions = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int candy = sc.nextInt();
            int position = sc.nextInt();

            positions[position] = candy;
        }
        // Please write your code here.
        if(K >= N) {
            int s = 0;
            for(int i = 0; i < positions.length; i++) s+= positions[i];
            System.out.println(s);
            return;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < positions.length - 2*k - 1; i++) {
            int tmp = 0;
            for(int j = 0; j <= 2*k; j++) {
                tmp += positions[i + j];
            }
            ans = Math.max(tmp, ans);
        }

        System.out.println(ans);
    }
}