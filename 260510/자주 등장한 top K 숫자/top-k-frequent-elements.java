import java.util.*;

class Pair implements Comparable<Pair> {
    int cnt, num;

    public Pair(int cnt, int num) {
        this.cnt = cnt;
        this.num = num;
    }

    @Override
    public int compareTo(Pair b) {
        if(cnt != b.cnt) return cnt - b.cnt;
        return num - b.num;
    }
}

public class Main {
    static final int MAX_N = 100000;

    static int n, k;
    static int[] arr;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static ArrayList<Pair> v = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        for(Integer key : map.keySet()) {
            v.add(new Pair(map.get(key), key));
        }

        Collections.sort(v);

        for(int i = v.size() - 1; i >= v.size() - k; i--) {
            System.out.print(v.get(i).num + " ");
        }
    }
}