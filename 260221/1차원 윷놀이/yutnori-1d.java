import java.util.*;

// 1부터 m까지 번호순서대로 총 m개 지점이 연결
// K개의 말이 1번 지점에 놓여있음.
// N번의 턴에 걸쳐 숫자가 주어지고 각 턴마다 하나의 말을 선택하여 숫자만큼 나아갈 수 있다.
// 숫자 m에 도달한 말을 선택할 수 있지만 아무런 변화가 일어나지 않는다. 
// n번의 턴에 대해 말들을 적당히 움직여 얻을 수 있는 점수 중 최댓값을 구하는 프로그램.
public class Main {

    static int n, m, k; // 턴의 수, 윷놀이 판의 상태, 말의 수
    static int ans = 0;
    static int[] nums; // 각 턴마다 나아갈 수 있는 거리
    static int[] pos;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        pos = new int[k + 1];
        for(int i = 0; i < k + 1; i++) {
            pos[i] = 1;
        }

        
        backtracking(0);

        System.out.println(ans);
    }

    static void backtracking(int cnt) {
        if(cnt == n) {
            ans = Math.max(ans, calc());
            return;
        }

        for(int i = 1; i <= k; i++) {
            arr.add(i);
            int prev = pos[i];
            pos[i] = Math.min(m, pos[i] + nums[cnt]);
            backtracking(cnt + 1);
            arr.remove(arr.size() - 1);
            pos[i] = prev;
        }
    }

    static int calc() {
        int total = 0;
        for(int i = 1; i <= k; i++) {
            if(pos[i] >= m) total++;
        }

        return total;
    }
}