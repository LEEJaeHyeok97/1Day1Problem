import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        choose(1, 0);
    }

    static void choose(int curNum, int cnt) {
        if(curNum == n + 1) {
            if(cnt == m)
                printNumbers();
            return;
        }

        answer.add(curNum);
        choose(curNum + 1, cnt + 1);
        answer.remove(answer.size() - 1);

        choose(curNum + 1, cnt);
    }

    static boolean isDuplicated(int num) {
        for(int i = 0; i < answer.size(); i++) {
            if(answer.get(i) == num) return true;
        }

        return false;
    }

    static void printNumbers() {
        for(int i = 0; i < answer.size(); i++) {
            System.out.printf(answer.get(i) + " ");
        }
        System.out.println();
    }
}