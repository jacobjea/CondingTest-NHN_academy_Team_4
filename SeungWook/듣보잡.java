package SeungWook;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
public class 듣보잡 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Map<String,Boolean> map = new HashMap<>();
        for(int i = 0 ; i < n+m; i++){
            String name = br.readLine();
            if (map.containsKey(name)) {
                map.put(name, true);
            }
            else{
                map.put(name, false);
            }
        }
        int count = 0;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String str : map.keySet()){
            if (map.get(str)) {
                count++;
                list.add(str);
            }
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        });

        System.out.println(count);
        list.forEach(System.out::println);
    }
}
