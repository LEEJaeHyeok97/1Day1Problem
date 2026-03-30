import java.util.Scanner;
// 1~N 숫자들을 단 한번씩만 써서 만들 수 있는 노드가 N개인 서로 다른 이진 탐색 트리 개수

public class Main {
    static final int UNUSED = -1;
    static final int MAX_NUM = 19;

    static int[] memo = new int[MAX_NUM + 1];

    static void initializeMemo() {
        for(int i = 0; i <= MAX_NUM; i++)
            memo[i] = UNUSED;
    }

    static int numOfUniqueBST(int n) {
        if(memo[n] != UNUSED)
            return memo[n];
        
        if(n <= 1)
            return 1;
        
        int numberOfUniqueBst = 0;
        for(int i = 0; i < n; i++) {
            numberOfUniqueBst += numOfUniqueBST(i) * numOfUniqueBST(n - i - 1);
        }

        return memo[n] = numberOfUniqueBst;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        initializeMemo();

        System.out.print(numOfUniqueBST(n));
    }
}