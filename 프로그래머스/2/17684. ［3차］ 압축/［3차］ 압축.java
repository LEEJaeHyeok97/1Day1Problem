// LZW 압축
// 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
// 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
// 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
// 4. 입력에서 처리되지 않은 다음 글자가 있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
// 5. 단계2로 돌아간다.
import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int[] solution(String msg) {
        msg = msg.toLowerCase();
        int idx = 1;
        for(int i = 97; i < 123; i++) {
            map.put(String.valueOf((char) i), idx++);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        
        char[] c = msg.toCharArray();
        int curIdx = 0;
        int endIdx = 0;
        while(curIdx < c.length) {
            boolean found = false;
            for(int i = curIdx + 1; i <= c.length; i++) {
                endIdx = i;
                if(map.containsKey(msg.substring(curIdx, endIdx))) {
                    continue;
                } else {
                    answer.add(map.get(msg.substring(curIdx, endIdx-1)));
                    map.put(msg.substring(curIdx, endIdx), idx++);
                    curIdx = i -1;
                    found = true;
                    break;
                }
            }
            
            if(!found) {
                answer.add(map.get(msg.substring(curIdx, c.length)));
                curIdx = c.length;
            }
        }
        
        int[] ans = answer.stream().mapToInt(Integer::intValue).toArray();
        
        return ans;
    }
}