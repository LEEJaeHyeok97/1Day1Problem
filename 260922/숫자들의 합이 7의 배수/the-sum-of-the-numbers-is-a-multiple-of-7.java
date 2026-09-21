import java.util.*;

// n개의 서로 다른 수. 연속하게 고른 수들의 합이 7의 배수가 되게 그룹으로
// 만든 그룹 중 최대 크기를 구하는 프로그램.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long[] prefixSum = new long[n+1];
        prefixSum[0] = 0;
        prefixSum[1] = nums[0];
        for(int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1]; 
        }

        int[] first = new int[7];
        Arrays.fill(first, -1);

        int answer = 0;
        for(int i = 0; i <= n; i++) {
            int r = (int) (prefixSum[i] % 7);
            if(first[r] == -1) {
                first[r] = i;
            } else {
                answer = Math.max(answer, i - first[r]);
            }
        }

        System.out.println(answer);
    }
}