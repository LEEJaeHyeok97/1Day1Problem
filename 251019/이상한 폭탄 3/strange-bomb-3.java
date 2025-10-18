import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++)
            bombs[i] = sc.nextInt();
        // Please write your code here.
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < i + k + 1; j++) {
                if(inRange(j) && bombs[i] == bombs[j]) {
                    visited[i] = true;
                    visited[j] = true;
                }
            }
        }

        int[] cntList = new int[1000001];
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                cntList[bombs[i]]++;
            }
        }

        int ans = 0;
        int tmp = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(cntList[i] > tmp) {
                ans = i;
                tmp = cntList[i];
            }
        }

        System.out.println(ans);
    }

    static boolean inRange(int num) {
        return num < n;
    }
}