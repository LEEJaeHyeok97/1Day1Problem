import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        // Please write your code here.

        int dist = 0;
        int speed = 1;
        int time = 0;

        while(dist < x) {
            dist += speed;
            time++;

            int remain = x - dist;

            if(remain == 0) break;

            int triNext = (speed + 1) * (speed + 2) / 2;
            int triCur = (speed) * (speed + 1) / 2;

            if(remain >= triNext) {
                speed++;
            } else if(remain >= triCur) {
                continue;
            } else {
                speed--;
                if(speed < 1) speed = 1;
            }
        }

        System.out.println(time);
    }
}