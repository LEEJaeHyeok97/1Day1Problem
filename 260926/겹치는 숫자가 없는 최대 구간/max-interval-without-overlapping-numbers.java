import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] countArr = new int[100001];
        int j = 0;
        int ans = 0;
        countArr[arr[0]]++;
        for(int i = 0; i < n; i++) {
            while(j + 1 < n && countArr[arr[j+1]] != 1) {
                countArr[arr[j+1]]++;
                j++;
            }

            ans = Math.max(ans, j - i + 1);
            // System.out.println(i + " " + j);
            countArr[arr[i]]--;
        }

        System.out.println(ans);
    }
}