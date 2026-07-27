import java.util.*;
import java.io.*;

// 1~n n개 단일 노드
// 1 i : i번 노드를 그 노드가 속해 있던 연결 리스트에서 뽑아서 단일 노드가 되게 함.
// 2 i j : 단일 노드인 j번 노드를 i번 노드 앞에 삽입.
// 3 i j : 단일 노드인 j번 노드를 i번 노드 뒤에 삽입.
// 4 i : i번 노드의 이전 노드와 다음 노드의 번호를 출력.
// 연산ㄴ이 주어질 때마다, i번 노드의 이전 노드와 다음 노드의 번호를 한 줄에 출력
// 이전 노드나 다음 노드가 존재하지 않는다면, 0을 출력
class Node {
    int num;
    Node prev;
    Node next;

    public Node(int num) {
        this.num = num;
        this.prev = this.next = null;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n+1];
        for(int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            
            int command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                int nodeNum = Integer.parseInt(st.nextToken());

                Node node = nodes[nodeNum];
                Node pNode = node.prev;
                Node nNode = node.next;

                if(pNode != null) {
                    pNode.next = node.next;
                }
                if(nNode != null) {
                    nNode.prev = node.prev;
                }
               node.prev = null;
               node.next = null;
            } else if(command == 3) {
                int nodeNum1 = Integer.parseInt(st.nextToken());
                int nodeNum2 = Integer.parseInt(st.nextToken());

                Node pNode = nodes[nodeNum1];
                Node newNode = nodes[nodeNum2];
        
                if(pNode.next != null) {
                    pNode.next.prev = newNode;
                }
                
                newNode.next = pNode.next;
                pNode.next = newNode;
                newNode.prev = pNode;
            } else if(command == 2) {
                int nodeNum1 = Integer.parseInt(st.nextToken());
                int nodeNum2 = Integer.parseInt(st.nextToken());

                Node pNode = nodes[nodeNum1];
                Node newNode = nodes[nodeNum2];

                newNode.next = pNode;
                newNode.prev = pNode.prev;
                if(pNode.prev != null) {
                    pNode.prev.next = newNode;
                }
                pNode.prev = newNode;
            } else if(command == 4) {
                int nodeNum = Integer.parseInt(st.nextToken());
                Node cur = nodes[nodeNum];
                if(cur.prev != null) {
                    System.out.print(cur.prev.num + " ");
                } else {
                    System.out.print(0 + " ");
                }
                if(cur.next != null) {
                    System.out.print(cur.next.num + " ");
                } else {
                    System.out.print(0 + " ");
                }
                System.out.println();
            }
        }

        for(int i = 1; i <= n; i++) {
            if(nodes[i].next != null) {
                System.out.print(nodes[i].next.num + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
        System.out.println();
    }
}