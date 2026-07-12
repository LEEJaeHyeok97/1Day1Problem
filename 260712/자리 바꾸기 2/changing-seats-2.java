import java.util.*;

// 1~N 사람이 1~K번 자리를 바꾸고 다시 K+1~2K 번 자리를 서로 바꾼다.
// 2K+1~3K까지 또 같은 방식으로 K번의 자리 바꿈이 반복
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[k];
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            HashSet<Integer> tmp = new HashSet<>();
            tmp.add(i + 1);
            arr.add(tmp);
        }
        int[] seats = new int[n+1];
        for(int i = 1; i <= n; i++) {
            seats[i] = i;
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < k; j++) {
                int a1 = seats[a[j]];
                int b1 = seats[b[j]];

                HashSet<Integer> tmpA = arr.get(a1 - 1);
                HashSet<Integer> tmpB = arr.get(b1 - 1);
                tmpA.add(b[j]);
                tmpB.add(a[j]);

                int seatTmp = b1;
                seats[a[j]] = b1;
                seats[b[j]] = a1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr.get(i).size()).append('\n');
        }
        System.out.print(sb);
    }
}