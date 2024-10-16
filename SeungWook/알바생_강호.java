package SeungWook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

public class 알바생_강호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Integer[] array = new Integer[n];
        for(int i =0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array,Collections.reverseOrder());

        long sum = 0l;
        for(int i =0; i<n; i++){
            long tip = (long)array[i]-i;
            if (tip < 0) {
                break;
            }
            else{
                sum += tip;
            }
            
        }
        System.out.println(sum);
    }
}
