import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Movie_Director {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = Integer.parseInt(br.readLine());
        int count = 0;
        int result = 666;

        while(true) {
            if(Integer.toString(result).contains("666")) {
                count++;
                if(count == i) {
                    break;
                }
            }
            result++;
        }

        bw.write(Integer.toString(result) + "\n");
        bw.close();
        br.close();
    }
}
