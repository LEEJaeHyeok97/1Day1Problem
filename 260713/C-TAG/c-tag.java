import java.util.*;

// A T G C 가 적절히 조합된 M개의 알파벳이 한 줄 적혀있는 종이가 2N장
// N장은 A그룹 나머지 N장은 B그룹
// 종이에 적힌 알파벳들 중 몇 번째 자리의 알파벳들이 종이의 그룹을 결정하는지
// M개의 자리 중 2개의 자리에 있는 알파벳들로 그룹을 구분할 수 있는지 살펴본다
// 순서가 다르다면(AT <-> TA) 다른 조합으로 간주한다.
// 백트래킹으로 각 줄의 경우의 수를 뽑는다. -> A그룹에서 N개의 줄에서 모두 겹치는것을뽑아냄
// B그룹에서 N개의 줄에서 모두 겹치는 것을 뽑아냄 -> 각 그룹의 가능한 경우의 수를 반환
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] groupA = new String[n];
        String[] groupB = new String[n];
        for (int i = 0; i < n; i++) {
            groupA[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            groupB[i] = sc.next();
        }

        int ans = 0;
        for(int i = 0; i < m - 2; i++) {
            for(int j = i+1; j < m; j++) {
                for(int k = j+1; k < m; k++) {
                    HashSet<String> s1 = new HashSet<>();
                    for(int t = 0; t < n; t++) {
                        s1.add("" + groupA[t].charAt(i) + groupA[t].charAt(j) + groupA[t].charAt(k));
                    }

                    HashSet<String> s2 = new HashSet<>();
                    for(int t = 0; t < n; t++) {
                        s2.add("" + groupB[t].charAt(i) + groupB[t].charAt(j) + groupB[t].charAt(k));
                    }

                    boolean flag = false;
                    for(String v : s1) {
                        if(s2.contains(v)) flag = true;
                    }

                    if(!flag) ans++;
                }
            }
        }

        System.out.println(ans);
    }
}