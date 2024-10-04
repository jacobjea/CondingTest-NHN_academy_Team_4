import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class 이의_보수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int bitA = n;
        int bitB = ~bitA + 1;
        int num = bitA ^ bitB;

        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }

            num >>>= 1;
        }
        System.out.println(count);
    }
}
