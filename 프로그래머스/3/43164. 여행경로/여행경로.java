// 항상 ICN공항에서 출발.
// 주어진 항공권을 모두 이용.
// bfs
import java.util.*;

class Solution {
    static ArrayList<Integer> used = new ArrayList<>();
    static int ticketCnt;
    static String curNation;
    static String[][] tickets;
    static ArrayList<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        ticketCnt = tickets.length;

        curNation = "ICN";
        answer.add("ICN");
        Arrays.sort(tickets, (a, b) -> {
        if (a[0].equals(b[0])) {
            return a[1].compareTo(b[1]);
        }
            return a[0].compareTo(b[0]);
        });
        
        dfs(curNation);
        
        return answer.toArray(String[]::new);
    }
    
    static void dfs(String cur) {
        for(int i = 0; i < ticketCnt; i++) {
            if(!used.contains(i) && (cur.equals(tickets[i][0]))) {
                curNation = tickets[i][1];
                answer.add(tickets[i][1]);
                used.add(i);
                dfs(tickets[i][1]);
                if(ticketCnt + 1 == answer.size()) return;
                answer.remove(answer.size() - 1);
                used.remove(used.size() - 1);
            }
        }
    }
}