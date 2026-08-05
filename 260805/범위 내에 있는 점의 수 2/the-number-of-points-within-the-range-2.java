import java.util.*;

// 누적합을 구하는 배열을 작성하여 점이 있으면 1을 더한다.
// 구간에 점이 몇 개 있는지 구할 때 해당 범위(l,r) r-l + points(l);
public class Main {

    static int[] prefixSum = new int[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            prefixSum[pos] += 1;
        }

        prefixSum[0] = 0;
        for(int i = 1; i < 1000001; i++) {
            prefixSum[i] += prefixSum[i-1];
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a > 0) {
                System.out.println(prefixSum[b] - prefixSum[a - 1]);
            } else {
                System.out.println(prefixSum[b]);
            }
        }
    }
}