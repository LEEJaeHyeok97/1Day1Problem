// N명이 원을 이루면서 앉아있고,
// N명이 모두 제거될 때 까지 제거
// 1. 1번부터 K번째 사람을 제거
// 2. 제거되면 남은 사람들로 원을 이루고, 제거된 사람을 기준으로 다시 K번째 사람을 제거
// 3. 2번 연산을 반복
// 제거되는 사람 번호를 순서대로 나열
// 1 2 3 4 5 6
// 1 2 3 5 6
// 1 3 5 6
// 3 5 6

import java.util.*;
import java.io.*;

public class Main {

    static Deque<Integer> dq = new ArrayDeque<>();
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ans = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dq.add(i);
        }

        int idx = 1;
        int tmp = 0;
        while (!dq.isEmpty()) {
            if (tmp / 4 > 0) {
                tmp %= 4;
            }
            tmp++;
            int number = dq.poll();
            if (tmp == 4) {
                ans[idx] = number;
                idx++;
                tmp = 0;
            } else {
                dq.add(number);
            }
        }

        for (int i = 1; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }


    }
}
