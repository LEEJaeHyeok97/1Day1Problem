import java.util.*;

public class Main {
    static LinkedList<Character> l = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        // String  = sc.nextLine();
        char[] c = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            l.add(c[i]);
        }
        ListIterator<Character> it = l.listIterator(l.size());
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if(command.equals("L")) {
                if(it.hasPrevious()) {
                    it.previous();
                } else {
                    continue;
                }
            } else if(command.equals("R")) {
                if(it.hasNext()) {
                    it.next();
                } else {
                    continue;
                }
            } else if(command.equals("D")) {
                if(it.hasNext()) {
                    it.next();
                    it.remove();
                } else {
                    continue;
                }
            } else if(command.equals("P")) {
                char x = sc.next().charAt(0);
                it.add(x);
            }
        }
        
        // Please write your code here.
        it = l.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next());
        }
    }
}