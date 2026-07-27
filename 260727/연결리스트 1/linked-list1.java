import java.util.*;
import java.io.*;

// 이중 연결 리스트의 노드를 구현한다.
// 초기에 문자열 S를 값으로 가지는 단일 노드 cur가 있다.
// 1 S : 문자열 S를 값으로 가지는 새로운 단일 노드를 생성하고, 이 단일 노드를 노드 cur의 앞에 삽입
// 2 S :  '', 이 단일 노드를 노드 cur의 뒤에 삽입
// 3 : 노드 cur의 이전 노드가 존재한다면, cur를 그 이전 노드로 변경
// 4 : 노드 cur의 다음 노드가 존재한다면, cur를 그 다음 노드로 변경
class Node {
    String data;
    Node prev;
    Node next;

    public Node(String data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sInit = br.readLine();
        Node cur = new Node(sInit);
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                String s = st.nextToken();
                Node nNode = new Node(s);

                if(cur.prev == null) {
                    cur.prev = nNode;
                    nNode.next = cur;
                } else {
                    Node pprev = cur.prev;
                    pprev.next = nNode;
                    
                    cur.prev = nNode;
                    nNode.prev = pprev;
                    nNode.next = cur;
                }
            }
            else if(command == 2) {
                String s = st.nextToken();
                Node nNode = new Node(s);

                if(cur.next == null) {
                    cur.next = nNode;
                    nNode.prev = cur;
                } else {
                    Node nnext = cur.next;
                    nnext.prev = nNode;

                    cur.next = nNode;
                    nNode.prev = cur;
                    nNode.next = nnext;
                }
            }
            else if(command == 3) {
                if(cur.prev != null) {
                    cur = cur.prev;
                }
            }
            else if(command == 4) {
                if(cur.next != null) {
                    cur = cur.next;
                }
            }

            StringBuilder sb = new StringBuilder();
            if(cur.prev != null) {
                sb.append(cur.prev.data + " ");
            } else {
                sb.append("(Null) ");
            }
            sb.append(cur.data + " ");
            if(cur.next != null) {
                sb.append(cur.next.data);
            } else {
                sb.append("(Null)");
            }

            System.out.println(sb);
        }
    }
}