import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상근이의_여행 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int num = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int countryCount = Integer.parseInt(st.nextToken());
            int airplain = Integer.parseInt(st.nextToken());
            System.out.println(countryCount-1);

            for(int j = 0; j< airplain; j++){
                br.readLine();
            }
        }
    }
}
