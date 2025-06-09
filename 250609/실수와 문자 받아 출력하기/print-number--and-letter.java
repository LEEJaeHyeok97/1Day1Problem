import java.util.scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        double a = sc.nextDouble(), b = sc.nextDouble();

        System.out.printf("%s\n%.2f\n%.2f", s, a, b);
    }
}