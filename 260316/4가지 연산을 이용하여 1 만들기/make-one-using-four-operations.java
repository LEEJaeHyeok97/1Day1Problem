import java.util.*;

// 정수 N을 4가지 연산을 적절히 활용하여 연산의 횟수를 최소화하여
// 숫자 1을 만든다.
// -1, +1, 2로 나눠떨어질 경우 /2, 3으로 나눠떨어질 경우 /3
// bfs() -> 1이 될 경우 stop?
// bfs 를 연산 시퀀스 관점이 아닌 숫자 상태의 수로 봐야한다.
public class Main {
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int OPERATOR_NUM = 4;

    static final int SUBTRACT = 0;
    static final int ADD = 1;
    static final int DIV2 = 2;
    static final int DIV3 = 3;

    static int n;

    static int ans = INT_MAX;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        findMin(n, 0);

        System.out.println(ans);
    }

    static boolean possible(int num, int op) {
        if(op == SUBTRACT || op == ADD)
            return true;
        else if(op == DIV2)
            return num % 2 == 0;
        else
            return num % 3 == 0;
    }

    static int calculate(int num, int op) {
        if(op == SUBTRACT)
            return num - 1;
        else if(op == ADD)
            return num + 1;
        else if(op == DIV2)
            return num / 2;
        else
            return num / 3;
    }

    static void findMin(int num, int cnt) {
        if(num == 1) {
            ans = Math.min(ans, cnt);
            return;
        }

        if(cnt >= n - 1)
            return;

        for(int i = 0; i < OPERATOR_NUM; i++) 
            if(possible(num, i))
                findMin(calculate(num, i), cnt + 1);
    }
}