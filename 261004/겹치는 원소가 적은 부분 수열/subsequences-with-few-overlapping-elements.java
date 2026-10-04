import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 같은 원소가 k개 이하로 들어 있는 가장 긴 연속 부분 수열의 길이
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MIN_VALUE;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            while(j < n && map.getOrDefault(arr[j], 0) < k) {
                map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
                j++;
            }

            map.put(arr[i], map.get(arr[i]) - 1);
            ans = Math.max(ans, j - i);
        }

        System.out.println(ans);
    }
}