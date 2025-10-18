import java.util.Scanner;
// 같은 정수가 부여된 폭탄끼리 거리가 K 안에 있다면 폭발하게 된다.
public class Main {
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++)
            bombs[i] = sc.nextInt();
        // Please write your code here.
        int[] arr = new int[1000001];
        boolean[] bombed = new boolean[101];

        for(int i = 0; i < n; i++) {
            boolean flag = false;
            for(int j = i+1; j < n; j++) {
                if(j < i+k+1)
                {if(bombs[i] == bombs[j]) {
                    flag = true;
                    arr[bombs[i]]++;
                    bombed[i] = true;
                    bombed[j] = true;
                }}
            }

            if(flag) arr[bombs[i]]++; 
        }

        
        int tmp = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > tmp) {
                 ans = i;
                 tmp = arr[i];
            }
        }

        System.out.println(ans);
    }
}