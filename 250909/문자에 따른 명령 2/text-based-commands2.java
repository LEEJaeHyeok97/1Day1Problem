import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // Please write your code here.
        int cur_direction = 0;
        int curX = 0;
        int curY = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                cur_direction = (cur_direction + 1) % 4;
            } else if (s.charAt(i) == 'L') {
                cur_direction = (cur_direction + 3) % 4;
            } else if (s.charAt(i) == 'F') {
                curX += dx[cur_direction];
                curY += dy[cur_direction];
            }
        }

        System.out.println(curY + " " + curX);
    }
}