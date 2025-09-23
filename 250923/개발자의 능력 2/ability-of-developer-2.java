import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        arr[4] = sc.nextInt();
        arr[5] = sc.nextInt();
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                for(int k = 0; k < 6; k++) {
                    for(int s = 0; s < 6; s++) {
                        for(int t = 0; t < 6; t++) {
                            for(int r = 0; r < 6; r++) {
                                if(i != j && i != k && i != s&& i != t && i != r && j != k && j != s && j != t && j != r && k != s && k != t && k != r && s != t && s != r && t != r) {
                                    int maxValue = Math.max(arr[i] + arr[j], Math.max(arr[k]+arr[s], arr[t]+arr[r]));
                                    int minValue = Math.min(arr[i] + arr[j], Math.min(arr[k]+arr[s], arr[t]+arr[r]));
                                    // System.out.println(maxValue + " " + minValue);
                                    ans = Math.min(ans, maxValue - minValue);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}