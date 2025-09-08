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
                    A[timeA++] = A[timeA - 1] - 1;
                } else {
                    A[timeA++] = A[timeA - 1] + 1;
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
                    B[timeB++] = B[timeB - 1] - 1;
                } else {
                    B[timeB++] = B[timeB - 1] + 1;
                }
            }
        }
        
        // Please write your code here.
        int totalTime = Math.max(timeA, timeB);
        for (int i = timeA; i < totalTime; i++) A[i] = A[timeA - 1];
        for (int i = timeB; i < totalTime; i++) B[i] = B[timeB - 1];

        int answer = 0;
        for (int i = 1; i < totalTime; i++) {
            int a0 = A[i - 1], b0 = B[i - 1];
            int a1 = A[i], b1 = B[i];

            boolean meetNow = (a0 != b0) &&( (a1 == b1) || (a0 < b0 && a1 > b1)
            || (a0 > b0 && a1 < b1));
            if(meetNow) answer++;
        }

        System.out.println(answer);
    }
}