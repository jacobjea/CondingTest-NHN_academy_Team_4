import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 앞에 숫자부터 쪼개서 dp로 쌓아올린다.
// 앞에 2개의 숫자로만 판단하기 next 앞에 3개의 숫자로만 판단하기
//

public class 가장_긴_감소하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<n; i++){
            dp[i] = 1;
        }
        
        for(int i = 1; i< n; i++){
            for(int j = 0; j<i; j++){
                if (array[i] < array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i =0; i<n; i++){
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
