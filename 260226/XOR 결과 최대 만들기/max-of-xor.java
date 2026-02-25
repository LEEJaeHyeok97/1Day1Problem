import java.util.*;

// N개의 음이 아닌 정수가 입력으로 주어졌을 때, M개를 뽑아 모두 XOR한 결과의 최댓값 출력
public class Main {

    static int ans = Integer.MIN_VALUE;
    static int n, m;
    static int[] A;

    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        // Please write your code here.
        // 1 11 101
        choose(0, 0);

        System.out.println(ans);
    }

    static void choose(int curNum, int cnt) {
        if(curNum == n || cnt == m) {
            ans = Math.max(ans, calc());

            return;
        }

        // for(int i = 0; i < n; i++) {
        //     arr.add(A[i]);
        //     choose(cnt + 1);
        //     arr.remove(arr.size() - 1);
        // }

        choose(curNum + 1, cnt);

        arr.add(A[curNum]);
        choose(curNum + 1, cnt + 1);
        arr.remove(arr.size() - 1);
    }

    static int calc() {
        int tmp = A[0];
        for(int i = 1; i < arr.size(); i++) {
            tmp ^= arr.get(i);
        }

        return tmp;
    }
}