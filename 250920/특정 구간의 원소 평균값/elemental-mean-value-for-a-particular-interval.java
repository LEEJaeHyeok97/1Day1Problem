import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int tmp = 0;
                for(int k = i; k <= j; k++) {
                    tmp += arr[k];
                }
                if(tmp % (j + 1 - i) == 0) {
                    for(int s = i; s <= j; s++) {
                        if(arr[s] == tmp / (j + 1 - i)) {
                            ans += 1;
                            break;
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        System.out.println(ans);
    }
}