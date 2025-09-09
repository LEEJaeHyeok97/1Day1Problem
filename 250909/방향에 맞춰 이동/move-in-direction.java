import java.util.Scanner;
public class Main {
    static int[] dx = new int[]{-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curX = 0, curY = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            // Please write your code here.
            if (direction == 'N') {
                for (int di = 0; di < distance; di++) {
                    curX += 1;
                }
            } else if (direction == 'E') {
                for (int di = 0; di < distance; di++) {
                    curY += 1;
                }
            } else if (direction == 'S') {
                for (int di = 0; di < distance; di++) {
                    curX -= 1;
                }
            } else if (direction == 'W') {
                for (int di = 0; di < distance; di++) {
                    curY -= 1;
                }
            }
        }

        System.out.println(curY + " " + curX);
    }
}