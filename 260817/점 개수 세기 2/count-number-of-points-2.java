import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedInputStream(System.in));

        st.nextToken(); int n = (int) st.nval;
        st.nextToken(); int q = (int) st.nval;

        int[] dx = new int[n];
        int[] dy = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken(); dx[i] = (int) st.nval;
            st.nextToken(); dy[i] = (int) st.nval;
        }

        int[] px = dx.clone();
        int[] py = dy.clone();
        Arrays.sort(px);
        Arrays.sort(py);

        int[][] prefixSum = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            int r = upperBound(px, n, dx[i]);
            int c = upperBound(py, n, dy[i]);
            prefixSum[r][c]++;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] += prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st.nextToken(); int x1 = (int) st.nval;
            st.nextToken(); int y1 = (int) st.nval;
            st.nextToken(); int x2 = (int) st.nval;
            st.nextToken(); int y2 = (int) st.nval;

            int ax = lowerBound(px, n, x1);
            int bx = upperBound(px, n, x2);
            int ay = lowerBound(py, n, y1);
            int by = upperBound(py, n, y2);

            sb.append(prefixSum[bx][by] - prefixSum[ax][by]
                    - prefixSum[bx][ay] + prefixSum[ax][ay]).append('\n');
        }

        System.out.print(sb);
    }

    static int upperBound(int[] arr, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    static int lowerBound(int[] arr, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}