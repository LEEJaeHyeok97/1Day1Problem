import java.util.*;
import java.io.*;

// 최고의 집합 ? - 1. 각 원소의 합이 S가 되는 수의 집합. 2. 1을 만족하며 각 원소의 곱이 최대
// { 1, 8 }, { 2, 7 }, { 3, 6 }, { 4, 5 } -> 최고의 집합은 {4,5}

class Solution {
    public int[] solution(int n, int s) {
        int tmp = s / n;
        int d = s % n;
        if (tmp * n > s || tmp == 0) {
            int[] li = new int[1];
            li[0] = -1;
            return li;
        }
        
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = tmp;
        }
        
        for (int i = n - d; i < n; i++) {
            answer[i] += 1;
        }
        
        int tmpValue = 0;
        for(int i = 0; i < answer.length; i++) {
            tmpValue += answer[i];
        }
        System.out.println(tmpValue);
        if (tmpValue != s) {
            int[] newAns = new int[1];
            newAns[0] = -1;
            return newAns;
        }
        return answer;
    }
}