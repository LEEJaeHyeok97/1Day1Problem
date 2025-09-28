import java.util.Scanner;
public class Main {

    static char[] arr = new char[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 0; i < T; i++) {
            char c = sc.next().charAt(0);
            int pos = sc.nextInt();
            arr[pos] = c;
        }
        // Please write your code here.
        int ans = 0;
        for(int i = a; i <= b; i++) {
            int rs = checkRightS(i);
            int ls = checkLeftS(i);
            int tmpS = Math.min(Math.abs(i - rs), Math.abs(i - ls));

            int rn = checkRightN(i);
            int ln = checkLeftN(i);
            int tmpN = Math.min(Math.abs(i - rn), Math.abs(i - ln));

            // System.out.println(tmpS + " " + tmpN);
            if(tmpS <= tmpN) ans++;
        }
        
        System.out.println(ans);
    }

    static int checkRightS(int cur) {
        for(int i = cur; i < 1001; i++) {
            if(arr[i] == 'S') {
                return i;
            }
        }
        return 1002;
    }

    static int checkLeftS(int cur) {
        for(int i = cur; i > 0; i--) {
            if(arr[i] == 'S') {
                return i;
            }
        }
        return 1002;
    }

    static int checkRightN(int cur) {
        for(int i = cur; i < 1001; i++) {
            if(arr[i] == 'N') {
                return i;
            }
        }
        return 1002;
    }

    static int checkLeftN(int cur) {
        for(int i = cur; i > 0; i--) {
            if(arr[i] == 'N') {
                return i;
            }
        }
        return 1002;
    }
}