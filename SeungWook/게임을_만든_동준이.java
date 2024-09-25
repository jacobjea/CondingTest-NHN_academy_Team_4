import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임을_만든_동준이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] array = new Integer[n];
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt( br.readLine());
        }
        
        int left = 0;
        int right = array.length -1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        
        int count = 0;
        for(int i = 0; i< array.length-1; i++){
            if (array[i] <= array[i+1]) {
                int gap = array[i+1] - (array[i] - 1);
                count += gap;
                array[i+1] = array[i+1] - gap;
            } 
        }

        System.out.println(count);
    }
}
