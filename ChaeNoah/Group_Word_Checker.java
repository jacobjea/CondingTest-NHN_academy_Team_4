import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Group_Word_Checker {
    public static boolean[] check;
    public static void main(String[] args) throws IOException {
        check = new boolean[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i=0; i<n; i++) {
            String word = br.readLine();
            int length = word.length();
            char temp = 'a';
            boolean isCheck = true;
            for(int j=0; j<length; j++) {
                if(j == 0) {
                    temp = word.charAt(j);
                    check[word.charAt(j) - 'a'] = true;
                    continue;
                }
                if(temp != word.charAt(j)) {
                    if(check[word.charAt(j) - 'a']) {
                        isCheck = false;
                        break;
                    }
                    check[word.charAt(j) - 'a'] = true;
                    temp = word.charAt(j);
                }
            }
            if(isCheck) {
                count++;
            }
            check = new boolean[26];
        }

        bw.write(Integer.toString(count) + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

