import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 점화식 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] map = new long[35+1];

        map[0] = 1;
        map[1] = 1;
        map[2] = 2;

        for(int i = 3 ; i < map.length; i++){
            long sum = 0;   
            for(int j = 0; j < i; j++){
                sum += map[j] * map[i-j-1];

            }
            map[i] = sum;
        }
        System.out.println(map[n]);
    }
}
