import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        // Please write your code here.
        int i = 0;
        int j; int ans = 0;
        while(i < input.length() - 3) {
            if(input.charAt(i) == '(' && input.charAt(i+1) == '(') {
                j = i+2;
                while(j < input.length() - 1) {
                    if(input.charAt(j) == ')' && input.charAt(j + 1) == ')') {
                        ans += 1;
                    }
                    j++;
                }
            }
            i++;
        }
        System.out.println(ans);
    }
}