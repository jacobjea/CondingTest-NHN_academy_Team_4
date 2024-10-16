package SeungWook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;
public class 이플러스일_세일 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Integer[] array = new Integer[n];
        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(array,Collections.reverseOrder());

        int sum = 0;
        int count =0;
        for(int i = 0; i<n; i++){
            count++;
            if (count == 3) {
                count = 0;
                continue;
            }
            sum += array[i];
        }
        System.out.println(sum);
    }
}
