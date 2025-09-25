import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        // Please write your code here.
        int cnt = 0; boolean flag = false;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(x2[i] > x2[j]) {
                    flag = true;
                    cnt++;
                }
            }
        }

        if(flag == true) {
            System.out.println(n - cnt - 1);
        } else {
            System.out.println(n);
        }
    }
}