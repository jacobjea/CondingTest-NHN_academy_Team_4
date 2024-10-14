import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_비스무리한_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] dp = new long[116+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-3];
        }

        System.out.println(dp[n]);
    }
}
