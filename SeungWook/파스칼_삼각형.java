import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class 파스칼_삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // r 번째줄의
        int c = Integer.parseInt(st.nextToken()); // c번재 줄이 꼭지점
        int w = Integer.parseInt(st.nextToken()); // 개수가 w인
        
        int[][] dp = new int[30+1][30+1];

        dp[0][0] = 0;
        dp[1][1] = 1;

        dp[2][1] = 1;
        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for(int i = 4; i<dp.length; i++){
            for(int j = 1; j<dp.length; j++){
                if (j == 1 || j == i) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int sum = 0;
        
        for(int i = 0; i<w; i++){
            for(int j = 0; j<i+1; j++){
                sum += dp[r+i][c+j];
            }
        }
        System.out.println(sum);
    }
}
