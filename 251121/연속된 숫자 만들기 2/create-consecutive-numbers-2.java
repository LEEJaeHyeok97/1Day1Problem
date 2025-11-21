import java.util.*;

// 0 - 이미 연속된 경우
// 1 - 2개의 숫자가 연속된 경우
// 2 - 3개 모두 연속되지 않은 경우
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = {a, b, c};
        // Please write your code here.
        Arrays.sort(arr);
        
        if((arr[2] - arr[1] == 1) && (arr[1] - arr[0]) == 1) {
            System.out.println(0);
        } else if((arr[2] - arr[1]) == 1 && (arr[1] - arr[0]) != 1) {
            System.out.println(1);
        } else if((arr[1] - arr[0]) == 1 && (arr[2] - arr[1]) != 1) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}