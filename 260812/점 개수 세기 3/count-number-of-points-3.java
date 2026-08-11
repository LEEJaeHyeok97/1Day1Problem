import java.util.*;

// a, b 값에 해당하는 위치에는 항상 점이 놓여있다.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> s = new TreeSet<>();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        Arrays.sort(points);
        for(int i = 0; i < n; i++) {
            map.put(points[i], i+1);
        }

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            int compressed1 = map.get(l);
            int compressed2 = map.get(r);

            System.out.println(compressed2 - compressed1 + 1);
        }        
    }
}