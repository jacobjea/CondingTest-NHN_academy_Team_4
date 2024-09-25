import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 피보나치_함수 {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] result = new int[41][2];
        result[0][0] = 1;
        result[0][1] = 0;
        result[1][0] = 0;
        result[1][1] = 1;
        for(int i = 2; i < result.length; i++){
            result[i][0] = result[i-2][0] + result[i-1][0];
            result[i][1] = result[i-2][1] + result[i-1][1];
        }

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            System.out.println(String.format("%s %s", result[m][0] ,result[m][1]));
        }
    }
}
