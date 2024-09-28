import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int gap = s[1].length() - s[0].length();

        int min = 50;
        if (gap == 0) {
            System.out.println(calculate(s[0],s[1]));
            return;
        }

        for(int i = 0; i <= gap; i++){
            String subString = s[1].substring(i, i + s[0].length());
            min = Math.min(min, calculate(s[0],subString));
        }
        System.out.println(min);
    }

    public static int calculate(String s1, String s2){
        int count = 0;
        for(int j = 0; j < s2.length(); j++){
            if (s1.charAt(j) != s2.charAt(j)) {
                count++;
            }
        }
        return count;
    }
}
