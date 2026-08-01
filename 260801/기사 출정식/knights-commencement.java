import java.util.*;
import java.io.*;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        prev = next = null;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Node> nodes = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        Node firstNode = new Node(Integer.parseInt(st.nextToken()));
        nodes.put(firstNode.data, firstNode);

        Node cur = firstNode;
        for(int i = 1; i < n; i++) {
            Node nextNode = new Node(Integer.parseInt(st.nextToken()));
            nodes.put(nextNode.data, nextNode);

            cur.next = nextNode;
            nextNode.prev = cur;
            cur = nextNode;
        }

        firstNode.prev = cur;
        cur.next = firstNode;

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            Node target = nodes.get(num);

            System.out.println(target.next.data + " " + target.prev.data);

            // cur 제거
            Node left = target.prev;
            Node right = target.next;

            left.next = right;
            right.prev = left;
        }
    }
}