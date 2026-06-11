// n개의 송전탑 트리 형태로 연결됨. 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할.
// 두 전력망이 갖게되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
import java.util.*;
class Solution {
    static int n;
    static int answer;
    static int[][] wires;
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;
        answer = Integer.MAX_VALUE;
        visited = new boolean[n + 1];
        
        for(int i = 0; i < wires.length; i++) {
            graph = new HashMap<>();
            int idx = 0;
            for(int node = 0; node <= n; node++) {
                graph.put(node, new ArrayList<>());
            }
            for(int j = 0; j < wires.length; j++) {
                if(j==i) continue;
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }
            resetVisited();
            int diff = dfs(1);
            answer = Math.min(answer, Math.abs(n - diff - diff));
        }
        
        
        return answer;
    }
    
    static int dfs(int curNum) {
        List<Integer> tmp = graph.get(curNum);
        visited[curNum] = true;
        int cnt = 1;
        for(int i = 0; i < tmp.size(); i++) {
            if(!visited[tmp.get(i)]) {
                visited[tmp.get(i)] = true;
                cnt += dfs(tmp.get(i));
            }
        }
        
        return cnt;
    }
    
    static void resetVisited() {
        for(int i = 0; i < n + 1; i++) {
            visited[i] = false;
        }
    }
}