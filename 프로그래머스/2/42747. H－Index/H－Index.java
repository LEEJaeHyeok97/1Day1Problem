
// 논문 n 편 중 h번 이상 인용된 논문이 h개 이상이고 나머지 논문이 h번 이하 인용되었다면
// h의 최댓값이 H-Index다.
// 논문 인용 횟수 citations가 주어질 때 H-Index를 반환하는 함수 작성
class Solution {
    public int solution(int[] citations) {
        
        // 0 <= n <= 10^3
        // 논문별 인용 횟수 0~10^4
        // 완탐 가능
        int ans = 0;
        for(int i = 0; i <= 10000; i++) {
            int overH = 0;
            int underH = 0;
            for(int j = 0; j < citations.length; j++) {
                if(citations[j] >= i) {
                    overH++;
                }
                if(citations[j] <= i) {
                    underH++;
                }
            }
            
            if(overH >= i && underH <= i) {
                ans = i;
            }
        }
        
        return ans;
    }
}