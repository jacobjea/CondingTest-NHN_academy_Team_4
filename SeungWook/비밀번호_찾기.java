import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class 비밀번호_찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for(int i = 0; i < n; i++){
            String[] value = br.readLine().split(" ");
            map.put(value[0], value[1]);
        }
        for(int i = 0; i < m; i++){
            System.out.println(map.get(br.readLine()));
        }
    }
}
