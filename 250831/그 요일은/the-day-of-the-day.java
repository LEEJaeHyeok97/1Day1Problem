import java.util.Scanner;

public class Main {
    static int[] days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int calculateDay(int m, int d) {
        int cal_days = 0;
        for(int i = 1; i < m; i++) {
            cal_days += days[i];
        }

        cal_days += d;
        return cal_days;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.
        
        int d = calculateDay(m2, d2) - calculateDay(m1, d1);
        int tmp = 0;
        int ans;

        while (d < 0)
            d += 7;

        String[] dayOfWeek = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for(int i = 0; i < 7; i++) {
            if(dayOfWeek[i].equals(A)) {
                tmp = i;
                break;
            }
        }
        ans = d / 7;
        if (d%7 >= tmp) {
            ans +=1;
        }
        System.out.println(ans);
        
    }
}