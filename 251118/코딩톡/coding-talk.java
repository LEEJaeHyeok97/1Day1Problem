import java.util.Scanner;
public class Main {
    static final int MAX_M = 100;

    static int n, p, m;
    static char[] c = new char[MAX_M];
    static int[] u = new int[MAX_M];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        for (int i = 0; i < m; i++) {
            c[i] = sc.next().charAt(0);
            u[i] = sc.nextInt();
        }
        // Please write your code here.
        if(u[p - 1] == 0)
            System.exit(0);
        
        for(int i = 0; i < n; i++) {
            char person = (char)((int)'A' + i);
            boolean read = false;

            for(int j = 0; j < m; j++) {
                if(u[j] >= u[p-1] && c[j] == person)
                    read = true;
            }

            if(read == false)
                System.out.print(person + " ");
        }
    }
}