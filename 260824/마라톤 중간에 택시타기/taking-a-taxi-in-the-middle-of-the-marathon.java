import java.util.Scanner;

// n개의 체크포인트 존재. 1번부터 모든 체크 포인트를 순서대로 방문 후 N번에서 끝남.
// 1과 N은 건너뛰지 않으면서 체크포인트 하나를 건너 뛰어서 마라톤을 완주하려할 때
// 최소 거리를 구하는 프로그램 작성
// |x1 - x2| + |y1 - y2|
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int[] prefixSumL = new int[n];
        prefixSumL[0] = 0;
        int[] prefixSumR = new int[n];
        prefixSumR[n-1] = 0;
        for(int i = 1; i < n; i++) {
            prefixSumL[i] = prefixSumL[i - 1] + Math.abs(x[i] - x[i-1]) + Math.abs(y[i] - y[i-1]);
        }
        for(int i = n-2; i >= 0; i--) {
            prefixSumR[i] = prefixSumR[i + 1] + Math.abs(x[i] - x[i+1]) + Math.abs(y[i] - y[i+1]);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n - 1; i++) {
            int tmp = prefixSumL[i-1] + prefixSumR[i+1] + Math.abs(x[i-1] - x[i+1]) + Math.abs(y[i-1] - y[i+1]);
            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
    }
}