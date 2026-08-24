import java.util.*;

// 고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 설치
// 최소 몇 대의 카메라를 설치?
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int last = Integer.MIN_VALUE;
        int ans = 0;
        for(int[] route : routes) {
            if(route[0] > last) {
                last = route[1];
                ans++;
            }
        }
        
        return ans;
    }
}