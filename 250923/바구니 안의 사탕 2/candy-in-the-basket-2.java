import java.util.Scanner;

// 0 5 2 0 0 0 0 4 0 0 0 0 0 0 0 10
public class Main {

    static int[] positions = new int[401];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int candy = sc.nextInt();
            int position = sc.nextInt();

            positions[position] += candy;
        }

        int ans = 0; //  0 0 0 0 0 0
        for(int i = 0; i < positions.length - 2*k; i++) {
            int tmp = 0;
            for(int j = i; j <= i + 2*k; j++) {
                tmp += positions[j];
            }
            // System.out.println(tmp);
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}