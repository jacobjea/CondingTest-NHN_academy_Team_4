package SeungWook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class 파스칼의_삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[30+1][30+1];

        dp[0][0] = 0;

        dp[1][1] = 1;

        dp[2][1] = 1;
        dp[2][2] = 2;

        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for(int i = 4 ; i < dp.length; i++){
            dp[i][1] = 1;
            dp[i][i] = 1;
            for(int j = 2; j<i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
            }
        }
        System.out.println(dp[n][m]);
    }    
}
