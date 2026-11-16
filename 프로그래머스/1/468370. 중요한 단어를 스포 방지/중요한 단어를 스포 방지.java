// 스포 방지 단어 중 중요한 단어의 수를 반환

// message를 공백을 기준으로 split한다
// spoiler_ranges를 순회하며 알파벳 대문자A같은걸로 maksing한 문자열 배열을 만든다.
// 마스킹 문자열 배열을 순회하며 마스킹 안된 문자들의 문자열 Set을 만든다.
// 마스킹 문자열 배열을 순회하면 복호화하고 문자열 set에 존재하는지 체크 후 없다면 ans++
import java.util.*;
class Solution {
    
    static Set<String> s = new HashSet<>();
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        char[] messages = message.toCharArray();
        for(int[] spo : spoiler_ranges) {
            int start = spo[0];
            int end = spo[1];
            
            for(int i = start; i <= end; i++) {
                if(messages[i] != ' ')
                    messages[i] = '*';
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char msg : messages) {
            sb.append(msg);
        }
        String toStr = sb.toString();
        String[] masking = toStr.split(" ");

        for(String str : masking) {
            boolean flag = false;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '*') {
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                continue;
            }
            
            s.add(str);
        }
        
        String[] tmp = message.split(" ");
        for (int i = 0; i < masking.length; i++) {
            if (masking[i].indexOf('*') != -1) {
                if (!s.contains(tmp[i])) answer++;
                s.add(tmp[i]); // 이미 공개된 단어로 등록 → 중복 방지
            }
        }
        
        return answer;
    }
}