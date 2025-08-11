// 아직 보여주지 않은 문자 중 추가했을 때 문자열이 사전 순 가장 앞에 오도록 하는 문자를 보여준다.
// ZOAC => A -> AC -> OAC -> ZOAC
// BAC => A -> AC -> BAC
// STARTLINK => A -> AI -> AIK -> ALIK -> ALINK -> ARLINK -> ARTLINK -> SARTLINK -> STARTLINK

import java.util.*;
import java.io.*;
public class Main {

    static String str;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        visited = new boolean[str.length()];

        zoac(0, str.length() - 1);
        System.out.println(sb);
    }

    public static void zoac(int left, int right) {
        if (left > right) {
            return;
        }

        // 현재 문자열 중 사전식 순서가 가장 낮은 글자 찾기
        int idx = left;
        for (int i = left; i <= right; i++) {
            if (str.charAt(idx) > str.charAt(i)) {
                idx = i;
            }
        }
        visited[idx] = true;

        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");

        // 사전식 순서 맞추기
        zoac(idx + 1, right);
        zoac(left, idx-1);
    }
}
