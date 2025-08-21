import java.util.*;
import java.io.*;

class Solution {
    
    static PriorityQueue<Integer> tmp;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int[] solution(String[] operations) {
        StringTokenizer st;
        
        for(int si = 0; si < operations.length; si++) {
            st = new StringTokenizer(operations[si]);
            
            String command = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            
            // System.out.println(command + " " + number);
            if (command.equals("I")) {
                pq.add(number);
            } else if (command.equals("D") && number == 1 && pq.size() > 0) {
                tmp = new PriorityQueue<>();
                int s = pq.size();
                for (int i = 0; i < s; i++) {
                    tmp.add(-pq.poll());
                }
                tmp.poll();
                s = tmp.size();
                for (int i = 0; i < s; i++) {
                    pq.add(-tmp.poll());
                }
                // System.out.println(pq.size());
                // System.out.println(pq.peek());
            } else if (command.equals("D") && number == -1 && pq.size() > 0) {
                int t = pq.poll();
            } else {
                continue;
            }
        }
        
        
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int t = pq.size();
        if (pq.size() == 0) {
            int[] answer = {0, 0};
            return answer;
        }
        for(int i = 0; i < t; i++) {
            int tmpValue = pq.poll();
            if (tmpValue >= max) {
                max = tmpValue;
            }
            if (tmpValue <= min) {
                min = tmpValue;
            }
        }
        int[] answer = {max, min};
        return answer;
    }
}