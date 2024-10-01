import java.io.*;
import java.util.*;

public class 1의_개수_세기{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static long[] dp = new long[60];
    static void set(){
        dp[0] = 1;
        
        for(int i = 1; i < 60; i++){
            dp[i] = (dp[i-1] << 1) + (1l << i);
        }
    }

    static long get(long x){
        long cnt = x & 1;
        
        int size = (int) (Math.log(x) / Math.log(2));
        for(int i = size; i > 0; i--){
            if((x & (1l << i)) != 0l){
                cnt += dp[i-1] + (x - (1l << i) + 1);
                x -= (1l << i);
            }
        }

        return cnt;
    }
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        set();
        System.out.println(get(M) - get(N-1));
    }
}
