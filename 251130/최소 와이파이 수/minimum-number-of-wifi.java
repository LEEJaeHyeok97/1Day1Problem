import java.util.Scanner;
// 1: 사람이 산다, 0: 사람이 살지 않는다.
// 와이파이는 m이내에 사람들 전부 사용 가능 어디든 정수 위치 설치가능
// 모든 사람들이 와이파이를 사용할 수 있도록하는 최소 와이파이 수를 출력
// 1 1 0 1
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int ans = 0;
        if(n <= 2*m + 1) {
            System.out.println(1);
        }
        else {
            for(int i = 0; i < n; i+=(2*m+1)) {
                for(int j = i; j < j+2*m+1; j++) {
                    if(arr[j] == 1) {
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}