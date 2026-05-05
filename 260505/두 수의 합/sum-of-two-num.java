import java.util.*;

// 두 개의 수를 뽑아 더했을 때 K가 되는 가짓수를 구하는 프로그램.
public class Main {

    static int n, k;
    static int[] nums;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            map.put(num, map.get(num) - 1);
            if(map.get(num) == 0) map.remove(num);

            int complement = k - num;
            if(map.containsKey(complement)) {
                ans += map.get(complement);
            }
        }

        System.out.println(ans);
    }
}