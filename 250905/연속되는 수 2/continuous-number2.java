import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        ArrayList<Integer> li = new ArrayList<>();
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                li.add(cnt);
                cnt = 1;
            } else {
                cnt += 1;
            }
        }
        li.add(cnt);

        System.out.println(Collections.max(li));
    }
}