/*
1 37
1시간

2, 2
a1 = m-i

3 5
m 중에 n개 선정
m * (m - 1) * (m-2) * .. * (m-n-1) / n

2 * 1 / 2 = 1
5 / 1 = 5

nCr = n-1Cr-1 + n-1Cr

 */
import java.util.*;
public class 다리_놓기 {
    public static void main(String[] args) {
        final int MAX = 29;
        int[][] memo = new int [MAX+1][MAX+1];

        // nCr 
        // - r==1 : n
        // - r==0 : 0 -> 이미 변수 정의 때 0 됨
        for(int i=1; i<=MAX; i++) {
            memo[i][1] = i;
            memo[i][0] = 1;
        }

        // 2C1 = 1C0 + 1C1
        // n==r : 1
        for(int i=2; i<=MAX; i++) {
            for (int j=1; j<=MAX; j++) {
                memo[i][j] = memo[i-1][j-1] + memo[i-1][j];
            }
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(memo[m][n]);
        }
        
    }
}
