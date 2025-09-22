import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[101];
        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            char ch = sc.next().charAt(0);
            arr[position] = ch;
        }
        // Please write your code here.
        if(n == 1) {
            System.out.println(0);
            return;
        }// 1 3 4 7 10 16
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '\0') continue;
            int cnt_G = 0; int cnt_H = 0; boolean flag;
            for(int j = i; j < arr.length; j++) {
                flag = false;
                if(arr[j] == 'H') {
                    cnt_H++;
                    flag = true;
                }
                if(arr[j] == 'G') {
                    cnt_G++;
                    flag = true;
                }
                
                if(cnt_H != 0 && cnt_G == 0 && flag == true) {
                    ans = Math.max(ans, j - i);
                }
                if(cnt_H == 0 && cnt_G != 0 && flag == true) {
                    ans = Math.max(ans, j - i);
                }
                if(cnt_H == cnt_G && flag == true) {
                    ans = Math.max(ans, j - i);
                }
                
            }

        }

        System.out.println(ans);
    }
}