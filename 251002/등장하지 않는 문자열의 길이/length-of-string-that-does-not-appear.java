import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        // Please write your code here.
        int ans = 1;
        for(int i = 1; i < n; i++) {
            boolean twice = false;

            for(int j = 0; j <= n - i; j++) {
                for(int k = j + 1; k <= n - i; k++) {
                    boolean issame = true;

                    for(int l = 0; l < i; l++) {
                        if(str.charAt(j + l) != str.charAt(k + l))
                            issame = false;
                    }

                    if(issame) twice= true;
                }
            }

            if(twice) ans = i + 1;
            else
                break;
        }

        System.out.println(ans);
    }
}