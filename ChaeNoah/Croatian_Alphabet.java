import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Croatian_Alphabet {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        String s = br.readLine();
        int length = s.length();

        int count = 0;
    
        for(int i=0; i<length; i++) {
            char c = s.charAt(i);
            switch(c) {
            case 'c':
                if(i <= length - 2) {
                    if(s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
                        i++;
                    }
                }
                break;
            case 'd':
                if(i <= length - 2) {
                    if(s.charAt(i + 1) == '-') {
                        i++;
                    }
                    else {
                        if(s.charAt(i + 1) == 'z') {
                            if(i + 1 <= length - 2 && s.charAt(i + 2) == '=') {
                                i += 2;
                            }
                        }
                    }
                }
                break;
            case 'l':
                if(i <= length - 2 && s.charAt(i + 1) == 'j') {
                    i++;
                }
                break;
            case 'n':
                if(i <= length - 2 && s.charAt(i + 1) == 'j') {
                    i++;
                }
                break;
            case 's':
                if(i <= length - 2 && s.charAt(i + 1) == '=') {
                    i++;
                }
                break;
            case 'z':
                if(i <= length - 2 && s.charAt(i + 1) == '=') {
                    i++;
                }
                break;
            }
            count++;
        }
        bw.write(Integer.toString(count) + "\n");
        bw.close();
        br.close();
    }
}
