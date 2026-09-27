import java.util.*;

// 2N명이 N명씩 두 팀(A, B)으로 숫자 게임
// 모든 사원이 자연수를 하나씩 부여받는다.
// 각 사원은 딱 한 번씩 경기
// 숫자가 큰 쪽이 승리, 승리한 사원이 속한 팀은 승점 1점획득
// 숫자가 같으면 누구도 승점을 얻지 않는다.
// A팀의 출전순서를 보고 B팀의 가장 높은 최종 승점을 구한다.
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();
        
        for(int i = 0; i < A.length; i++) {
            arrA.add(A[i]);
            arrB.add(B[i]);
        }
        
        Collections.sort(arrA);
        Collections.sort(arrB);
        int j = 0;
        for(int i = 0; i < A.length; i++) {
            while(j < B.length && arrA.get(i) >= arrB.get(j)) {
                j++;
            }
            
            if(j == B.length) break;
            
            j++;
            answer++;
        }
        
        return answer;
    }
}