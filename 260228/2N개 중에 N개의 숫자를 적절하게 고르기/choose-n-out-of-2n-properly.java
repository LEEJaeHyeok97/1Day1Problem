import java.util.*;

// 2n개의 정수 수열 A가 주어졌을 때, 주어진 수를 각각 n개씩 2그룹으로 나눠
// 각 그룹 원소합의 차가 최소가 되도록 하는 프로그램
public class Main {

    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;

    static ArrayList<Integer> selected = new ArrayList<>(); // 인덱스 저장
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }

        choose(0, 0);

        System.out.println(ans);
    }

    static void choose(int curNum, int cnt) {
        if(cnt == n) {
            ans = Math.min(ans, calc());

            return;
        }
        if(curNum == arr.length - 1) return;

        choose(curNum + 1, cnt);

        selected.add(curNum);
        choose(curNum + 1, cnt + 1);
        selected.remove(selected.size() - 1);
    }

    static int calc() {
        int t1 = 0;
        int t2 = 0;

        boolean flag = false;
        for(int i = 0; i < arr.length; i++) {
            flag = false;
            for(int j = 0; j < selected.size(); j++) {
                if(i == selected.get(j)) {
                    t1 += arr[i];
                    flag = true;
                    break;
                }
            }

            if(!flag) t2 += arr[i];
        }
        // System.out.println("===");
        // System.out.println(t1);
        // System.out.println(t2);
        return Math.abs(t1 - t2);
    }
}