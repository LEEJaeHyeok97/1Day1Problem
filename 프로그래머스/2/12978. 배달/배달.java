// N개의 마을 
// 양방향으로 통행
// 도로를 지날 때 걸리는 시간은 도로별로 다르다.
// n개 마을 중 k 시간 이하로 배달이 가능한 마을에서만 주문을 
// n개의 마을 중 k 시간 이하로 배달이 가능한 마을에서만 주문을 받으려 한다.
// 1번 마을에 있는 음식점에서 각 마을로 음식 주문을 받을 수 있는 마을의 개수를 리턴
// dfs
import java.util.*;

class Pair {
    int v;
    int weight;
    
    public Pair(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

class Solution {
    static int N, K;
    static int cost = 0;
    
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] visited;
    static HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
    static HashSet<Integer> set = new HashSet<>();
    public int solution(int N, int[][] road, int K) {
        this.N = N;
        this.K = K;
        
        int answer = 0;
        visited = new int[N + 1];
        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int w = r[2];
            if(map.get(a) != null) {
                map.get(a).add(new Pair(b, w));
            } else {
                map.put(a, new ArrayList<>());
                map.get(a).add(new Pair(b, w));
            }
            
            if(map.get(b) != null) {
                map.get(b).add(new Pair(a, w));
            } else {
                map.put(b, new ArrayList<>());
                map.get(b).add(new Pair(a, w));
            }
        }

        visited[1] = 1;
        set.add(1);
        backtracking(1);

        answer = set.size();
        return answer;
    }
    
    static void backtracking(int cur) {
        if(cost > K) {
            return;
        }
        
        for(Pair p : map.getOrDefault(cur, new ArrayList<>())) {
            if(visited[p.v] == 0) {
                if(cost + p.weight <= K) {
                    visited[p.v] = 1;
                    cost += p.weight;
                    backtracking(p.v);
                    visited[p.v] = 0;
                    cost -= p.weight;
                    set.add(p.v);
                }
            }
        }
    }
}