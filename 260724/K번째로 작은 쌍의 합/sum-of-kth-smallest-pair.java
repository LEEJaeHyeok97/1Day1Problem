import java.util.*;

// n개의 수로 이루어진 수열과 m개의 수로 이루어진 수열이 주어졌을 때,
// 각 수열에서 정확히 원소를 하나씩만 뽑아 나올 수 있는 모든 쌍을 구하고,
// 그 값들을 오름차순이 되도록 나열했을 때의 K번째 쌍의 두 수의 합을 구하는 프로그램
// 두 수의 합이 오름차순이 되게 나열 
class Tuple implements Comparable<Tuple> {
    long sum;
    int i, j;

    public Tuple(long sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Tuple o) {
        return Long.compare(this.sum, o.sum);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int rows = (int) Math.min(n, k);
        int cols = (int) Math.min(m, k);

        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for(int i = 0; i < rows; i++) {
            pq.add(new Tuple(arr1[i] + arr2[0], i, 0));
        }

        long answer = 0;
        for(long cnt = 0; cnt < k; cnt++) {
            Tuple cur = pq.poll();
            answer = cur.sum;
            int nj = cur.j + 1;
            if(nj < cols) {
                pq.add(new Tuple(arr1[cur.i] + arr2[nj], cur.i, nj));
            }
        }

        System.out.println(answer);
    }
}