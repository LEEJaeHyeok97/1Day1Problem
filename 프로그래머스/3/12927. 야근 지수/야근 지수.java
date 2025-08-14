import java.util.*;
import java.io.*;

//야근 피로도 = 남은 일의 작업량의 제곱을 더한 값.
// N시간 동안 야근 피로도를 최소화하도록 일함
// Demi가 1시간 동안 작업량 1만큼 처리
// 퇴근까지 남은 시간 N 과 각 일에 대한 작업량 works에 대해
// 야근 피로도를 최소화한 값을 리턴하는 함수 작성하시오.
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public long solution(int n, int[] works) {
        
        for(int i = 0; i < works.length; i++) {
            pq.add(-works[i]);
        }
        
        for(int i = 0; i < n; i++) {
            int number = -pq.poll();
            number -= 1;
            if (number <= 0) {
                pq.add(0);
            } else {
                pq.add(-number);
            }
            
        }
        
        
        long answer = 0;
        int tmp_size = pq.size();
        for(int i = 0; i < tmp_size; i++) {
            int number = -pq.poll();
            answer += (number) * (number);
        }
            
        return answer;
    }
}




