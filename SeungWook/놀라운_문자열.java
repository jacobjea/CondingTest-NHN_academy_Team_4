import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;

public class 놀라운_문자열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Set<String> set = new HashSet<>();
        while (true) {
            String line = br.readLine();
            String[] strArray = line.split("");
            if (strArray[0].equals("*")) break;

            boolean isSurprising = true;
            outerLoop:
            for(int i = 1; i < strArray.length - 1; i++){
                set.clear();
                for(int j = 0; j < strArray.length - i; j++){
                    // System.out.println(strArray[j] + strArray[j+i]);
                    if (set.contains(strArray[j]+strArray[j+i])) {
                        isSurprising = false;

                        System.out.println(String.format("%s is NOT surprising.", line));
                        break outerLoop;
                    }
                    set.add(strArray[j]+strArray[j+i]);
                }   
            }
            if (isSurprising) {
                System.out.println(String.format("%s is surprising.", line));
            }
        }
    }
}
