package SeungWook;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 병든_나이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로

        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(Math.min(4, (m + 1) / 2));
            return;
        }
        if (m < 7) {
            System.out.println(Math.min(4, m)); 
            return;
        }
        System.out.println(m - 2);
    }
}
