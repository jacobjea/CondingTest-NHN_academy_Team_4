import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class 연속부분최대곱 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Double[] array = new Double[n];
        Double[] dp = new Double[n];
        for(int i = 0; i<n; i++){
            array[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = array[0];
        Double max = dp[0];
        for(int i = 1; i<n; i++){
            dp[i] = Math.max(dp[i-1] * array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        BigDecimal roundedMax =new BigDecimal(max).setScale(3,RoundingMode.HALF_UP);
        System.out.println(roundedMax);
    }
}
