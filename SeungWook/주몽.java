import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[n];
        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int count = 0;
        int left = 0;
        int right = n-1;
        while (left < right) {
            int value = array[left] + array[right];
            if (value == m) {
                left++;
                right--;
                count++;
            }
            else if (value > m) {
                right--;
            }
            else{
                left++;
            }
        }
        System.out.println(count);
    }
}
