import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.Comparator;


public class 회사에_있는_사람 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            
            if (map.containsKey(s[0]) && s[1].equals("leave") ) {
                map.remove(s[0]);
            }
            else{
                if (s[1].equals("enter")) {
                    map.put(s[0], true);
                }
            }
        }

        String[] array = new String[map.size()];
        Set<String> set = map.keySet();
        array = set.toArray(new String[0]);
        
        Arrays.sort(array, (s1,s2)-> s2.compareTo(s1));

        for(String s : array){
            System.out.println(s.split(" ")[0]);
        }
    }
}
