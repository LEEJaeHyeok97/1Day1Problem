import java.util.*;

// 1~N 번호표를 가진 총 N명의 사람, G개의 그룹
// 조건
// 1. 같은 사람이 동시에 여러 그룹에 속할 수 있다.
// 2. 그룹 내 모든 멤버가 정확히 일치하는 두 그룹은 없다.
// 그룹 인원수가 k인 그룹에서 k-1명의 사람들이 초대장을 받았다면 
// 나머지 한 사람도 무조건 초대장을 받아야 한다.
// 확실하게 초대장을 받게 되는 인원수를 반환.
public class Main {
    static final int MAX_G = 250000;
    static final int MAX_N = 100000;

    static int n, g;
    static boolean[] invited = new boolean[MAX_N];

    // 각 그룹마다 초대장을 받지 못한 사람들을 관리.
    static HashSet<Integer>[] groups = new HashSet[MAX_G];

    // 각 사람이 어떤 그룹에 속하는지를 고
    static ArrayList<Integer>[] peopleGroups = new ArrayList[MAX_N];
    static Queue<Integer> q = new LinkedList<>();
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = sc.nextInt();

        for(int i = 0; i < n; i++) {
            peopleGroups[i] = new ArrayList<>();
        }

        for(int i = 0; i < g; i++) {
            groups[i] = new HashSet<>();
        }

        for(int i = 0; i < g; i++) {
            int s = sc.nextInt();
            for(int j = 0; j < s; j++) {
                int x = sc.nextInt();
                x--;
                groups[i].add(x);
                peopleGroups[x].add(i);
            }
        }

        q.add(0);
        invited[0] = true;
        while(!q.isEmpty()) {
            int x = q.poll();
            ans++;

            for(int i = 0; i < peopleGroups[x].size(); i++) {
                int gNum = peopleGroups[x].get(i);

                groups[gNum].remove(x);
                if(groups[gNum].size() == 1) {
                    int pNum = new ArrayList<>(groups[gNum]).get(0);
                    if(!invited[pNum]) {
                        invited[pNum] = true;
                        q.add(pNum);
                    }
                }
            }
        }

        System.out.print(ans);
    }
}