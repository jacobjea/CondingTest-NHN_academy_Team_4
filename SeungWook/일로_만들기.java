import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로_만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double max = Math.pow(10, 6);

        int[] dp = new int[(int)max+1];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i < dp.length; i++){
            dp[i] = dp[i-1]+1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i/3] +1, dp[i]);
            }
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            }
            
        }
        System.out.println(dp[n]);
    }
}
