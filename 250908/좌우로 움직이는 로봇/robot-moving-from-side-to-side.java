import java.util.Scanner;

// A 움직이는 횟수 N // B->M
// 다른 지점에 있다가 만나게 되는 경우가 몇 번인지
public class Main {

    static final int MAX_WALK = 2000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] A = new int[MAX_WALK + 1];
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.

            while (t-- > 0) {
                if (d == 'L') {
                    A[timeA] = A[timeA - 1] - 1;
                } else {
                    A[timeA] = A[timeA - 1] + 1;
                }
                timeA++;
            }
        }
        
        int[] B = new int[MAX_WALK + 1];
        int timeB = 1;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.

            while (t-- > 0) {
                if (d == 'L') {
                    B[timeB] = B[timeB - 1] - 1;
                } else {
                    B[timeB] = B[timeB - 1] + 1;
                }
                timeB++;
            }
        }

        if (timeA < timeB) {
            for(int i = timeA; i < timeB; i++) {
                A[i] = A[timeA - 1];
            }
        } else if(timeA > timeB) {
            for(int i = timeB; i < timeA; i++) {
                B[i] = B[timeB - 1];
            }
        }
        
        // Please write your code here.
        int totalTime = Math.max(timeA, timeB);
        int answer = 0;

        for (int i = 1; i < totalTime; i++) {
            if (A[i] == B[i] && A[i-1] != B[i-1])
                answer++;
        }

        System.out.println(answer);
    }
}