import java.util.*;
import java.io.*;

// 길이 N인 문자열 A, 적절하게 특정 횟수만큼 오른쪽으로 shift
// 이후 문자열에 Run-Length Encoding을 했을 때 길이가 최소가 되도록
// Run-Length Encoding이란 연속해서 나온 문자와 연속해서 나온 개수로 나타내는 방식
// 'aaabbbbcaa' -> a3b4c1a2 길이 8
// 오른쪽으로 두 번 shfit 후 encoding 시 aaaaabbbbc 로 a5b4c1 길이 6
// shift를 진행하여 나올 수 있는 encoding 이후 결과 값들 중 최소길이를 구하는 프로그램을 작성.
public class Main {

    static ArrayList<Integer> ans_li = new ArrayList<>();
    static Character[] s_li;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        int word_len = A.length();

        s_li = new Character[word_len];
        for (int i = 0; i < word_len; i++) {
            s_li[i] = A.charAt(i);
        }

//        for (int i = 0; i < word_len; i++) {
//            System.out.print(s_li[i] + " ");
//        }
//        System.out.println();

        int l = encoding(s_li);
        ans_li.add(l);
        for (int si = 0; si < word_len; si++) {
            Character tmp = s_li[word_len - 1];
            Character[] tmp_li = new Character[word_len];
            for (int i = 0; i < word_len - 1; i++) {
                tmp_li[i + 1] = s_li[i];
            }
            tmp_li[0] = tmp;

            s_li = tmp_li;

            l = encoding(s_li);
            ans_li.add(l);
        }

        System.out.println(Collections.min(ans_li));
    }

    static int encoding(Character[] li) {
        StringBuilder sb = new StringBuilder();
        char prev = li[0];
        int cnt = 1;
        for (int i = 1; i < li.length; i++) {
            if (prev == li[i]) {
                cnt += 1;
            } else {
                sb.append(prev);
                sb.append(cnt);
                prev = li[i];
                cnt = 1;
            }
        }
        sb.append(prev);
        sb.append(cnt);
//        System.out.println(sb);

        return sb.length();
    }
}
