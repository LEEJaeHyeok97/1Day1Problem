import java.util.Scanner;
public class Main {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        int d = 0;
        int time = 0;
        int curX = 0;
        int curY = 0;
        // Please write your code here.
        for(int i = 0; i < commands.length(); i++) {
            char c = commands.charAt(i);

            if(c=='F') {
                curX += dx[d];
                curY += dy[d];
            } else if(c=='L') {
                d = (d + 3) % 4;
            } else if(c=='R') {
                d = (d + 1) % 4;
            }
            time+=1;
            if(curX == 0 && curY == 0) {
                System.out.print(time);
                return;
            }
        }

        System.out.println(-1);
    }
}