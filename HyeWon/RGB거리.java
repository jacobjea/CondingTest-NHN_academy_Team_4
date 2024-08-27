/*
1. 아이디어
a int[n][3]
input int[n][3]
for n
    for 3
        aij = min(a[i-1][j+1]+input[i][j], a[i-1][j+2]+input[i][j])

2. 복잡도
n*3 = O(N) = 3000
 */

import java.util.*;
import java.util.StringTokenizer;
public class RGB거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] rgb = new int[n][3];
        for(int i=0; i<n; i++) {
            // StringTokenizer st = br.readLine().

            for(int j=0; j<3; j++) {
                // rgb[i][j] = Integer.parseInt(s.charAt(j));
                rgb[i][j] = sc.nextInt();
            }
        }

        int[][] memo = new int[n+1][3];
        Arrays.fill(memo[0], 0);

        for(int i=1; i<n+1; i++){
            for(int j=0; j<3; j++){
                // System.out.printf("%d %d\n", (j+1)%3, (j+2)%3);
                memo[i][j] = Math.min(memo[i-1][(j+1)%3] + rgb[i-1][j], memo[i-1][(j+2)%3] + rgb[i-1][j]);
            }
        }

        // System.out.println(Arrays.toString(memo[n]));

        int result = memo[n][0];
        for(int i=1; i<3; i++)
            if (result > memo[n][i]) 
                result = memo[n][i];
        
        System.out.println(result);
    }
}
