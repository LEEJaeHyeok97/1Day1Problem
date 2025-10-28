import java.util.Scanner;
// N개의 수에 칸막이 M - 1 개를 두어 M개의 구간을 만든다
// 구간 합들 중 최댓값이 최소가 되도록 하는 프로그램
public class Main {

    static int MAX_N = 10;
    static int MAX_A = 10000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        // Please write your code here.
        
        int ans = MAX_A;
        for(int i = 0; i < MAX_A; i++) {
            boolean possible = true;
            int section = 1;

            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(nums[j] > i) {
                    possible = false;
                    break;
                }

                if(cnt + nums[j] > i) {
                    cnt = 0;
                    section++;
                }

                cnt += nums[j];
            }

            if(possible && section <= m) {
                ans = Math.min(ans, i);
            }
        }

        System.out.println(ans);
    }
}