import java.util.HashSet;
import java.util.Scanner;

// 길이 N 문자열 한 개
// 연속한 서로 다른 문자의 수가 k개를 넘지 않는 가장 긴 부분 문자열 길이
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++) {
            int j = i;
            HashSet<Character> set = new HashSet<>();
            while(j < s.length() && set.size() <= k) {
                if(set.size() == k && !set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
                j++;
            }

            ans = Math.max(ans, j - i);
        }

        System.out.println(ans);
    }
}