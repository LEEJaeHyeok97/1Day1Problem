import java.util.*;
// array 배열의 i번째 숫자부터 j번째 숫자까지 자르고 정렬, k번째에 있는 수는 몇인가.
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> arr = new ArrayList<>();
        int idx = 0;
        for(int[] command : commands) {
            arr = new ArrayList<>();
            
            for(int j = command[0] - 1; j < command[1]; j++) {
                arr.add(array[j]);
            }
            
            Collections.sort(arr);
            answer[idx++] = arr.get(command[2] - 1);
        }
        
        return answer;
    }
}