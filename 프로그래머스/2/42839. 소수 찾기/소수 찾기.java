import java.util.*;

class Solution {
    static ArrayList<Integer> nums = new ArrayList<>();
    static HashSet<Integer> s = new HashSet<>();
    static boolean[] visited;
    static int ans = 0;
    static char[] arr;
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        arr = numbers.toCharArray();
        backtracking();
        answer = s.size();
        return answer;
    }
    
    static void backtracking() {
        if(nums.size() > 0) isPrime();
        
        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            nums.add(Character.getNumericValue(arr[i]));
            visited[i] = true;
            backtracking();
            nums.remove(nums.size() - 1);
            visited[i] = false;
        }
    }
    
    static void isPrime() {
        String tmp = "";
        for(int i = 0; i < nums.size(); i++) {
            tmp += nums.get(i);
        }
        int processed = Integer.parseInt(tmp);
        int cnt = 0;
        HashSet<Integer> tmpSet = new HashSet<>();
        for(int i = 1; i * i <= processed; i++) {
            if(processed % i == 0) {
                tmpSet.add(processed / i);
                tmpSet.add(i);
            }
        }
        
        if(tmpSet.size() == 2) {
            s.add(processed);
        }
    }
}