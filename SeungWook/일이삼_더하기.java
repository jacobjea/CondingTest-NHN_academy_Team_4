import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class 일이삼_더하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int max = 11;

        int[] dp = new int[max+1];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i<=max; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i -3] ;
        }

        for(int i = 0; i<n; i++){
            int value = Integer.parseInt(br.readLine());
            System.out.println(dp[value]);
        }
        
    }
    
}
