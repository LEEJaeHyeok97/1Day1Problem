import java.util.*;
public class Main {

    static final int MAX_N = 1000000;
    static final int OPERATOR_NUM = 4;

    static final int SUBTRACT = 0;
    static final int ADD = 1;
    static final int DIV2 = 2;
    static final int DIV3 = 3;

    static int n;

    static Deque<Integer> q = new ArrayDeque<>();
    static boolean[] visited = new boolean[MAX_N * 2];
    static int[] step = new int[MAX_N * 2];
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        push(n, 0);
        findMin();

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
        if(op == SUBTRACT) {
            return num - 1;
        }
        else if(op == ADD) {
            return num + 1;
        }
        else if(op == DIV2) {
            return num / 2;
        }
        else {
            return num / 3;
        }
    }

    static void findMin() {
        while(!q.isEmpty()) {
            int curNum = q.poll();

            for(int i = 0; i < OPERATOR_NUM; i++) {
                if(!possible(curNum, i))
                    continue;

                int newNum = calculate(curNum, i);

                if(canGo(newNum)) {
                    push(newNum, step[curNum] + 1);
                }
            }
        }

        ans = step[1];
    }

    static boolean canGo(int newNum) {
        return inRange(newNum) && !visited[newNum];
    }

    static void push(int newNum, int newStep) {
        q.add(newNum);
        visited[newNum] = true;
        step[newNum] = newStep;
    }

    static boolean inRange(int num) {
        return 1 <= num && num <= 2*n - 1;
    }
}