import java.util.Scanner;
// 1- 가위 2 - 바위 3 - 보
// 1- 가위 2 - 보 3 - 바위
// 1 - 바위 2 - 가위 3 - 보
// 1 - 바위 2 - 보 3 - 가위
// 1 - 보 2 - 가위 3 - 바위
// 1 - 보 2 - 바위 3 - 가위
public class Main {

    static int[][] arr;
    static String[][] game = {{"가위", "바위", "보"}, {"가위", "보", "바위"}, {"바위", "가위", "보"}, {"바위", "보", "가위"}, {"보", "가위", "바위"}, {"보", "바위", "가위"}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][2];
        for(int i = 0; i < n; i++){
            int first = sc.nextInt();
            int second = sc.nextInt();
            arr[i][0] = first;
            arr[i][1] = second;
        }
        // Please write your code here.
        int ans = 0;
        int tmp = 0;
        for(int i = 0; i < 6; i++) {
            String[] curGame = game[i];
            tmp = 0;
            for(int j = 0; j < arr.length; j++) {
                tmp += calculateCount(curGame[arr[j][0] - 1], curGame[arr[j][1] - 1]);
            }

            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }

    static int calculateCount(String a, String b) {
        if(a == "가위" && b == "보") {
            return 1;
        } else if(a == "바위" && b == "가위") {
            return 1;
        } else if(a == "보" && b == "바위") {
            return 1;
        }
        return 0;
    }
}