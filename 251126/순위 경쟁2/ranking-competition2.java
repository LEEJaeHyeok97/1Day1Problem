import java.util.Scanner;
public class Main {
    static final int MAX_N = 100;

    static int n;
    static char[] name = new char[MAX_N];
    static int[] value = new int[MAX_N];

    static int scoreA = 0, scoreB = 0;

    static int status(int score1, int score2) {
        if(score1 > score2) {
            return 1;
        } else if(score2 > score1) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            name[i] = sc.next().charAt(0);
            value[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(name[i] == 'A') {
                if(status(scoreA, scoreB) != status(scoreA + value[i], scoreB)) {
                    ans++;
                }

                scoreA += value[i];
            }

            if(name[i] == 'B') {
                if(status(scoreA, scoreB) != status(scoreA, scoreB + value[i])) {
                    ans++;
                }

                scoreB += value[i];
            }
        }

        System.out.println(ans);
    }
}