import java.util.Scanner;

// 문자열의 길이 N
// C O W 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        int[] prefixSumC = new int[n];
        if(str.charAt(0) == 'C') prefixSumC[0] = 1;
        int[] prefixSumW = new int[n];
        if(str.charAt(n-1) == 'W') prefixSumW[n-1] = 1;

        for(int i = 1; i < n; i++) {
            if(str.charAt(i) == 'C') {
                prefixSumC[i] = prefixSumC[i-1] + 1;
            } else {
                prefixSumC[i] = prefixSumC[i-1];
            }
        }
        for(int i = n-2; i >= 0; i--) {
            if(str.charAt(i) == 'W') {
                prefixSumW[i] = prefixSumW[i+1] + 1;
            } else {
                prefixSumW[i] = prefixSumW[i+1];
            }
        }

        long ans = 0;
        for(int i = 1; i < n - 1; i++) {
            if(str.charAt(i) == 'O') ans += (prefixSumC[i-1] * prefixSumW[i+1]);
        }

        if(n <= 2) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}