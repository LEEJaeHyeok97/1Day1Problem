import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int idx;
    int weight;

    public Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());
                cost[i][tmp++] = number;
            }
        }

        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (cost[0][i] != 0) {
                nodes.add(new Node(i, cost[0][i]));
            }
        }

        boolean[] visited = new boolean[N];
        long ans = 0;
        visited[0] = true;

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (!visited[node.idx]) {
                ans += node.weight;
                visited[node.idx] = true;
                for (int i = 0; i < N; i++) {
                    if (cost[node.idx][i] != 0) {
                        if (!visited[i]) {
                            nodes.add(new Node(i, cost[node.idx][i]));
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
