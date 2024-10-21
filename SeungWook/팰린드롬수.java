package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("0")) {
                break;
            }
            String[] s = line.split("");

            int left = 0;
            int right = line.length()-1;

            int index = 0;
            while (true) {
                if (s[index].equals("0")) {
                    index++;
                }
                else{
                    left = index;
                    break;
                }
            }

            boolean isPelindrom = true;
            while (left < right) {
                if (s[left].equals(s[right])) {
                    left++;
                    right--;
                } else {
                    isPelindrom = false;
                    break;
                }
            }
            System.out.println(isPelindrom ? "yes" : "no");
        }
    }
}
