import java.util.*;

// N명의 개발자. T번에 걸쳐 t초에 x,y 악수
// 정확히 K번 악수 동안만 전염병을 옮김. 이후에는 옮기지 X
// 전염된 사람 끼리 만나도 전염시킨 것으로 간주하고 K 카운트 다운
// 이 경우 재감염은 아님
// P: 처음 전염병에 걸려 있는 개발자의 번호
// 0음성 1양성.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N명의 개발자
        int K = sc.nextInt(); // K번의 악수
        int P = sc.nextInt(); // 전염병에 걸린 개발자 번호
        int T = sc.nextInt(); // T번에 걸쳐 악수
        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt();
            shakes[i][1] = sc.nextInt();
            shakes[i][2] = sc.nextInt();
        }
        // Please write your code here.
        int[] arr = new int[N+1];
        
        Arrays.sort(shakes, Comparator.comparingInt(a -> a[0]));
        arr[P] = 1;
        
        for(int i = 0; i < shakes.length; i++) {
            int p1 = shakes[i][1];
            int p2 = shakes[i][2];
            if (K > 0) {
                if (arr[p1] == 1 || arr[p2] == 1) {
                    arr[p1] = 1;
                    arr[p2] = 1;
                    K--;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}