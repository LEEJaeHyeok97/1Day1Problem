import java.util.Scanner;

public class Main {
    static final int MAX_T = 1000000;

    static int n, m;
    static int[] posA = new int[MAX_T + 1];
    static int[] posB = new int[MAX_T + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Please write your code here.
        // A가 매 초마다 서 있는 위치를 기록
        int timeA = 1;
        for(int i = 0; i < n; i++) {
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            while(t-- > 0) {
                if(d == 'R')
                    posA[timeA] = posA[timeA - 1] + 1;
                else
                    posA[timeA] = posA[timeA - 1] - 1;
                timeA++; 
            }
        }

        int timeB = 1;
        for(int i = 0; i < m; i++) {
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            while(t-- > 0) {
                if(d == 'R')
                    posB[timeB] = posB[timeB - 1] + 1;
                else
                    posB[timeB] = posB[timeB - 1] - 1;
                timeB++;
            }
        }

        int ans = -1;
        for(int i = 1; i < timeA; i++) {
            if(posA[i] == posB[i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}