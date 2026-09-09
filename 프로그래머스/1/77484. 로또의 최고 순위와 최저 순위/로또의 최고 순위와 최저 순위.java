// 로또는 1~45중 6개를 찍어맞히는복권
// 알아볼 수 없는 번호를 0으로 표기
// 당첨 가능한 최고 순위와 최저 순위를 배열에 담아 반환

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 현재 몇 개가 맞았는지 계산
        int cnt = 0;
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(lottos[i] == win_nums[j]) {
                    cnt++;
                    break;
                }
            }
        }
        
        // 0의 갯수 계산
        int zeroCnt = 0;
        for(int i = 0; i < 6; i++) {
            if(lottos[i] == 0) zeroCnt++;
        }
        
        // 0이 1개 이상이라면 최대한 정답 번호로 교환했을 때 최고 몇등이 가능한지 계산
        int topRank = cnt + zeroCnt;
        
        
        // 최대한 틀린 번호로 계산했을 때 최저 몇 등이 가능한지 계산 -> cnt
        
        // 맞은 갯수를 등수로 변환
        int[] answer = {calculateRank(topRank), calculateRank(cnt)};
        
        return answer;
    }
    
    static int calculateRank(int num) {
        if(num == 6) return 1;
        else if(num == 5) return 2;
        else if(num == 4) return 3;
        else if(num == 3) return 4;
        else if(num == 2) return 5;
        else return 6;
    }
}