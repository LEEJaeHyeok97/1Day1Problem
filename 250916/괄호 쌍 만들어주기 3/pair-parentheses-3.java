import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.
        int ans = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                for(int j = i + 1; j < str.length(); j++) {
                    if(str.charAt(j) == ')')
                        ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}