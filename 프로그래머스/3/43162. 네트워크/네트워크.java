import java.util.*;

// 컴퓨터의 개수 n, 연결정보 computers
// 네트워크의 개수
class Solution {
    
    static int[][] graph;
    static boolean[] visited;
    static int[][] computers;
    static int answer = 0;
    static int n;
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;
        visited = new boolean[n];
        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int curV) {
        visited[curV] = true;
        for(int i = 0; i < n; i++) {
            if(graph[curV][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}