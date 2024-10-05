import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int mask = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comand = st.nextToken();
            if (comand.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                mask |= 1 << (num -1);
            }
            else if (comand.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                // String message = (mask & 1 << (num -1)) != 0 ? "1\n" : "0\n";
                // System.out.println(Integer.toBinaryString(mask));
                // System.out.println(message);
                sb.append((mask & 1 << (num -1)) != 0 ? "1\n" : "0\n");
            }
            else if (comand.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                mask &= ~(1 << (num -1));
            }
            else if (comand.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                mask ^= (1 << (num -1));
            }
            else if (comand.equals("all")) {
                mask = (1 << 20) - 1;
            }
            else if (comand.equals("empty")) {
                mask = 0;
            }
        }
        System.out.println(sb.toString().trim());
    }
}
