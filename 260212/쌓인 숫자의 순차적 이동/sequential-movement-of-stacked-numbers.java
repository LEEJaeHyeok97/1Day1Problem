import java.util.*;

// N * N격자. M번에 걸쳐 숫자들을 이동
// 여덟 방향 중 가장 큰 값이 적혀 있는 숫자가 있는 곳으로 이동
// 이미 해당 위치에 숫자가 있는 경우 해당 숫자들 중 가장 위에 위치
// 움직일 숫자 위에 다른 숫자가 있다면 같이 움직임
// 여덟 방향에 아무 숫자도 없다면, 움직이지 않는다.
// M번 움직인 후 상태를 출력(가장 위에 있는 숫자부터 순서대로 공백을 두고 출력 없으면 None 출력)
public class Main {

    static int n, m;
    static ArrayList<Integer>[][] grid;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 상단좌~우, 좌우, 하단 좌~우
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                grid[i][j].add(num);
            }
        }
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();

            // move(num);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j].size() == 0) {
                    System.out.print("None");
                }
                else {
                    ArrayList<Integer> tmp = grid[i][j];
                    for(int k = tmp.size() - 1; k >= 0; k--) {
                        System.out.print(tmp.get(k) + " ");
                    }
                }

                System.out.println();
            }
        }
    }
}