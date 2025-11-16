import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[] viewed;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N + 1];
        viewed = new int[N + 1];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int pigeon = sc.nextInt();
            int moveDir = sc.nextInt();

            if(viewed[pigeon] > 0) {
                // System.out.println(arr[pigeon]);
                if(moveDir != arr[pigeon]) {
                    ans++;
                }
            }
            arr[pigeon] = moveDir;
            viewed[pigeon] += 1;
        }
        // Please write your code here.
        System.out.println(ans);
    }
}