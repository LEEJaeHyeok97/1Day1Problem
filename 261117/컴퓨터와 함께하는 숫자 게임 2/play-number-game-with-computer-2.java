import java.util.Scanner;

// 1~M 수를 컴퓨터가 선택
// 사람 A가 수를 예측하면 컴퓨터는 업인지 다운인지 예기함
// 숫자가 작거나 더 클 경우 다음 사람 턴으로 넘어가며 같은 경우 그 사람이 벌칙
// 항상 수는 가운데 값을 고른다.
// 게임이 가장 적게 지속될 때와, 가장 오래 지속될 때의 횟수를 공백을 사이에 두고 출력
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        int maxAns = Integer.MIN_VALUE;
        int minAns = Integer.MAX_VALUE;
        for(long c = a; c <= b; c++) {
            long left = 1;
            long right = m;

            int cnt = 0;
            while(left <= right) {
                long mid = (left + right) / 2;
                if(mid > c) {
                    right = mid - 1;
                } else if(mid < c) {
                    left = mid + 1;
                }
                cnt++;
                if(mid == c) {
                    break;
                }
            }

            maxAns = Math.max(maxAns, cnt);
            minAns = Math.min(minAns, cnt);
        }

        System.out.println(minAns + " " + maxAns);
    }
}