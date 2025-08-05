import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }
        // Please write your code here.
        for (int i = 0; i < queries.length; i++) {
            int value = queries[i];
            long count = Arrays.stream(arr)
                    .filter(x -> x == value)
                    .count();
            System.out.print(count+ " ");
        }
    }
}