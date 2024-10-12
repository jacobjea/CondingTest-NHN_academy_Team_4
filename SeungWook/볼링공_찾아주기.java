import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class 볼링공_찾아주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String,String > map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());           
            String commend = st.nextToken();
            if (commend.equals("1")) {
                String num = st.nextToken();
                String weight = st.nextToken();
                map.put(weight, num);
            }
            else{
                sb.append(map.get(st.nextToken())+ "\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
