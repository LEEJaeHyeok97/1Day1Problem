import java.util.Scanner;
public class Main {

    static int[] score = new int[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int state = 6;
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            int s = sc.nextInt();

            if(c == 'A') score[0]+=s;
            if(c == 'B') score[1]+=s;
            if(c == 'C') score[2]+=s;

            if(calculateWinner() != state) {
                state = calculateWinner();
                ans++;
            }
        }
        // Please write your code here.
        System.out.println(ans);
    }

    static int calculateWinner() {
        if(score[0] > score[1] && score[0] > score[2]) return 0;
        if(score[1] > score[0] && score[1] > score[2]) return 1;
        if(score[2] > score[0] && score[2] > score[1]) return 2;

        if(score[0] == score[1] && score[1] > score[2]) return 3;
        if(score[0] == score[2] && score[2] > score[1]) return 4;
        if(score[1] == score[2] && score[2] > score[0]) return 5;

        return 6;
    }
}