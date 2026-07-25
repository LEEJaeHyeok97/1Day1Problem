import java.util.*;

// 1~N까지 번호표를 든 N명의 사람. i번 사람은 ai시간에 정원 입구 도착, ti 머무르다 간다.
// 정원에는 한 번에 한 명의 사람만이 들어갈 수 있다. i번 사람이 정원 입구에 도착했을 때,
// 기다렸다 정원을 출입할 수 있다. 번호표의 숫자가 작은 사람부터 들어갈 수 있다.
// 모든 사람이 정원을 한 번씩 들려서 머물렀다 갈 때, 가장 오래 기다려야 하는 사람이
// 기다리는 시간을 구하시오.
class Tuple {
    int arrive;
    int time;
    int num;

    public Tuple(int arrive, int time, int num) {
        this.arrive = arrive;
        this.time = time;
        this.num = num;
    }
}

// 정원에 도착하는 시점, 정원을 다 돌아본 시점, 정원에 대기하는 시점 
public class Main {

    static ArrayList<Tuple> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int t = sc.nextInt();

            arr.add(new Tuple(a, t, i));
        }

        arr.sort(Comparator.comparingInt(t -> t.arrive));
        int idx = 0;

        int cur = 0;
        boolean flag = false;
        int[] w = new int[n + 1];
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.num));
        while(idx < n || !pq.isEmpty()) {
            while(idx < n && arr.get(idx).arrive <= cur) {
                pq.add(arr.get(idx));
                idx++;
            }

            if(pq.isEmpty()) {
                cur = arr.get(idx).arrive;
                continue;
            }

            Tuple tpl = pq.poll();
            w[tpl.num] = cur - tpl.arrive;
            cur += tpl.time;
        }

        int ans = 0;
        for(int i = 0; i < n + 1; i++) {
            ans = Math.max(ans, w[i]);
        }

        System.out.println(ans);
    }
}