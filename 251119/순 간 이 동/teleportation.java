import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        // Please write your code here.
        // A -> B
        // A -> X -> Y -> B
        // A -> Y -> X -> B
        int ans = Integer.MAX_VALUE;
        int tmp1 = Math.abs(A - B);
        int tmp2 = Math.abs(A - X) + Math.abs(Y - B);
        int tmp3 = Math.abs(Y - A) + Math.abs(X - B);
        ans = Math.min(tmp1, Math.min(tmp2, tmp3));
        
        System.out.println(ans);
    }
}