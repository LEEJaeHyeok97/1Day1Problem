import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            total += arr[i];
        }
        long T = total /4;
        
        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];      

        long cur = 0;
        for(int i = 0; i < n; i++) {
            cur += arr[i];
            prefixSum[i] = cur;
        }

        cur = 0;
        for(int i = n-1; i >= 0; i--) {
            cur += arr[i];
            suffixSum[i] = cur;
        }        

        long[] sufCount = new long[n + 2];

        for (int k = n - 1; k >= 1; k--) {
            if(suffixSum[k] == T) {
                sufCount[k] = sufCount[k+1] +1;
            } else {
                sufCount[k] = sufCount[k+1];
            }
        }



        long countT = 0;
        long ans = 0;
        for(int i = 0; i < n - 2; i++) {
            if(prefixSum[i] == 2*T) {
                ans += (countT * sufCount[i+2]);
            }
            if(prefixSum[i] == T) {
                countT++;
            }
        }

        System.out.println(ans);
    }
}