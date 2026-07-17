import java.util.*;
import java.io.*;

// 1~M 의자
// 사람들이 앉고자 하는 의자에 대한 정보 ai 값이 n개 주어진다.
// ai는 1번 이상 ai번 이하의 의자에만 앉고 싶다는 것을 의미.
// 최초로 앉지 못하는 사람이 생기면 종료한다.
// 앉을 자리를 적절하게 배정하여 앉게 되는 사람 수를 최대로 만드는 프로그램.
public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 의자에 대한 정보값
        int m = Integer.parseInt(st.nextToken()); // 의자 갯수

        TreeSet<Integer> s = new TreeSet<>();
        for(int i = 1; i <= m; i++) {
            s.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(s.floor(tmp) != null) {
                s.remove(s.floor(tmp));
            } else {
                break;
            }
        }

        System.out.print(m - s.size());
    }
}