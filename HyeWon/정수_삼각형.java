/*
int[n][n+2]
for n
    a[i][0] = 0
    for 1 ~ i+1까지 : a[i][j] = input
    a[i][i+2] = 0

cnt[n][n+1] = 0초기화
cnt[0][1] = 7
for 1, n전
    for i : 
 */
import java.util.*;
public class 정수_삼각형 {
    static int[][] nums;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        nums = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<i+1; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        // for(int i=0; i<n; i++) {
        //     System.out.println(Arrays.toString(nums[i]));
        // }

        memo = new int[n][n+1];
        memo[0][1] = nums[0][0];

        // for(int i=0; i<n; i++) {
        //     System.out.println(Arrays.toString(memo[i]));
        // }

        for(int i=1; i<n; i++) {
            for(int j=1; j<i+2; j++) { // 1, 2
                if (memo[i-1][j-1] > memo[i-1][j]) { // 0, 1 vs 0, 2
                    memo[i][j] = memo[i-1][j-1] + nums[i][j-1];
                } else {
                    memo[i][j] = memo[i-1][j] + nums[i][j-1];
                }
            }
        }

        // for(int i=0; i<n; i++) {
        //     System.out.println(Arrays.toString(memo[i]));
        // }

        int result = memo[n-1][0];
        for(int i=1; i<n+1; i++) {
            // System.out.println(">> "+result + ", " + memo[n-1][i]);
            result = Math.max(result, memo[n-1][i]);
        }

        System.out.println(result);
    }
}
