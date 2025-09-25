import java.util.Scanner;
// N명 M개치즈 
// 몇번째 사람/ 몇번째 치즈/ 언제먹었는지 초
// 1 -> 1, 2, 3, 4
// 2 -> 1, 2
// 3 -> 1
// ::: 1번이 3초에 2번이 8초에 아픔
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();
        int[][] arr = new int[51][51];
        for (int i = 0; i < D; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            arr[p][m] = t;
        }
        // for(int i = 0; i < 51; i++) {
        //     for(int j = 0; j < 51; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int[] candidates = new int[51];
        for (int i = 0; i < S; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();

            int[] tmp = arr[p];
            for(int j = 0; j < 51; j++) {
                if(tmp[j] < t && tmp[j] != 0 && tmp[j] != -1) {
                    candidates[j] = 1;
                } else {
                    candidates[j] = -1;
                }
            }
        }
        // Please write your code here.
        int ans[] = new int[51];
        for(int i = 0; i < 51; i++) {
            if(candidates[i] > 0) {
                for(int j = 0; j < 51; j++) {
                    if(arr[j][i] > 0) {
                        ans[j] = 1;
                    }
            }
            }
        }

        int cnt = 0;
        for(int i = 0; i < 51; i++) {
            if(ans[i] == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}