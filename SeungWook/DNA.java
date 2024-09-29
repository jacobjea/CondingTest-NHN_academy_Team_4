import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.lang.StringBuilder;
public class DNA {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] array = new String[n];
        for(int i = 0; i< n; i++){
            array[i] = br.readLine();
        }

        // 문자열의 첫번째 글자중 제일 많이 나온 알파벳을 담는다
        // 그 알파벳과 다른 나머지 알파벳의 숫자를 카운팅해야한다.

        int[][] frequency = new int[m][4];
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                char c = array[i].charAt(j);
                if      (c == 'A') frequency[j][0]++;
                else if (c == 'C') frequency[j][1]++;
                else if (c == 'G') frequency[j][2]++;
                else if (c == 'T') frequency[j][3]++;
            }
        }

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for(int i = 0; i< m; i++){
            int max = 0;
            String dna = "";
            if (frequency[i][0] > max){
                max = frequency[i][0];
                dna = "A";
            } 
            if (frequency[i][1] > max){
                max = frequency[i][1];
                dna = "C";
            }
            if (frequency[i][2] > max){
                max = frequency[i][2];
                dna = "G";
            }
            if (frequency[i][3] > max){
                max = frequency[i][3];
                dna = "T";
            }
            count += n-max;
            sb.append(dna);
        }
        System.out.println(sb.toString());
        System.out.println(count);
    }
}
