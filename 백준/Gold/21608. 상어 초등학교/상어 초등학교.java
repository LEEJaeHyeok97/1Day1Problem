import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// 아무도 없으면 비어 있는 칸이 가장 많은 칸을 선택..
// 학생의 만족도는 자리 배치가 끝난 후에 구할 수 있다.
// 그 학생과 인접한 칸에 앉은 좋아하는 학생의 수를 구해야 한다. 그 값이 0이면
// 학생 만족도는 0 /// 1이면 1// 2면 10// 3이면 100// 4면 1000
// 학생 만족도의 총 합을 구하자.
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Student {
    int num;
    int[] like;

    public Student(int num, int[] like) {
        this.num = num;
        this.like = like;
    }
}

public class Main {

    static int n;
    static ArrayList<Student> students;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] grid;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        students = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());

            int[] like = new int[4];
            for (int j = 0; j < 4; j++) {
                like[j] = Integer.parseInt(st.nextToken());
            }

            students.add(new Student(studentNum, like));
        }

        grid = new int[n][n];

        // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸
        // 2. 1을 만족하는 칸이 여러개면, 인접하는 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        // 3. 2를 만족하는 칸도 여러개면, 행의 번호가 가장 작은 칸으로, 다음은 열의 번호가 가장 작은 칸으로.
        for (int i = 0; i < n * n; i++) {
            placeStudent(students.get(i));
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int likeCnt = 0;

                for (int s = 0; s < students.size(); s++) {
                    if (grid[i][j] == students.get(s).num) {
                        int[] like = students.get(s).like;
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (inRange(nx, ny) && isLiked(students.get(s), grid[nx][ny])) {
                                likeCnt++;
                            }
                        }


                    }
                }

                if (likeCnt == 1) answer += 1;
                else if (likeCnt == 2) answer += 10;
                else if (likeCnt == 3) answer += 100;
                else if (likeCnt == 4) answer += 1000;
            }
        }

        System.out.println(answer);
    }

    static void placeStudent(Student student) {
        int bestX = -1;
        int bestY = -1;
        int bestLike = -1;
        int bestEmpty = -1;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] != 0) {
                    continue;
                }

                int likeCnt = 0;
                int emptyCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (!inRange(nx, ny)) {
                        continue;
                    }

                    if (grid[nx][ny] == 0) {
                        emptyCnt++;
                    } else if (isLiked(student, grid[nx][ny])) {
                        likeCnt++;
                    }
                }

                if (likeCnt > bestLike || (likeCnt == bestLike && emptyCnt > bestEmpty) || (likeCnt == bestLike
                        && emptyCnt == bestEmpty && x < bestX) || (likeCnt == bestLike && emptyCnt == bestEmpty
                        && x == bestX && y < bestY)) {
                    bestLike = likeCnt;
                    bestEmpty = emptyCnt;
                    bestX = x;
                    bestY = y;
                }
            }
        }

        grid[bestX][bestY] = student.num;
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }

    static boolean isLiked(Student student, int target) {
        for (int i = 0; i < 4; i++) {
            if (student.like[i] == target) {
                return true;
            }
        }
        return false;
    }
}
