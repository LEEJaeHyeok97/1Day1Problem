import java.util.Scanner;
public class Main {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curX = 0;
        int curY = 0;
        boolean flag = false;
        int time = 0;
        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            int d = getDir(dir);
            for(int j = 0; j < dist; j++) {
                if(flag == true && curX == 0 && curY == 0) {
                    System.out.println(time);
                    return;
                }

                curX = curX + dx[d];
                curY = curY + dy[d];
                if(curX == 0 && curY == 0) flag = true;
                time+=1;
            }

        }
        // Please write your code here.
        System.out.println(-1);
        
    }

    static int getDir(char dir) {
        if(dir == 'N') {
            return 0;
        } else if(dir == 'E') {
            return 1;
        } else if(dir == 'S') {
            return 2;
        } else {
            return 3;
        }
    }
}