class Solution {
    
    static int[] diffs;
    static int[] times;
    static long limit;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        int left = 1;
        int right = 100000;
        
        while(left < right) {
            int mid = (left + right) / 2; // 레벨
            if(canSolve(mid)) {
                // 가능하면 더 낮춰보기
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    static boolean canSolve(int mid) {
        long cost = 0;
        int time_prev = 0;
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= mid) {
                cost += times[i];
            } else {
                cost += (times[i] + time_prev) * (diffs[i] - mid) + times[i];
            }
            time_prev = times[i];
        }
        
        if(cost <= limit) return true;
        return false;
    }
}