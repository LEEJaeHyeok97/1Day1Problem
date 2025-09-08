import java.util.Scanner;
// A: N번, B: 번
// 매 시간마다 현재 선두인 사람들을 모아 명예의 전당에 이름을 올려준다.
// 명예의 전당에 올라간 사람의 조합이 총 몇 번 바뀌었는지 출력
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
        }
        // Please write your code here.

        int[] arrA = new int[1000001];
        int timeA = 1;
        for(int i = 0; i < n; i++) {
            int v = a[i][0];
            int t = a[i][1];

            for(int ti = 0; ti < t; ti++) {
                arrA[timeA] = arrA[timeA - 1] + v;
                timeA++;
            }
        }

        int[] arrB = new int[1000001];
        int timeB = 1;
        for(int i = 0; i < m; i++) {
            int v = b[i][0];
            int t = b[i][1];

            for(int ti = 0; ti < t; ti++) {
                arrB[timeB] = arrB[timeB - 1] + v;
                timeB++;
            }
        }

        int[] rank = new int[1000001]; // 1: A, 2: B, 3: A,B
        int totalTime = Math.max(timeB, timeA);
        for(int i = 0; i < totalTime; i++) {
            if(arrA[i] > arrB[i]) {
                rank[i] = 1;
            } else if(arrA[i] < arrB[i]) {
                rank[i] = 2;
            } else {
                rank[i] = 3;
            }
        }

        int ans = 0;
        for(int i = 1; i < totalTime; i++) {
            if(rank[i] != rank[i-1])
                ans+=1;
        }

        System.out.println(ans);
    }
}