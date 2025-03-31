import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    /*
    N = 후보의 수
    기호 1번을 찍으려는 사람 수
    기호 2번
    ..
    기호 N번
    (N <= 50)
    0 < 득표수 <= 100 (자연수)
     */
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int dasom = Integer.parseInt(br.readLine());
        int cnt = 0;


        for (int i = 1; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        if (arr.size() == 0) {
            System.out.println(0);
            return;
        }

        while (true) {
            Integer max = Collections.max(arr);
            if (dasom > max) {
                break;
            }

            int idx = arr.indexOf(max);
            arr.set(idx, arr.get(idx) - 1);
            dasom++;
            cnt++;
        }

        System.out.println(cnt);
    }
}