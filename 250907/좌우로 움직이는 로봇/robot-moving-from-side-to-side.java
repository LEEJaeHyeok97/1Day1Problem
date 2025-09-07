import java.util.Scanner;

// A 움직이는 횟수 N // B->M
// 다른 지점에 있다가 만나게 되는 경우가 몇 번인지
public class Main {

    static final int MAX_WALK = 2000001;
    static final int OFFSET = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] A = new int[MAX_WALK];
        A[0] = OFFSET;
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.

            while (t-- > 0) {
                if (d == 'L') {
                    A[timeA++] = A[timeA - 1] - t;
                } else {
                    A[timeA++] = A[timeA - 1] + t;
                }
            }
        }
        
        int[] B = new int[MAX_WALK];
        B[0] = OFFSET;
        int timeB = 1;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.

            while (t-- > 0) {
                if (d == 'L') {
                    B[timeB++] = B[timeB - 1] - t;
                } else {
                    B[timeB++] = B[timeB - 1] + t;
                }
            }
        }
        
        // Please write your code here.
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] == B[i] && (A[i - 1] == A[i] || B[i - 1] == B[i])) {
                continue;
            }
            if (A[i] == B[i]) {
                answer +=1;
            }
        }

        System.out.println(answer);
    }
}