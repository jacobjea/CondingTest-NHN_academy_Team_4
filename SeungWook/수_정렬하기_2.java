package SeungWook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class 수_정렬하기_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] array = new int[count];
        for(int i = 0; i < count; i++){
            int n = Integer.parseInt(br.readLine());
            array[i] = n;
        }
        Arrays.sort(array);

        for(int i : array){
            System.out.println(i);
        }
        br.close();
    }
}