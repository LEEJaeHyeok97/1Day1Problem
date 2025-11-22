import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        // Please write your code here.
        char[] arr = seats.toCharArray();
        // System.out.println(arr);
        int spot = 0;
        int prev = -1;
        int maxDistance = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1') {
                if(prev != -1) {
                    int dist = i - prev;
                    if(dist > maxDistance) {
                        maxDistance = dist;
                        spot = (prev + i) / 2;
                    }
                }

                prev = i;
            } 
        }

        arr[spot] = '1';
        int ans = Integer.MAX_VALUE;
        int prev2 = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1') {
                if(prev2 != -1) {
                    ans = Math.min(ans, i - prev2);
                }

                prev2 = i;
            }
        }

        System.out.println(ans);
    }
}