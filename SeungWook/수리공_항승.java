package SeungWook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 수리공_항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] array = new int[n];
        for(int i =0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        
        int lenght = array[0] + m-1;
        int count = 1;
        for(int i =0; i<array.length; i++){
            if(lenght < array[i]){
                lenght = array[i] + m-1;
                count++;
            }
        }
        System.out.println(count);
    }
}
