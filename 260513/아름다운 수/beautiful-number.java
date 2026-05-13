import java.util.*;

// 1~4 정수. 정확히 해당 숫자만큼 연달아 같은 숫자가 나오는 수를 아름다운 수
public class Main {
    static int n;
    static int ans = 0;

    static ArrayList<Integer> selected = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        backtracking();
        System.out.println(ans);
    }

    static void backtracking() {
        if(selected.size() == n) {
            checkIsBeautifulNumber();
            return;
        }

        for(int i = 1; i <= 4; i++) {
            selected.add(i);
            backtracking();
            selected.remove(selected.size() - 1);
        }
    }

    static void checkIsBeautifulNumber() {
        for(int i = 0; i < n; i+= selected.get(i)) {
            if(i + selected.get(i) - 1 >= n)
                return;
            
            for(int j = i; j < i + selected.get(i); j++) {
                if(selected.get(j) != selected.get(i)) {
                    return;
                }
            }
        }

        ans++;
    }
}