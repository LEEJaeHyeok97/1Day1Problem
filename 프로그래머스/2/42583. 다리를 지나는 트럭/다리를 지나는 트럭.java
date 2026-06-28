// 모든 트럭이 다리를 건너려면 최소 몇 초?
// 다리에는 최대 bridge_length대 올라갈 수 있다.
// 다리는 weight 이하까지의 무게를 견딜 수 있다.
// 단, 다리에 완전히 오흐지 않은 트럭의 무게는 무시한다.
import java.util.*;
class Solution {
    static LinkedList<Integer> trucks = new LinkedList<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        for(int w : truck_weights) {
            trucks.add(w);
        }
        int[] bridge = new int[bridge_length];
        for(int i = 0; i < bridge_length; i++) {
            bridge[i] = 0;
        }
        while(!trucks.isEmpty() || onGoing(bridge)) {
            answer++;
            
            int[] tmp = new int[bridge_length];
            int idx = 0;
            for(int i = 0; i < bridge.length; i++) {
                if(bridge[i] == 0) {
                    idx++;
                    continue;
                } else {
                    if(idx == 0) {
                        tmp[idx] = 0;
                    } else {
                        tmp[idx - 1] = bridge[i];
                        tmp[idx] = 0;
                    }
                    idx++;
                }
            }
            
            bridge = tmp;
            
            if(!trucks.isEmpty()) {
                int curW = trucks.pollFirst();
                int curSum = Arrays.stream(bridge).sum();
            if(bridge[bridge.length - 1] == 0) {
                if(curSum + curW <= weight) {
                    bridge[bridge.length - 1] = curW;
                } else {
                    trucks.addFirst(curW);
                }
            }
            }
        }
        
        
        
        return answer;
    }
    
    static boolean onGoing(int[] bridge) {
        for(int i = 0; i < bridge.length; i++) {
            if(bridge[i] != 0) return true;
        }
        return false;
    }
}