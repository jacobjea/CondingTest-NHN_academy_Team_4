import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class 동전0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] coins = new int[n];
        for(int i = 0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i = coins.length-1; i >=0; i--){
            if (m == 0) {
                break;
            }
            if (coins[i] <= m) {
                while (m - coins[i]>= 0) {
                    m -= coins[i];
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
