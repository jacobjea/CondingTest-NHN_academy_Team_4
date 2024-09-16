package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오리와_박수치는_춘배 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] array = new int[n];
        String[] temp =  br.readLine().split(" ");
        
        for(int i =0; i<n; i++){
            array[i] = Integer.parseInt(temp[i]);
        }
        int count = 1;
        int currentMax = array[0] + k;
        for(int i =1; i<n; i++){
            if (currentMax < array[i]) {
                count++;
                currentMax = array[i] + k;
            }
        }
        System.out.println(count);
    }
}
