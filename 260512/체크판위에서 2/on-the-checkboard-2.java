import java.util.Scanner;

// R X C 직사각형의 각 칸이 'W', 'B'로 표현.
// 왼쪽 상단(0,0) 출발 -> 우측 하단(R-1, C-1)
// 특정 룰을 만족하면서 이동에 성공할 수 있는 경우의 수를 구하시오.
// 1. 이동(점프) 시 항상 현재 위치에 색과 점프한 이후의 칸에 있는 색이 달라야한다.
// 2. 점프 진행 시 현재 위치에서 한칸 이상 오른쪽 이며 동시에 한칸 이상 아래쪽에 있는 위치
// 로만 점프 가능.
// 정확히 시작, 도착 지점을 제외하고 점프하며 도달한 위치가 정확히 2곳 뿐이어야 한다.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        int ans = 0;
        for(int i = 1; i < R; i++) {
            for(int j = 1; j < C; j++) {
                for(int i2 = i + 1; i2 < R - 1; i2++) {
                    for(int j2 = j + 1; j2 < C - 1; j2++) {
                        if((grid[i][j] != grid[0][0]) && (grid[i2][j2] != grid[i][j]) && (grid[i2][j2] != grid[R-1][C-1]))
                            ans++;
                    }
                }
            }
        }
        

        System.out.println(ans);
    }
}