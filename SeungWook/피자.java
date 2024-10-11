package SeungWook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class 피자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[10+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for(int i = 3 ; i<dp.length; i++){
            int divide = i / 2;
            dp[i] = (i-divide) * divide + dp[i-divide] +dp[divide];
        }
        System.out.println(dp[n]);
    }
}
