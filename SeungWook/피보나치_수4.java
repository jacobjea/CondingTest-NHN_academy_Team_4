import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 피보나치_수4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger[] map = new BigInteger[10000+1];

        map[0] = new BigInteger("0");
        map[1] = new BigInteger("1");
        map[2] = new BigInteger("1");
        map[3] = new BigInteger("2");

        for(int i = 4 ; i < map.length; i++){
            map[i] = map[i-1].add(map[i-2]);
        }
        System.out.println(map[n]);
    }
}
