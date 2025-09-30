import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j < 11; j++) {
                for(int k = 0; k < 11; k++) {
                    for(int s = 0; s < 11; s++) {
                        if(i == 0) {
                            if(j == k || j == s || k == s) continue;
                            int cnt = 0;
                            for(int t = 0; t < n; t++) {
                                if(x[t] == j || x[t] == k || x[t] == s) cnt++;
                            }
                            
                            if(cnt == n) {
                                System.out.println(1);
                                return;
                            }
                        }
                        else if(i == 1) {
                            if(k == s) continue;
                            int cnt = 0;
                            for(int t = 0; t < n; t++) {
                                if(y[t] == j || x[t] == k || x[t] == s) cnt++;
                            }

                            if(cnt == n) {
                                System.out.println(1);
                                return;
                            }
                        }
                        else if(i == 2) {
                            if(j == k) continue;
                            int cnt = 0;
                            for(int t = 0; t < n; t++) {
                                if(y[t] == j || y[t] == k || x[t] == s) cnt++;
                            }

                            if(cnt == n) {
                                System.out.println(1);
                                return;
                            }
                        }
                        else if(i == 3) {
                            if(j == k || j == s || k == s) continue;
                            int cnt = 0;
                            for(int t = 0; t < n; t++) {
                                if(y[t] == j || y[t] == k || y[t] == s) cnt++;
                            }

                            if(cnt == n) {
                                System.out.println(1);
                                return;
                            }
                        }
                    }
                }
            }
        }



        System.out.println(0);
    }
}