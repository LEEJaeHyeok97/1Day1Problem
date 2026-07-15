import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            TreeSet<Integer> m = new TreeSet<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                char command = sc.next().charAt(0);
                int num = sc.nextInt();

                if(command == 'I') {
                    m.add(num);
                } else {
                    if(m.isEmpty()) {
                        continue;
                    }
                    if(num == -1) {
                        m.remove(m.first());
                    } else {
                        m.remove(m.last());
                    }
                }
            }

            if(m.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(m.last() + " " + m.first());
            }
        }

        
    }
}