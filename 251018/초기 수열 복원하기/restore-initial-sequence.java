import java.util.Scanner;
// 길이  N 수열 A
// 인접한 원소의 합을 순서대로 구한 N-1개의 숫자가 주어졌을때,
// 초기수열 A를 복원하라
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            a[i] = sc.nextInt();
        // Please write your code here.
        // 초기 숫자 : 1
        // 1 3 3 -> X
        // 초기 숫자 : 2
        // 2 2 -> X
        // 초기 숫자 : 3
        // 3 1 5 2 4
        int[] arr = new int[n];
        for(int i = 1; i < 1001; i++) {
            arr[0] = i;
            int idx = 1;
            boolean flag = false;
            int[] visited = new int[n+1];
            for(int j = 0; j < n-1; j++) {
                int val = a[j] - arr[idx - 1];
                if(val <= 0) {
                    flag = true;
                    break;
                }
                if(visited[val] == 1) {
                    flag = true;
                    break;
                }
                arr[idx] = val;
                visited[val] = 1;
                idx++;
            }

            if(flag) {
                continue;
            }

            for(int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            return;
        }

        
    }
}