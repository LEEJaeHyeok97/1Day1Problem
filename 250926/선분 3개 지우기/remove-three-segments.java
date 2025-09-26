import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    int[] counting = new int[101];
                    boolean flag = false;
                    for(int s = 0; s < n; s++) {
                        if(s == i || s == j || s == k) continue;
                        for(int t = a[s]; t <= b[s]; t++) {
                            counting[t]++;
                        }

                        for(int t = 0; t < 101; t++) {
                            if(counting[t] > 1) {
                                flag = true;
                                break;
                            }
                        }
                        

                        // for(int t = 0; t < 101; t++) {
                        //     System.out.print(counting[t] + " ");
                        // }
                        // System.out.println();

                        
                    }
                    if(flag) continue;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}