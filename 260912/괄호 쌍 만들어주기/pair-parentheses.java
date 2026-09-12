import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        // 연속한 ((, )) 쌍을 이룰 수 있는 다른 가지수
        int[] r = new int[A.length()];
        r[r.length - 1] = 0;
        for(int i = r.length - 2; i >= 0; i--) {
            if(A.charAt(i) == ')' && A.charAt(i+1) == ')') {
                r[i] = r[i+1] + 1;
            } else {
                r[i] = r[i+1];
            }
        }
        
        long ans = 0;
        for(int i = 0; i < A.length() - 3; i++) {
            if(A.charAt(i) == '(' && A.charAt(i + 1) == '(') {
                ans += r[i+2];
            }
        }

        System.out.println(ans);
    }
}