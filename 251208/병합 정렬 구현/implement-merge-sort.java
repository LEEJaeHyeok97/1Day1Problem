import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    static int[] mergedArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        mergedArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        mergeSort(arr, 0, n-1);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                mergedArr[k] = arr[i];
                k += 1;
                i += 1;
            } else {
                mergedArr[k] = arr[j];
                k += 1;
                j += 1;
            }
        }

        while (i <= mid) {
            mergedArr[k] = arr[i];
            k+=1;
            i+=1;
        }

        while (j <= high) {
            mergedArr[k] = arr[j];
            k+=1;
            j+=1;
        }

        for(int t = low; t <= high; t++) {
            arr[t] = mergedArr[t];
        }
    }
}