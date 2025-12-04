import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        // Please write your code here.
        int minX1 = Math.min(x1, a1); 
        int minY1 = Math.min(y1, b1);
        int minX2 = Math.max(x2, a2);
        int minY2 = Math.max(y2, b2);

        int maxLen = Math.max((minX2 - minX1), (minY2 - minY1));
        System.out.println(maxLen * maxLen);
    }
}