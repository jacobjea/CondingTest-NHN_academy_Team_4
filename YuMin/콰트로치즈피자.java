import java.io.*;
import java.util.*;

public class 콰트로치즈피자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] topping = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            if (topping[i].endsWith("Cheese")) {
                map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
            }
        }

        if (map.size() >= 4) {
            System.out.println("yummy");
        }
        else {
            System.out.println("sad");
        }
    }
}
