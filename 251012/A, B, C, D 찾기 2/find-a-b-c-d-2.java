import java.util.*;

public class Main {
    static int[] arr = new int[15];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        // Please write your code here.
        for(int a = 1; a <= 40; a++) {
            for(int b = a; b <= 40; b++) {
                for(int c = b; c <= 40; c++) {
                    for(int d = c; d <= 40; d++) {
                        int[] tmp = new int[15];
                        tmp[0] = a; tmp[1] = b; tmp[2] = c; tmp[3] = d; tmp[4] = a+b;
                        tmp[5] = b+c; tmp[6] = c+d; tmp[7] = d+a; tmp[8] = a+c; tmp[9] = b+d;
                        tmp[10] = a+b+c; tmp[11] = a+b+d; tmp[12] = a+c+d; tmp[13] = b+c+d;
                        tmp[14] = a+b+c+d;
                        Arrays.sort(tmp);
                        boolean flag = true;
                        for(int i = 0; i < 15; i++) {
                            if(tmp[i] != arr[i])
                                flag = false;
                        }
                        if(flag) System.out.println(a + " " + b + " " + c + " " + d);
                    }
                }
            }
        }
    }
}