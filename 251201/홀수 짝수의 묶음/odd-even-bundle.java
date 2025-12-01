import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int odd = 0;
        int even = 0;

        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if(x%2 == 0) even++;
            else odd++;
        }
        
        int groupNum = 0;

        while(true) {
            if(groupNum % 2 == 0) {
                if(even > 0) {
                    even--;
                    groupNum++;
                } else if(odd >= 2) {
                    odd -= 2;
                    groupNum++;
                } else {
                    if(even> 0 || odd >0) {
                        groupNum--;
                    }
                    break;
                }
            } else {
                if (odd > 0) {
                    odd--;
                    groupNum++;
                } else {
                    break;
                }
            }
        }

        System.out.println(groupNum);
    }
}
