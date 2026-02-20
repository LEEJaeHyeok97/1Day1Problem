import java.util.*;

public class Main {

    static int alphaCnt;
    static int ans;
    static String expression;

    static ArrayList<Integer> selected = new ArrayList<>();
    static int[] arr = new int[6]; // a, b, c, d, e, f
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expression = sc.next();
        
        for(int i = 0; i < 6; i++) {
            arr[i] = -1;
        }
        
        alphaCnt = 0;
        for(int i = 0; i < expression.length(); i++) {
            if(isAlpha(expression.charAt(i))) {
                arr[findIdx(expression.charAt(i))] = 0; // 쓰는 알파벳만 0으로 초기화
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) alphaCnt++;
        }

        ans = Integer.MIN_VALUE;
        comb(0);

        System.out.println(ans);
    }

    static void comb(int cnt) {
        if(cnt == alphaCnt) {
            ans = Math.max(ans, calc());
            return;
        }

        for(int i = 1; i < 5; i++) {
            selected.add(i);
            comb(cnt + 1);
            selected.remove(selected.size() - 1);
        }
    }

    static int calc() {
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                arr[i] = selected.get(idx++);
            }
        }

        int tmp = arr[findIdx(expression.charAt(0))];
        char tmpOp = '.';
        int tmpVal = 0;
        for(int i = 1; i < expression.length(); i++) {
            if(findIdx(expression.charAt(i)) != -1) {
                // 숫자
                tmpVal = arr[findIdx(expression.charAt(i))];

                // 숫자가 입력될 때마다 계산까지 함께 진행
                if(tmpOp == '+') {
                    tmp += tmpVal;
                }
                if(tmpOp == '-') {
                    tmp -= tmpVal;
                }
                if(tmpOp == '*') {
                    tmp *= tmpVal;
                }
            } else {
                // 연산기호
                tmpOp = expression.charAt(i);
            }
        }


        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                arr[i] = 0;
            }
        }

        return tmp;
    }

    static int findIdx(char c) {
        if(c == 'a') return 0;
        if(c == 'b') return 1;
        if(c == 'c') return 2;
        if(c == 'd') return 3;
        if(c == 'e') return 4;
        if(c == 'f') return 5;
        return -1;
    }

    static boolean isAlpha(char c) {
        if(c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f') return true;
        return false;
    }
}