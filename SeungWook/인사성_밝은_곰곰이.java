package SeungWook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class 인사성_밝은_곰곰이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Boolean> map = new HashMap<>();

        int count = 0;
        for(int i = 0; i<n; i++){
            String message = br.readLine();
            if (message.equals("ENTER")) {
                map.clear();
            }
            else{
                if (!map.containsKey(message)) {
                    map.put(message,false);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
