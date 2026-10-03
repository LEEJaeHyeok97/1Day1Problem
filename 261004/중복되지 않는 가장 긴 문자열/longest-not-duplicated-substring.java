import java.util.HashSet;
import java.util.Scanner;

// 길이 n 문자열
// 연속한 부분 문자열 중 중복되는 문자가 없는 가장 긴 부분 문자열 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int ans = 0;
        int j = 1;
        for(int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            j = i + 1; 
            while(j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }

            ans = Math.max(ans, set.size());
        }

        System.out.println(ans);
    }
}