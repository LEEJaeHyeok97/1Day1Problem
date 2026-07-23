import java.util.*;

//1. 최대힙(작은것들), 최소힙 두 개의 우선순위큐 자료구조를 쓴다.
//2. 힙의 크기가 같다면 최대힙에 넣고, 최대힙이 더 크면 최소힙에 넣는다.
//3. 최대힙과 최소 힙의 peek() 결과가 최대힙 <= 최소힙이라면 그대로두고, 그 반대라면 swap을 한다.
//4. 수열의 값이 홀수번째 수 일 때는 중앙값을 출력한다 최대힙의 peek()
public class Main {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            maxHeap.clear();
            minHeap.clear();
            int m = sc.nextInt(); // 수열의 크기
            int[] arr = new int[m];
            for(int i = 0; i < m; i++) {
                int num = sc.nextInt(); // 수열
                
                if(maxHeap.size() == minHeap.size()) {
                    maxHeap.add(-num);
                } else {
                    minHeap.add(num);
                }

                // swap
                if(!minHeap.isEmpty() && -maxHeap.peek() > minHeap.peek()) {
                    int tmp1 = -1 * maxHeap.poll();
                    int tmp2 = minHeap.poll();

                    maxHeap.add(-tmp2);
                    minHeap.add(tmp1);
                }

                if(i % 2 == 0) {
                    System.out.print(-maxHeap.peek() + " ");
                }
            }      

            System.out.println();      
        }
    }
}