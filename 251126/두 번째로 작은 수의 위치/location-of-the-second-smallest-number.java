import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        Set<Integer> s = new HashSet<Integer>(Arrays.asList(arr));
        if(s.size() == 1) {
            System.out.println(-1);
            return;
        }
        // System.out.println(s);
        Integer[] filteredArr = s.toArray(new Integer[0]);
        // System.out.println(filteredArr);
        Arrays.sort(filteredArr, (a,b) -> a-b);
        
        int cnt = 0;
        int ans = 0;
        for(int i = 0; i < N; i++) {
            if(arr[i] == filteredArr[1] && cnt == 0) {
                ans = i;
            }
            if(arr[i] == filteredArr[1]) {
                cnt++;
            }
        }

        if(cnt >= 2) {
            System.out.println(-1);
            return;
        }

        System.out.println(ans + 1);
    }
}