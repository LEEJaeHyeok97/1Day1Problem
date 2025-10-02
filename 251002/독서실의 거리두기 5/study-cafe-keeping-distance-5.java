import java.util.Scanner;
public class Main {
    static int n;
    static char[] seat;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        seat = sc.next().toCharArray();
        // Please write your code here.

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(seat[i] == '0') {
                seat[i] = '1';
                ans = Math.max(ans, getMinDist());
                seat[i] = '0';
            }
        }

        System.out.println(ans);
    }

    static int getMinDist() {
        int minDist = n;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(seat[i] == '1' && seat[j] == '1')
                    minDist = Math.min(minDist, j - i);
            }
        }

        return minDist;
    }
}