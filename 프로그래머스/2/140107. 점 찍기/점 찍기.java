// 원점과의 거리 <= d
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long dd = (long)d*d; // dd = (x - 0)^2 + (y - 0)^2
        for(int x = 0; x <= d; x+=k) {
            long rest = dd - (long)x*x;
            long y = (long) Math.sqrt(rest);
            // 4 / 2 -> 2
            // 1.99999 -> 1, 2
            while(y*y > rest) y--;
            while((y+1)*(y+1) <= rest) y++;
            
            answer += y/k + 1;
        }
        return answer;
    }
}