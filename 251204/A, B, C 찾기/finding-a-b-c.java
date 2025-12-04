import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        Arrays.sort(arr);
        int A = arr[0];
        int B = arr[1];
        int C = arr[6] - A - B;
        System.out.println(A + " " + B + " " + C);
    }
}