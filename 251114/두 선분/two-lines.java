import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        // Please write your code here.
        for(int i = x1; i < x2 + 1; i++) {
            for(int j = x3; j < x4 + 1; j++) {
                if(i == j) {
                    System.out.println("intersecting");
                    return;
                }
            }
        }

        System.out.println("nonintersecting");
    }
}