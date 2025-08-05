import java.util.*;
import java.io.*;

public class Main {
    public static int N, K;
    public static Integer[] li;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        li = new Integer[N];

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            li[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(li);
//        System.out.println(Arrays.deepToString(li));

        int left = 0;
        int right = li.length - 1;
        HashSet<List<Integer>> ans = new HashSet<>();
        while (left < right) {
            int total = li[left] + li[right];

//            System.out.println(total);


            if (total > K) {
                right -= 1;
            }
            if (total < K) {
                left += 1;
            }
            if (total == K) {
                int a = li[left];
                int b = li[right];
                ans.add(Arrays.asList(a, b));
                left += 1;
                right -= 1;
            }


        }

        System.out.println(ans.size());


    }
}
