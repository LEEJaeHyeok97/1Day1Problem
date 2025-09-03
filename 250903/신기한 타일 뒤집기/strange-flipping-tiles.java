import java.util.Scanner;
// 회색 타일 일직선으로 무한 나열
// 왼쪽으로 뒤집으면 흰색
// 오른쪽으로 뒤집으면 검은색
public class Main {
    static final int MAX_RANGE = 200001;
    static final int OFFSET = 100000;

    static int[] arr = new int[MAX_RANGE];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // R R R R
        // L L L L L
        // R R R R R R R
        // R R R L L L L
        int cur = OFFSET;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            int x1, x2;
            if (d == 'L') {
                x1 = cur - (x - 1);
                x2 = cur;

                for (int di = x1; di <= x2; di++) {
                    arr[di] = 1; // 흰
                }

                cur -= (x - 1);
            } else {
                x1 = cur;
                x2 = cur + (x - 1);

                for (int di = x1; di <= x2; di++) {
                    arr[di] = 2; // 검
                }

                cur += (x - 1);
            }


        
        }
        
        // Please write your code here.
        int W_COUNT = 0;
        int B_COUNT = 0;
        for(int qi = 0; qi < MAX_RANGE; qi++) {
            if (arr[qi] == 1) W_COUNT+=1;
            else if (arr[qi] == 2) B_COUNT+=1;
        }

        System.out.println(W_COUNT + " " + B_COUNT);
    }
}