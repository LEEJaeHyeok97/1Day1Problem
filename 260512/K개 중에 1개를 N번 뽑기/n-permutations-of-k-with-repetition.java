import java.util.*;

public class Main {

    static int k, n;
    static ArrayList<Integer> selected = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        backtracking(0);
    }

    static void backtracking(int num) {
        if(selected.size() == n) {
            print();
            return;
        }

        for(int i = 1; i <= k; i++) {
            selected.add(i);
            backtracking(num + 1);
            selected.remove(selected.size() - 1);
        }
    }

    static void print() {
        for(int i = 0; i < selected.size(); i++) {
            System.out.print(selected.get(i) + " ");
        }

        System.out.println();
    }
}