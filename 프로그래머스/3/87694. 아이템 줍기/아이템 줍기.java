import java.util.*;

class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    static Deque<Pair> q = new ArrayDeque<>();
    static int[][] visited;
    
    static int[][] grid;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        q.clear();
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        grid = new int[101][101];
        // 주어진 각각의 직사각형들의 겉 부분 칠하기
        for(int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for(int i = x1; i <= x2; i++) {
                grid[y1][i] = 1;
                grid[y2][i] = 1;
            }
            for(int i = y1; i <= y2; i++) {
                grid[i][x1] = 1;
                grid[i][x2] = 1;
            }
        }
        
        for(int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for(int i = y1 + 1; i < y2; i++) {
                for(int j = x1 + 1; j < x2; j++) {
                    grid[i][j] = 0;
                }
            }
        }
        
        visited = new int[101][101];
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                visited[i][j] = -1;
            }
        }
        
        q.add(new Pair(characterY, characterX));
        visited[characterY][characterX] = 0;
        
        bfs();
        
        return visited[itemY][itemX] / 2;
    }
    
    static void bfs() {
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(canGo(nx, ny)) {
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }
    
    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y] != -1) return false;
        if(grid[x][y] != 1) return false;
        
        return true;
    }
    
    static boolean inRange(int x, int y) {
        return ((0 <= x && x < 101) && (0 <= y && y < 101));
    }
}