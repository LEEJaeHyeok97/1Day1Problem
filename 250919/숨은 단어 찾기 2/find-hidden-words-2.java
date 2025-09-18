import java.util.Scanner;
public class Main {
    static int[] dx = new int[]{};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Char[][] arr = new Char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for(int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        // Please write your code here.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

            }
        }
        
    }
}