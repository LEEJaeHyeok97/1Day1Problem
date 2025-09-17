import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here. 8 + 12 + 12 + 16 = 48
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            boolean[] visited = new boolean[arr.length];
            int it = i;
            int tmp = 0;
            int cnt = 0;
            while(visited[it] == false) {
                tmp += (cnt++ * arr[it]);
                visited[it] = true;
                it = (it + 1) % arr.length;
            }
            ans = Math.min(ans, tmp);
        }
        System.out.println(ans);
        
    }
}