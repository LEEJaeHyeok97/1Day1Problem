import java.util.*;
import java.io.*;
// rc x -> x가 1인 경우: 난이도가 가장 높은 문제 번호를 출력. 난이도가 같은게 여러개라면
// 문제 번호가 더 큰 것을 선택.
// x가 -1인 경우: 난이도가 가장 낮은 문제 번호를 출력. 난이도가 같은 문제가 여러개라면
// 문제 번호가 더 작은 것을 선택.

// ad P L -> 문제 번호 P번에 난이도 L인 무제를 추천 문제 리스트에 추가
// 동일한 문제 번호가 다른 난이도로 다시 추가될 수 있다.

// sv P L -> 문제 번호 P번에 난이도 L인 문제를 추천 문제 리스트에서 제거한다.
// sv 명령은 추천 문제 리스트에 해당 문제가 존재할 때만 주어진다.
class Problem implements Comparable<Problem> {
    int l;
    int p;

    public Problem(int l, int p) {
        this.l = l;
        this.p = p;
    }

    @Override
    public int compareTo(Problem prob) {
        if(this.l != prob.l) {
            return Integer.compare(this.l, prob.l);
        }
        return Integer.compare(this.p, prob.p);
    } 
}

public class Main {
    public static void main(String[] args) throws IOException {

        TreeSet<Problem> s = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            s.add(new Problem(l, p));
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if(command.equals("rc")) {
                int x = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    Problem prob = s.last();
                    System.out.println(prob.p);
                } else if(x == -1) {
                    Problem prob = s.first();
                    System.out.println(prob.p);
                }
            } else if(command.equals("ad")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());

                s.add(new Problem(level, num));
            } else if(command.equals("sv")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());

                s.remove(new Problem(level, num));
            }
        }
    }
}