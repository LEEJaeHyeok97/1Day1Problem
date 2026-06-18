// 구명보트는 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한이 있다.
// 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값
// 5* 10^4명
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        int left = 0;
        int right = people.length - 1;
        boolean[] visited = new boolean[people.length];
        Arrays.sort(people);
        
        int answer = 0;
        while(left <= right) {
            int w = people[left] + people[right];
            if(w > limit) {
                right -= 1;
            }
            else if(w <= limit) {
                visited[left] = true;
                visited[right] = true;
                answer++;
                left += 1;
                right -= 1;
            }
        }
        
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}