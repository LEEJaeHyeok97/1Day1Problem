import java.util.*;

// 1이상 K이하의 숫자를 하나 뽑는 행위를 N번. 단, 3번 이상 같은 숫자가 나오는 경우는 제외
public class Main {
    
    static int k, n;
    static ArrayList<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        backtracking(0);

        System.out.println(sb);
    }

    static void backtracking(int cnt) {
        if(cnt == n) {
            printNumbers();
            return;
        }

        for(int i = 1; i <= k; i++) {
            if(cnt >= 2 && (arr.get(arr.size() - 1) == i && arr.get(arr.size() - 2) == i)) continue;
            arr.add(i);
            backtracking(cnt + 1);
            arr.remove(arr.size() - 1);
        }
    }

    static void printNumbers() {
        for(int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
            sb.append(" ");
        }
        sb.append("\n");
    }
}