import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] array = new int[n];
        int[] sum = new int[n];
        
        sum[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < n; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int num = 0 ;
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            if (startIndex == 1) {
                num = sum[endIndex-1];
            }
            else{
                num = sum[endIndex-1] - sum[startIndex-2];
            }
            
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
