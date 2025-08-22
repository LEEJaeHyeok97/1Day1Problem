import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> m1 = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> m2 = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            if (m1.containsKey(genres[i])) {
                m1.put(genres[i], m1.get(genres[i]) + plays[i]);
                m2.get(genres[i]).put(i, plays[i]);
            } else {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                m1.put(genres[i], plays[i]);
                m2.put(genres[i], map);
            }
        }
        
        ArrayList<String> keySet = new ArrayList<>(m1.keySet());
        // System.out.println(keySet);
        Collections.sort(keySet, (a, b) -> m1.get(b) - m1.get(a));
        // System.out.println(keySet);
        
        for (String k: keySet) {
            HashMap<Integer,Integer> tmp = m2.get(k);
            ArrayList<Integer> tmpKeySet = new ArrayList<>(tmp.keySet());
            Collections.sort(tmpKeySet, (a, b) -> tmp.get(b) - tmp.get(a));
            
            answer.add(tmpKeySet.get(0));
            if (tmpKeySet.size() > 1) {
                answer.add(tmpKeySet.get(1));
            }
        }
    
        return answer.stream().mapToInt(i -> i).toArray();
    }
}