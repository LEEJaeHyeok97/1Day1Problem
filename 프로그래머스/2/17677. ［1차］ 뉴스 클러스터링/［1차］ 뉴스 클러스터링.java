import java.util.*;

// 자카드 유사도는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값
// 두 집합이 모두 공집합일 경우 1로 정의
// 다중집합일 시 교집합은 min 합집합은 max
// 두 글자씩 끊어서 다중집합의 원소로 만든다.
// 기타 공백이나 숫자, 특수문자가 들어있는 경우는 그 글자 쌍을 버린다.
// 대문자와 소문자 차이는 무시.
// 유사도 값은 65536을 곱한 후 소수점 아래를 버린다.
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        Set<String> total = new TreeSet<>();
        for(int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            
            if(('a' <= a && a <= 'z') || ('A' <= a && a <= 'Z')) {
                if(('a' <= b && b <= 'z') || ('A' <= b && b <= 'Z')) {
                    arr1.add("" + a + b);
                    total.add("" + a + b);
                }
            }
        }
        for(int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            
            if(('a' <= a && a <= 'z') || ('A' <= a && a <= 'Z')) {
                if(('a' <= b && b <= 'z') || ('A' <= b && b <= 'Z')) {
                    arr2.add("" + a + b);
                    total.add("" + a + b);
                }
            }
        }
        
        //교집합 계산
        int cc = 0;
        for(String st : total) {
            int aVal = 0;
            int bVal = 0;
            for(int i = 0; i < arr1.size(); i++) {
                if(st.equals(arr1.get(i))) aVal++;
            }
            for(int i = 0; i < arr2.size(); i++) {
                if(st.equals(arr2.get(i))) bVal++;
            }
            cc += Math.min(aVal, bVal);
        }
        // 합집합 계산
        int h = 0;
        for(String st : total) {
            int aVal = 0;
            int bVal = 0;
            for(int i = 0; i < arr1.size(); i++) {
                if(st.equals(arr1.get(i))) aVal++;
            }
            for(int i = 0; i < arr2.size(); i++) {
                if(st.equals(arr2.get(i))) bVal++;
            }
            h += Math.max(aVal, bVal);
        }
        
        // 계산
        if( cc == 0 && h == 0) answer = 1 * 65536;
        else {
            answer = (int) (((double) cc / h) * 65536);
        }
        
        return answer;
    }
}