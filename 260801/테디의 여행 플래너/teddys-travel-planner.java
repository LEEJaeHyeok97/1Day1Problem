import java.util.*;
import java.io.*;

// 1. 핀셋을 꽂은 도시를 현재의 오른쪽 인접 도시로 바꿔서 꽂는다. 만약 오른쪽에 있는 도시가
// 없다면 무시한다.
// 2. 핀셋을 꽂은 도시를 현재의 왼쪽 인접 도시로 바꿔서 꽂는다. 만약 왼쪽에 있는 도시가
// 없다면 무시한다.
// 3. 핀셋이 꽂혀 있는 도시의 오른쪽에 위치한 도시의 스티커를 제거한다. 만약 오른쪽에
// 있는 도시가 없다면 무시한다.
// 4. 핀셋이 꽂혀 있는 도시의 오른쪽에 새로운 도시를 추가하여 스티커를 붙인다.
class Node {
    String data;
    Node prev;
    Node next;

    public Node(String data) {
        this.data = data;
        prev = next = null;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String[] cities = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cities[i] = st.nextToken();
        }
        
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(cities[i]);
        }

        for(int i = 1; i < n; i++) {
            nodes[i].prev = nodes[i - 1];
            nodes[i-1].next = nodes[i];
        }

        nodes[n-1].next = nodes[0];
        nodes[0].prev = nodes[n-1];

        Node cur = nodes[0];
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                if(null != cur.next) {
                    cur = cur.next;
                }
            }
            else if(command == 2) {
                if(null != cur.prev) {
                    cur = cur.prev;
                }
            }
            else if(command == 3) {
                if(null != cur.next && null != cur.next.next) {
                    Node curNext = cur.next;

                    cur.next = curNext.next;
                    curNext.next.prev = cur;
                    curNext.prev = null;
                    curNext.next = null;
                } else if(null != cur.next && null == cur.next.next) {
                    Node curNext = cur.next;

                    cur.next = null;

                    curNext.prev = null;
                    curNext.next = null;
                }
            }
            else if(command == 4) {
                String cName = st.nextToken();
                Node newNode = new Node(cName);

                Node curNode = cur;
                Node curNext = cur.next;

                curNode.next = newNode;
                newNode.prev = curNode;

                curNext.prev = newNode;
                newNode.next = curNext;
            }

            if(cur.prev != null && cur.next != null) {
            if(cur.prev == cur.next) {
                System.out.println(-1);
            } else {
                System.out.println(cur.prev.data + " " + cur.next.data);
            }
        } else if(cur.prev == null && cur.next != null) {
            System.out.println(-1 + " " + cur.next.data);
        } else if(cur.prev != null && cur.next == null) {
            System.out.println(cur.prev.data + " " + -1);
        } else {
            System.out.println(-1);
        }
        }
    }
}