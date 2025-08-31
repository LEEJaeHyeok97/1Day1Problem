import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.
        int num = 0;
        for(int i = 0; i < binary.length(); i++) {
            num = num * 2 + Integer.parseInt(String.valueOf(binary.charAt(i)));
        }

        num *= 17;
        
        int tmp = 0;
        int[] arr = new int[num];
        while (true) {
            if (num < 2) {
                arr[tmp] = num;
                break;
            }

            arr[tmp++] = num % 2;
            num /= 2;
        }

        for(int i = tmp; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}