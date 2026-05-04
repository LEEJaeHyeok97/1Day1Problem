import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length / 2; i++) {
            int temp = citations[i];
            citations[i] = citations[citations.length - 1 - i];
            citations[citations.length - 1 - i] = temp;
        }
        
        boolean flag = false;
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= i + 1) {
                continue;
            } else {
                flag = true;
                answer = i;
                break;
            }
        }
        if(!flag) return citations.length;
        
        return answer;
    }
}