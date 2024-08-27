package SeungWook;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class 그룹_단어_체커 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine()); 

        int count = 0;
        for(int i = 0 ; i < max; i++){
            String s = br.readLine();
            
            List<Character> list = new ArrayList<Character>();
            char c = ' ';
            boolean isGroup = true;
            for(int j = 0; j < s.length(); j++){
                char temp = s.charAt(j);
                if (!list.contains(temp)) { 
                    list.add(temp);
                }
                else{
                    if (temp != c) {
                        isGroup = false;
                        break;
                    }
                }
                c = temp;
            }
            count = isGroup ? count + 1 : count;
        }
        System.out.println(count);
        br.close();
    }
}
