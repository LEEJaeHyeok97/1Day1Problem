import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        if(b - a == 1 && c - b == 1) {
            System.out.println(0);
        } else if(b - a == 2 || c - b == 2) {
            System.out.println(1);
        } else if(b - a > 2 || c - b > 2) {
            System.out.println(2);
        }
    }
}