import java.util.Scanner;
// Carry 가 X 면서 최대값
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(!isCarry(arr[i], arr[j], arr[k])) {
                        continue;
                    }
                    ans = Math.max(ans, (arr[i] + arr[j] + arr[k]));
                    flag = true;
                }
            }
        }
        if(flag == false) System.out.println(-1);
        else System.out.println(ans);
    }

    static boolean isCarry(int n1, int n2, int n3) {
        int tmp = 10;
        int t1 = n1; int t2 = n2; int t3 = n3;
        for(int i = 0; i < 5; i++) {
            if(t1 % tmp + t2 % tmp + t3 % tmp >= 10) {
                return false;
            } 
            t1 /= 10; t2 /= 10; t3 /= 10;
        }

        return true;
    }
}