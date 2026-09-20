// 캐릭터는 0,0 위치에서 시작. 
// 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이(좌표평면 경계를 넘어가는 명령 무시)
import java.util.*;

class Pair {
    int x;
    int y;
    int dir;
    
    public Pair(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
class Solution {
    
    static int[] dx = {-1, 1, 0, 0}; // D, U, L, R
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Pair> arr = new ArrayList<>();
    public int solution(String dirs) {
        int answer = 0;
        int curX = 0;
        int curY = 0;
        for(int i = 0; i < dirs.length(); i++) {
            System.out.println(curX + " " + curY);
            char c = dirs.charAt(i);
            int nx = curX;
            int ny = curY;
            int dir = 1;
            if(c == 'U') {
                nx = curX + dx[1];
                ny = curY + dy[1];
                dir = 1;
            }
            if(c == 'D') {
                nx = curX + dx[0];
                ny = curY + dy[0];
                dir = 0;
            }
            if(c == 'L') {
                nx = curX + dx[2];
                ny = curY + dy[2];
                dir = 2;
            }
            if(c == 'R') {
                nx = curX + dx[3];
                ny = curY + dy[3];
                dir = 3;
            }
            
            if(inRange(nx, ny)) {
                if(isFirstVisit(nx, ny, dir)) {
                    answer++;
                    arr.add(new Pair(nx, ny, dir));
                    if(dir == 0) arr.add(new Pair(curX, curY, 1));
                    if(dir == 1) arr.add(new Pair(curX, curY, 0));
                    if(dir == 2) arr.add(new Pair(curX, curY, 3));
                    if(dir == 3) arr.add(new Pair(curX, curY, 2));
                }
                
                curX = nx;
                curY = ny;
            }
        }
        
        return answer;
    }
    
    static boolean inRange(int x, int y) {
        return (-5 <= x && x <= 5) && (-5 <= y && y <= 5);
    }
    
    static boolean isFirstVisit(int x, int y, int dir) {
        for(Pair p : arr) {
            if(p.x == x && p.y == y && p.dir == dir) {
                return false;
            }
        }
        
        return true;
    }
}