import java.util.*;
// n개의 정수가 입력으로 주어지고, 서로 다른 세 개의 위치를 골라 세 수를 더했을 때
// K가 되는 서로 다른 조합의 개수를 출력
// 주어지는 숫자들은 중복 가능.
public class Main {

    static int n, k;
    static int[] arr;
    static HashMap<Integer, Integer> freq = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(!freq.containsKey(arr[i]))
                freq.put(arr[i], 1);
            else
                freq.put(arr[i], freq.get(arr[i]) + 1);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(!freq.containsKey(arr[i]))
                freq.put(arr[i], -1);
            else
                freq.put(arr[i], freq.get(arr[i]) - 1);

            for(int j = 0; j < i; j++) {
                if(freq.containsKey(k - arr[i] - arr[j]))
                    ans += freq.get(k - arr[i] - arr[j]);
            }
        }

        System.out.println(ans);
    }
}