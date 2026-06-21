import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        int i = 0;
        while(i < n) {
            int cnt = 1;
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            int j = i + 1;
            while(j < n && day >= (int) Math.ceil((100.0 - progresses[j]) / speeds[j])) {
                cnt++;
                j++;
            }
            
            answer.add(cnt);
            i = j;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}