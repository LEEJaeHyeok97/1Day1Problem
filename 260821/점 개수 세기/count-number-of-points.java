import java.util.*;
public class Main {

    static int[] points;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);
        for (int i = 0; i < Q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            
            System.out.println(upperBound(r) - lowerBound(l));
        }
    }

    static int lowerBound(int a) {
        int left = 0;
        int right = points.length;   // 끝을 하나 넘긴 지점
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (points[mid] < a) {
                left = mid + 1;      // mid는 후보에서 탈락
            } else {
                right = mid;         // mid도 후보로 남김
            }
        }
        return left;
}

    static int upperBound(int a) {
        int left = 0;
        int right = points.length;   // 끝을 하나 넘긴 지점
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (points[mid] <= a) {
                left = mid + 1;      // mid는 후보에서 탈락
            } else {
                right = mid;         // mid도 후보로 남김
            }
        }
        return left;
    }
}