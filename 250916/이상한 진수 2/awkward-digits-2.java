import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < a.length(); i++) {
            int[] arr = new int[a.length()];
            int num = Integer.parseInt(String.valueOf(a.charAt(i)));

            for(int j = 0; j < a.length(); j++) {
                int tmp = Integer.parseInt(String.valueOf(a.charAt(j)));
                if(i == j) {
                    if(tmp == 1) tmp = 0;
                    else tmp = 1;
                } 
                arr[j] = tmp;
            }
            // for(int j= 0; j < a.length(); j++) {
            //     System.out.print(arr[j] + " ");
            // }
            // System.out.println();
            int v = 0;
            int cnt = arr.length;
            for(int j = 0; j < a.length(); j++) {
                int t2 = 1;
                for(int k = 1; k < cnt; k++) t2 *=2;
                v += t2 * arr[j];
                cnt-=1;
            }
            ans = Math.max(ans, v);
        }
        System.out.println(ans);
    }
}