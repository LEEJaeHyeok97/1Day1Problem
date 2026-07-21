import java.util.*;

// 모든 섬이 서로 통행 가능하도록 하는 최소비용
// 연결되는 두 섬의 번호, 비용
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int edges = 0;
        for(int[] c : costs) {
            if(union(c[0], c[1])) {
                answer += c[2];
                if(++edges == n - 1) break;
            }
        }
        return answer;
    }
    
    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if(ra == rb) return false;
        parent[rb] = ra;
        return true;
    } 
}