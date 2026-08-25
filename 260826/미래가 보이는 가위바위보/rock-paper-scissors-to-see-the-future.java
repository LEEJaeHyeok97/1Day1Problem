import java.util.*;

// A와 B가 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] matches = new char[n];
        for (int i = 0; i < n; i++) {
            matches[i] = sc.next().charAt(0);
        }
        // Please write your code here.
        int[] prefixSumLeftH = new int[n];
        int[] prefixSumRightH = new int[n];
        int[] prefixSumLeftS = new int[n];
        int[] prefixSumRightS = new int[n];
        int[] prefixSumLeftP = new int[n];
        int[] prefixSumRightP = new int[n];
        if(matches[0] == 'H') {
            prefixSumLeftP[0] = 1;
        }
        if(matches[0] == 'S') {
            prefixSumLeftH[0] = 1;
        }
        if(matches[0] == 'P') {
            prefixSumLeftS[0] = 1;
        }
        if(matches[n-1] == 'H') {
            prefixSumRightP[n-1] = 1;
        }
        if(matches[n-1] == 'S') {
            prefixSumRightH[n-1] = 1;
        }
        if(matches[n-1] == 'P') {
            prefixSumRightS[n-1] = 1;
        }
        for(int i = 1; i < n; i++) {
            if(matches[i] == 'H') {
                prefixSumLeftP[i] = prefixSumLeftP[i-1] + 1;
            } else {
                prefixSumLeftP[i] = prefixSumLeftP[i-1];
            }
            if(matches[i] == 'S') {
                prefixSumLeftH[i] = prefixSumLeftH[i-1] + 1;
            } else {
                prefixSumLeftH[i] = prefixSumLeftH[i-1];
            }
            if(matches[i] == 'P') {
                prefixSumLeftS[i] = prefixSumLeftS[i-1] + 1;
            } else {
                prefixSumLeftS[i] = prefixSumLeftS[i-1];
            }
        }

        for(int i = n-2; i >= 0; i--) {
            if(matches[i] == 'H') {
                prefixSumRightP[i] = prefixSumRightP[i+1] + 1;
            } else {
                prefixSumRightP[i] = prefixSumRightP[i+1];
            }
            if(matches[i] == 'S') {
                prefixSumRightH[i] = prefixSumRightH[i+1] + 1;
            } else {
                prefixSumRightH[i] = prefixSumRightH[i+1];
            }
            if(matches[i] == 'P') {
                prefixSumRightS[i] = prefixSumRightS[i+1] + 1;
            } else {
                prefixSumRightS[i] = prefixSumRightS[i+1];
            }
        }

        int ans = Math.max(prefixSumLeftH[n-1],
           Math.max(prefixSumLeftS[n-1], prefixSumLeftP[n-1]));
        for(int i = 1; i < n; i++) {
            // l: h, r: s
            ans = Math.max(ans, (prefixSumLeftH[i-1] + prefixSumRightS[i]));

            // l: h, r: p
            ans = Math.max(ans, (prefixSumLeftH[i-1] + prefixSumRightP[i]));

            // l: s, r: h
            ans = Math.max(ans, (prefixSumLeftS[i-1] + prefixSumRightH[i]));

            // l: s, r: p
            ans = Math.max(ans, (prefixSumLeftS[i-1] + prefixSumRightP[i]));

            // l: p, r: s
            ans = Math.max(ans, (prefixSumLeftP[i-1] + prefixSumRightS[i]));

            // ;: p, r: h
            ans = Math.max(ans, (prefixSumLeftP[i-1] + prefixSumRightH[i]));
        }

        System.out.println(ans);
    }
}