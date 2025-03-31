import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
* N = 종이의 행 수
* 숫자를 모두 찾는다.
* 이 숫자들을 비내림차순으로 정리(숫자 앞에 0이 있는 경우 생략 가능)
*
* 각 줄은 최대 100글자 알파벳 소문자 + 숫자
*
* 출력은 종이에서 찾은 숫자 M 개의 줄로 이루어진다.
* */
public class Main {
//
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    ArrayList<String> a = new ArrayList<>();
//    StringTokenizer st = new StringTokenizer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        List<BigInteger> answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < temp.length(); j++) {
                char a = temp.charAt(j);

                if (Character.isDigit(a)) {
                    sb.append(a);
                } else {
                    if (sb.length() > 0) {
                        answer.add(new BigInteger(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
            }

            if (sb.length() > 0) {
                answer.add(new BigInteger(sb.toString()));
            }
        }

        Collections.sort(answer);

        for (BigInteger num : answer) {
            System.out.println(num);
        }
    }
}