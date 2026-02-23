import java.util.*;

public class Main {

    static int n;

    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        backtracking(0);
    }

    static void backtracking(int cnt) {
        if(hasSeqNum()) return;
        if(cnt == n) {
            if(!hasSeqNum()) {
                printArr();
                System.exit(0);
            }
            return;
        }

        for(int i = 4; i <= 6; i++) {
            arr.add(i);
            backtracking(cnt + 1);
            arr.remove(arr.size() - 1);
        }
    }

    static boolean hasSeqNum() {
        int size = arr.size();
        int maxLen = arr.size() / 2;

        for(int len = 1; len <= maxLen; len++) {
            boolean same = true;

            for(int k = 0; k < len; k++) {
                int a = arr.get(size - 1 - k);
                int b = arr.get(size - 1 - k - len);

                if(a != b) {
                    same = false;
                    break;
                }
            }

            if(same) return true;
        }

        return false;
    }

    static void printArr() {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
    }
}