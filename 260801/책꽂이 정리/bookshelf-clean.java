import java.util.*;
import java.io.*;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    static final int MAX_N = 250000;
    static final int MAX_K = 100;

    static Node[] nodes = new Node[MAX_N + 1];

    static Node[] heads = new Node[MAX_K + 1];
    static Node[] tails = new Node[MAX_K + 1];

    static boolean empty(int i) {
        return null == heads[i];
    }

    static void connect(Node u, Node v) {
        u.next = v;
        v.prev = u;
    }

    static Node pop_front(int i) {
        Node ret = heads[i];

        if (null != ret) {
            heads[i] = ret.next;

            ret.next = null;

            if(null != heads[i])
                heads[i].prev = null;
            else
                tails[i] = null;
        }

        return ret;
    }

    static Node pop_back(int i) {
        Node ret = tails[i];

        if(null != ret) {
            tails[i] = ret.prev;

            ret.prev = null;

            if(null != tails[i])
                tails[i].next = null;
            else
                heads[i] = null;
        }

        return ret;
    }

    static void push_front(int i, Node singleton) {
        if(null == heads[i]) {
            heads[i] = tails[i] = singleton;
        } else {
            connect(singleton, heads[i]);
            heads[i] = singleton;
        }
    }

    static void push_back(int i, Node singleton) {
        if(null == tails[i]) {
            heads[i] = tails[i] = singleton;
        } else {
            connect(tails[i], singleton);
            tails[i] = singleton;
        }
    }

    static void move_all_front(int i, int j) {
        if(i == j || empty(i))
            return;
        if(empty(j)) {
            heads[j] = heads[i];
            tails[j] = tails[i];
        } else {
            connect(tails[i], heads[j]);
            heads[j] = heads[i];
        }

        heads[i] = tails[i] = null;
    }

    // i번 연결 리스트를 j번 연결 리스트 뒤에 삽입
    static void move_all_back(int i, int j) {
        if(i == j || empty(i))
            return;

        if(empty(j)) {
            heads[j] = heads[i];
            tails[j] = tails[i];
        } else {
            connect(tails[j], heads[i]);
            tails[j] = tails[i];
        }

        heads[i] = tails[i] = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int q = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for(int i = 1; i < n; i++) {
            connect(nodes[i], nodes[i+1]);
        }

        for(int i = 1; i <= k; i++)
            heads[i] = tails[i] = null;
        
        heads[1] = nodes[1];
        tails[1] = nodes[n];

        for(int t = 0; t < q; t++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if(1 == type) {
                Node node = pop_front(i);

                if(null != node)
                    push_back(j, node);
            } else if(2 == type) {
                Node node = pop_back(i);

                if(null != node)
                    push_front(j, node);
            } else if(3 == type) {
                move_all_front(i, j);
            } else if(4 == type) {
                move_all_back(i, j);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= k; i++) {
            int cnt = 0;
            for (Node cur = heads[i]; cur != null; cur = cur.next) cnt++;

            sb.append(cnt);
            for (Node cur = heads[i]; cur != null; cur = cur.next) {
                sb.append(' ').append(cur.data);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}