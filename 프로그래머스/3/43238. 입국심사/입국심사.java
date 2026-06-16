// n명이 줄지어 입국심사 대기.
// 한 심사대에서는 동시에 한 명만 심사를 할 수 있다.
// 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있다.
// 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있다.
// 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶다.
// n은 1~10^9. 한 명을 심사하는데 걸리는 시간 1~10^9분

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long lo = 1;
        long hi = 0;
        for(int t : times) {
            hi = Math.max(hi, (long) t * n);
        }
        
        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            
            long count = 0;
            for(int t : times) {
                count += (mid / t);
            }
            
            if(count >= n) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return answer;
    }
}