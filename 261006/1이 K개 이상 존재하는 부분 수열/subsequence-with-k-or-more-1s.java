import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
  
// 1과2로만 이루어진 길이 n 수열
// 1이 k개 이상 존재하는 가장 짧은 연속된 부분 수열의 길이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = 1;
        int ans = Integer.MAX_VALUE;
        int curCnt = 0;
        if(arr[0] == 1) curCnt++;
        for(int i = 0; i < n; i++) {
            while(j < n && curCnt < k) {
                if(arr[j] == 1) curCnt++;
                j++;
            }

            if(curCnt >= k) {
                ans = Math.min(ans, j - i);
            }
            if(arr[i] == 1) curCnt--;
        }

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}