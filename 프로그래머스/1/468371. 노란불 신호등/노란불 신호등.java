import java.util.*;

// n개 신호등. 신호등은 항상 초 -> 노 -> 빨
// 각 신호의 지속 시간은 신호등마다 다르다.
// 각 신호등은 처음에는 초록불 상태로 시작 시간은 1초부터 시작
// 모든 신호등이 노란불이 되면 정전 발생
// 모든 신호등이 노란불이 되는 가장 빠른 시각을 리턴(존재하지 않는다면 -1)
class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int n = signals.length;
        
        int cycle = 1;
        for (int[] s : signals) {
            cycle = lcm(cycle, s[0] + s[1] + s[2]);
        }
        
        for (int t = 1; t <= cycle; t++) {
            boolean allYellow = true;
            for (int[] s : signals) {
                int period = s[0] + s[1] + s[2];
                long pos = (t - 1) % period;      // 0-based 주기 내 위치
                if (pos < s[0] || pos >= s[0] + s[1]) {  // 노란불 구간 [g, g+y)
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return (int) t;
        }
        
        return -1;
    }
    
    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
    
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}