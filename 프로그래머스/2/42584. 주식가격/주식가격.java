import java.util.*;

class Solution {
    
    static LinkedList<Integer> st = new LinkedList<>();
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int j = 0;
        for(int price : prices) {
            if(st.isEmpty()) {
               st.add(j++); 
                continue;
            } 
            while(!st.isEmpty() && prices[st.peekLast()] > price) {
                int i = st.pollLast();
                answer[i] = j - i;
            }
            st.add(j++);
        }
        
        while(!st.isEmpty()) {
            int i = st.pollLast();
            answer[i] = prices.length - 1 - i;
        }
        
        return answer;
    }
}