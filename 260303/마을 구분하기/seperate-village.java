import java.util.*;

// n * n 상하좌우 인접한 영역에 있는 사람들은 같은 마을에 있는 것으로 간주
// 총 마을의 개수를 출력하고 
// 같은 마을에 있는 사람의 수를 오름차순으로 정렬하여 출력
// 사람이 있는 경우 1, 벽이 있는 경우 0
public class Main {

    static int n;
    static int vilCnt = 0;
    static int tmpCnt = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1 , 0, 0};

    static int[][] grid;
    static boolean[][] visited;
    static ArrayList<Integer> population = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    vilCnt++;
                    tmpCnt = 0;
                    dfs(i, j);
                    population.add(tmpCnt);
                }
            }
        }

        System.out.println(vilCnt);
        Collections.sort(population);
        for(int i = 0; i < population.size(); i++) {
            System.out.println(population.get(i));
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        tmpCnt++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny)) {
                
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    static boolean canGo(int x, int y) {
        if(inRange(x, y) && visited[x][y] == false && grid[x][y] == 1) {
            return true;
        }

        return false;
    }

    static boolean inRange(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y < n)) return true;
        return false;
    }
}