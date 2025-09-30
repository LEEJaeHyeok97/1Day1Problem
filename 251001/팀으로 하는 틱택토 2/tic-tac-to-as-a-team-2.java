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
        boolean flag = false;
        for(int i = 0; i < 3; i++) {
            arr = new int[10];
            flag = false;
            for(int j = 0; j < 3; j++) {
                arr[Character.getNumericValue(inp[i].charAt(j))]++;
            }

            for(int j = 1; j < 10; j++) {
                if(arr[j] == 2) flag = true;
            }
            if(flag) ans++;
        }

        arr = new int[10];
        flag = false;
        for(int i = 0; i < 3; i++) {
            arr = new int[10];
            flag = false;
            for(int j = 0; j < 3; j++) {
                arr[Character.getNumericValue(inp[j].charAt(i))]++;
            }

            for(int j = 1; j < 10; j++) {
                if(arr[j] == 2) flag = true;
            }
            if(flag) ans++;
        }

        arr = new int[10];
        flag = false;
        arr[Character.getNumericValue(inp[0].charAt(0))]++;
        arr[Character.getNumericValue(inp[1].charAt(1))]++;
        arr[Character.getNumericValue(inp[2].charAt(2))]++;
        for(int j = 1; j < 10; j++) {
            if(arr[j] == 2) flag = true;
        }
        if(flag) ans++;

        arr = new int[10];
        flag = false;
        arr[Character.getNumericValue(inp[0].charAt(2))]++;
        arr[Character.getNumericValue(inp[1].charAt(1))]++;
        arr[Character.getNumericValue(inp[2].charAt(0))]++;
        for(int j = 1; j < 10; j++) {
            if(arr[j] == 2) flag = true;
        }
        if(flag) ans++;

        System.out.println(ans);
    }
}