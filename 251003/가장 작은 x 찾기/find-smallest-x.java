import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        // Please write your code here.
        for(int i = a[0]; i < b[0]; i++) {
            boolean flag = false;
            if(i%2 == 0) {
                for(int j = 1; j < n; j++) {
                    if(i * 2 < a[j] || i * 2 > b[j]) {
                        flag = true;
                        continue;
                    }
                    if(flag) continue;
                    System.out.println(i / 2);
                    return;
                }
            }
        }
    }
}