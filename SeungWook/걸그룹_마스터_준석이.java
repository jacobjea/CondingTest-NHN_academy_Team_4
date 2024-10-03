import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.IOException;

public class 걸그룹_마스터_준석이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        
        HashMap<String, String[]> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            String groupName = br.readLine();
            int peopleCount = Integer.parseInt(br.readLine());

            String[] memberName = new String[peopleCount];
            for(int j = 0; j < peopleCount; j++){
                memberName[j] = br.readLine();
            }
            Arrays.sort(memberName);
            map.put(groupName, memberName);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++){
            String keyword = br.readLine();
            String quiz = br.readLine();
            if (quiz.equals("0")) {
                if (map.containsKey(keyword)) {
                    for(String name : map.get(keyword)){
                        sb.append(name).append("\n");
                    }
                }
            }
            else{
                outerLoop:
                for(var entry : map.entrySet()){
                    for(String name : entry.getValue()){
                        if (name.equals(keyword)) {
                            sb.append(entry.getKey()).append("\n");
                            break outerLoop;
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
