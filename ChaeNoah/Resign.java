import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Resign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] t = new int[n];
        int[] p = new int[n];
        for(int i=0; i<n; i++) {
            String[] temp = br.readLine().split(" ");
            t[i] = Integer.parseInt(temp[0]);
            p[i] = Integer.parseInt(temp[1]);
        }

        for(int i=0; i<n; i++) {
            if(t[i] + i <= n) {
                dp[t[i] + i] = Math.max(dp[t[i] + i], dp[i] + p[i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        bw.write(Integer.toString(dp[n]) + "\n");
        bw.close();
        br.close();
    }
}
