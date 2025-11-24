import java.util.Scanner;
// 1 5 6
// 1 4 5
// 1 3 4
// 1 2 3
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        int ans = 0;
        while(!isSeq(a, b, c)) {
            if(b - a >= c - b) {
                c = b;
                b = a+1;
            } else {
                a = b;
                b = c-1;
            }
            ans++;
        }

        System.out.println(ans);
    }

    static boolean isSeq(int a, int b, int c) {
        if(a + 1 == b && b + 1 == c) return true;

        return false;
    }
}