import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final int MAX_N = 100000;
    static final int MAX_K = 6;
    static final int MAX_DIGIT = 10;

    static int n;
    static int[] arr = new int[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        radixSort();

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void radixSort() {
        int p = 1;
        for (int pos = 0; pos < MAX_K; pos++) {
            ArrayList<Integer>[] arrNew = new ArrayList[MAX_DIGIT];
            for (int i = 0; i < MAX_DIGIT; i++) {
                arrNew[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                int digit = (arr[i] / p) % 10;
                arrNew[digit].add(arr[i]);
            }

            int index = 0;
            for (int i = 0; i < MAX_DIGIT; i++) {
                for (int j = 0; j < arrNew[i].size(); j++) {
                    arr[index++] = arrNew[i].get(j);
                }
            }

            p *= 10;
        }
    }
}
