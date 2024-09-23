import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class ATM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] intArray = new int[n];
        for(int i = 0; i < n; i++){
            intArray[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(intArray);

        int sum = 0;
        for(int i = 0; i < intArray.length; i++){
            for(int j = 0; j <= i; j++){
                sum += intArray[j];
            }
        }
        System.out.println(sum);
    }
}
