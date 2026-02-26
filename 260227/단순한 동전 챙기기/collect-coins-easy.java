import java.util.*;

// 숫자가 써져 있으면 해당 위치에 동전이놓여져 있음.
// 숫자는 해당 동전의 번호시작점에서 출발하여 적절하게 이동하여 최소 3개의 동전을 수집하여
// 도착점에 도달.
// 동전을 수집할 시에는 꼭 번호가 증가하는 순서대로 수집
// 해당 위치를 지나가더라도 동전을 수집하지 않아도 됨
// 시작점(S)에서 출발하여 동전의 숫자가 증가하는 순서대로 최소 3개의 동전을 수집해
// 도착지에 도달하기 위해 필요한 최소 이동 횟수 출력(불가능 시 -1 출력)
public class Main {

    static int N;
    static int ans = Integer.MAX_VALUE;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int startX;
    static int startY;

    static int endX;
    static int endY;

    static ArrayList<Integer> coins = new ArrayList<>();
    static ArrayList<Integer> selected = new ArrayList<>();

    static String[] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new String[N];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.next();
            for(int j = 0; j < grid[i].length(); j++) {
                if(grid[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
                if(grid[i].charAt(j) == 'E') {
                    endX = i;
                    endY = j;
                }
                if(Character.isDigit(grid[i].charAt(j))) {
                    coins.add(Character.getNumericValue(grid[i].charAt(j)));
                }
            }
        }
        
        Collections.sort(coins);
        choose(0, 0); // 1~9

        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            System.exit(0);
        }
        System.out.println(ans);
    }

    static void choose(int curNum, int cnt) {
        if(cnt == 3) { // 3개를 선택한 경우
            // System.out.println(calcTotalDist());
            // for(int i = 0; i < 3; i++) {
            //     System.out.print(selected.get(i) + " ");
            // }
            // System.out.println();
            ans = Math.min(ans, calcTotalDist());
            return;
        }
        if(curNum == coins.size()) { // 끝까지 다 본 경우
            return;
        }

        // 현재 숫자를 선택하는 경우
        selected.add(coins.get(curNum));
        choose(curNum + 1, cnt + 1);
        selected.remove(selected.size() - 1);

        // 현재 숫자를 선택하지 않는 경우
        choose(curNum + 1, cnt);
    }

    static int calcTotalDist() {
        int moveCnt = 0;

        for(int i = 0; i < selected.size(); i++) {
            moveCnt += calcDist(selected.get(i));
        }

        return moveCnt + Math.abs(startX - endX) + Math.abs(startY - endY);
    }

    static int calcDist(int targetNum) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(Character.getNumericValue(grid[i].charAt(j)) == targetNum) {
                    int v = Math.abs(startX - i) + Math.abs(startY - j);
                    startX = i;
                    startY = j;
                    return v;
                }
            }
        }

        return 0;
    }
}