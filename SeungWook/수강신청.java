package SeungWook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class 수강신청 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String,Boolean> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(br.readLine());
        }

        for(int i = 0; i < list.size(); i++){
            String studentNo = list.get(i);

            if (!map.containsKey(studentNo)) {
                map.put(studentNo, false);
            }
            else{
                studentNo
            }
        }
    }
}
