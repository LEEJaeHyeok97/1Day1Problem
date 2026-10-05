import java.util.Arrays;
import java.util.Scanner;
public class Main {

    static int[] stations;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] fires = new int[n];
        stations = new int[m];
        for (int i = 0; i < n; i++)
            fires[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            stations[i] = sc.nextInt();

        Arrays.sort(stations);

        // 소방서 배열을 정렬한다.
        // 화재 위치를 하나씩 꺼낸다.
        // 화재 위치 x를 정렬된 소방서 배열에서 lowerbound로 탐색 -> idx
        // stations[idx]와 stations[idx - 1]중 x와 더 가까운 거리를 구한다
        // 그 거리들 중 최댓값을 계속 갱신한다.

        int j = 0;
        long ans = Long.MIN_VALUE;
        for(int i = 0; i < fires.length; i++) {
            int idx = lowerBound(fires[i]);

            long best = Long.MAX_VALUE;
            if(idx > 0) {
                best = Math.min(best, Math.abs((long) stations[idx - 1] - fires[i]));
            }
            if(idx < m) {
                best = Math.min(best, Math.abs((long) stations[idx] - fires[i]));
            }
            ans = Math.max(ans, best);
        }

        System.out.println(ans);
    }

    static int lowerBound(int target) {
        // target 이상인 첫 인덱스를 stations에서 찾는다.
        int left = 0;
        int right = stations.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(stations[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}