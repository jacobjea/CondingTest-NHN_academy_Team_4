import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방_번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] count = new int[10];
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num == 9) {
                count[6] += 1;
            }
            else {
                count[num] += 1;
            }
        }
        
        if (count[6] % 2 == 1) {
            count[6] = count[6] / 2 + 1;
        }
        else {
            count[6] /= 2;
        }

        for (int i = 0 ; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        
        System.out.println(max);
    }
}
