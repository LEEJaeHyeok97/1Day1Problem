import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int CONDITION_NUM = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 0) {
            if ((n / 10 + n % 10) % CONDITION_NUM == 0) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
        br.close();
    }
}