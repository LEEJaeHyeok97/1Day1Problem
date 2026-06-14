import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public int solution(int[][] game_board, int[][] table) {
        
        // 빈 공간 추출
        List<List<int[]>> spaces = extractShapes(game_board, 0);
        // 조각 추출
        List<List<int[]>> pieces = extractShapes(table, 1);
        
        boolean[] used = new boolean[pieces.size()];
        
        int answer = 0;
        
        // 빈 공간마다 맞는 조각 찾기
        for(List<int[]> space : spaces) {
            for(int i = 0; i < pieces.size(); i++) {
                if(used[i]) continue;
                if(canFit(space, pieces.get(i))) {
                    used[i] = true;
                    answer += space.size();
                    break;
                }
            }
        }
        return answer;
    }
    
    static List<List<int[]>> extractShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(board[r][c] != target || visited[r][c] == true) continue;
                List<int[]> shape = new ArrayList<>();
                dfs(board, visited, r, c, target, shape);
                shapes.add(normalize(shape));
            }
        }
        return shapes;
    }
    
    static void dfs(int[][] board, boolean[][] visited, int r, int c, int target, List<int[]> shape) {
        int n = board.length;
        visited[r][c] = true;
        shape.add(new int[]{r, c});
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if((0 > nr || nr >= n) || (0 > nc || nc >= n)) continue;
            if(visited[nr][nc] || board[nr][nc] != target) continue;
            dfs(board, visited, nr, nc, target, shape);
        }
    }
    
    static List<int[]> normalize(List<int[]> shape) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        for(int[] p : shape) {
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }
        List<int[]> result = new ArrayList<>();
        for(int[] p : shape) {
            result.add(new int[]{p[0] - minR, p[1] - minC});
        }
        result.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return result;
    }
    
    static boolean canFit(List<int[]> space, List<int[]> piece) {
        if(space.size() != piece.size()) return false;
        List<int[]> rotated = piece;
        for(int turn = 0; turn < 4; turn++) {
            if(isSame(space, rotated)) return true;
            rotated = rotate(rotated);
        }
        return false;
    }
    
    static List<int[]> rotate(List<int[]> shape) {
        int maxR = 0;
        for(int[] p : shape) maxR = Math.max(maxR, p[0]);
        List<int[]> result = new ArrayList<>();
        for(int[] p : shape) {
            result.add(new int[]{p[1], maxR - p[0]});
        }
        return normalize(result);
    }
    
    static boolean isSame(List<int[]> a, List<int[]> b) {
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        
        return true;
    }
}