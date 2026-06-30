import java.util.*;

// ()() (())() 는 올바른 괄호
// 문자열 s가 올바른 괄호 -> true, 아니면 -> false
class Solution {
    
    static LinkedList<Character> li = new LinkedList<>();
    boolean solution(String s) {
        char[] cArr = s.toCharArray();

        for(char c : cArr) {
            if(c == '(') {
                li.add(c);
            } else {
                if(li.size() > 0) {
                    li.pollLast();
                } else {
                    return false;
                }
            }
        }
        
        if(li.size() > 0) return false;
        return true;
    }
}