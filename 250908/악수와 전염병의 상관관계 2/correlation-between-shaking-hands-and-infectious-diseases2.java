import java.util.*;

class Shake implements Comparable<Shake> {
    int time;
    int person1;
    int person2;

    public Shake(int time, int person1, int person2) {
        this.time = time;
        this.person1 = person1;
        this.person2 = person2;
    }

    @Override
    public int compareTo(Shake shake) {
        return time - shake.time;
    }
}

public class Main {

    static final int MAX_T = 250;
    static final int MAX_N = 100;

    static int[] shakeNum = new int[MAX_N + 1];
    static boolean[] infected = new boolean[MAX_N + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int t = sc.nextInt();
        infected[p] = true;
        
        Shake[] shakes = new Shake[MAX_T];
        for (int i = 0; i < t; i++) {
            int time = sc.nextInt();
            int person1 = sc.nextInt();
            int person2 = sc.nextInt();

            shakes[i] = new Shake(time, person1, person2);
        }

        Arrays.sort(shakes, 0, t);

        for (int i = 0; i < t; i++) {
            int target1 = shakes[i].person1;
            int target2 = shakes[i].person2;

            if(infected[target1])
                shakeNum[target1]++;
            if(infected[target2])
                shakeNum[target2]++;
            
            if(shakeNum[target1] <= k && infected[target1])
                infected[target2] = true;
            
            if(shakeNum[target2] <= k && infected[target2])
                infected[target1] = true;
        }

        for(int i = 1; i <= n; i++) {
            if(infected[i])
                System.out.print(1);
            else
                System.out.print(0);
        }

        // Please write your code here.
    }
}