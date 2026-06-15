
// 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶다.
// 스코빌 지수가 가장 낮은 두개의 음식을 섞어 새로운 음식을 만든다.
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 스코빌 지수 + (두 번재로 맵지 않은 음식의 스코빌지수 *2)
// 모든 음식의 스코빌 지수가 K이상이 될 때까지 반복하여 섞는다.
import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        for(int food : scoville) {
            pq.add(food);
        }
        int answer = 0;
        while(pq.peek() < K) {
            if(pq.size() == 1 && pq.peek() < K) {
                answer = -1;
                break;
            }
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b * 2);
            answer++;
        }
        
        return answer;
    }
}