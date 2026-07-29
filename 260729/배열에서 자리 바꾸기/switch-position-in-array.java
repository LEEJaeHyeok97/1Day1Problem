import java.util.Scanner;
public class Main {
    static final int MAX_N = 250005;

    static class Node {
        int id;
        Node prev, next;

        Node(int id) {
            this.id = id;
            this.prev = null;
            this.next = null;
        }
    }

    static Node[] nodes = new Node[MAX_N];

    static void connect(Node s, Node e) {
        if(s != null)
            s.next = e;
        if(e != null)
            e.prev = s;
    }

    static void swapSubarray(Node a, Node b, Node c, Node d) {
        Node after_prevA = c.prev;
        Node after_nextB = d.next;

        Node after_prevC = a.prev;
        Node after_nextD = b.next;

        if(b.next == c) {
            after_prevA = d;
            after_nextD = a;
        }

        if(d.next == a) {
            after_prevC = b;
            after_nextB = c;
        }

        connect(after_prevA, a);
        connect(b, after_nextB);

        connect(after_prevC, c);
        connect(d, after_nextD);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++)
            nodes[i] = new Node(i);
        
        for(int i = 1; i < n; i++)
            connect(nodes[i], nodes[i+1]);

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            swapSubarray(nodes[a], nodes[b], nodes[c], nodes[d]);
        }

        Node cur = nodes[1];
        while(cur.prev != null)
            cur = cur.prev;
        
        while(cur != null) {
            System.out.print(cur.id + " ");
            cur = cur.next;
        }
        
    }
}