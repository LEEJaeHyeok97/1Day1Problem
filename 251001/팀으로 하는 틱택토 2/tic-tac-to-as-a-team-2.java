import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = new String[3];
        String inp1 = sc.next();
        inp[0] = inp1;
        String inp2 = sc.next();
        inp[1] = inp2;
        String inp3 = sc.next();
        inp[2] = inp3;
        // Please write your code here.
        int[] arr = new int[10];
        // System.out.println(Character.getNumericValue(inp1.charAt(0)));

        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            arr = new int[10];
            cnt = 0;
            for(int j = 0; j < 3; j++) {
                arr[Character.getNumericValue(inp[i].charAt(j))]++;
            }

            for(int j = 1; j < 10; j++) {
                if(arr[j] > 0) cnt++;
            }
            if(cnt == 2) ans++;
        }

        arr = new int[10];
        for(int i = 0; i < 3; i++) {
            arr = new int[10];
            cnt = 0;
            for(int j = 0; j < 3; j++) {
                arr[Character.getNumericValue(inp[j].charAt(i))]++;
            }

            for(int j = 1; j < 10; j++) {
                if(arr[j] > 0) cnt++;
            }
            if(cnt == 2) ans++;
        }

        arr = new int[10];
        cnt = 0;
        arr[Character.getNumericValue(inp[0].charAt(0))]++;
        arr[Character.getNumericValue(inp[1].charAt(1))]++;
        arr[Character.getNumericValue(inp[2].charAt(2))]++;
        for(int j = 1; j < 10; j++) {
                if(arr[j] > 0) cnt++;
            }
            if(cnt == 2) ans++;

        arr = new int[10];
        cnt = 0;
        arr[Character.getNumericValue(inp[0].charAt(2))]++;
        arr[Character.getNumericValue(inp[1].charAt(1))]++;
        arr[Character.getNumericValue(inp[2].charAt(0))]++;
        for(int j = 1; j < 10; j++) {
                if(arr[j] > 0) cnt++;
            }
            if(cnt == 2) ans++;

        System.out.println(ans);
    }
}