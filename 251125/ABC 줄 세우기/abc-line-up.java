import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }
        // Please write your code here.
        char[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // A B C D
        // A D B C
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(sortedArr[i] == arr[j]) {
                    ans += Math.abs(i - j);
                    break;
                }
            }
        }

        System.out.println(ans/2);
    }
}