package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 프로그래밍_대회_전용_부지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double limit = 5 * Math.pow(10, 6);

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            while (true) {
                int value = Integer.parseInt(br.readLine());
                if (value == 0) break;
                list.add(value);
            }
            list = bubbleSort(list);
            double result = 0;
            for(int j = 0; j<list.size(); j++){
                result += 2 * Math.pow(list.get(j), j+1);
                if (limit < result) break;
            }
            String message = limit < result ? "Too expensive" : String.format("%.0f", result);
            System.out.println(message);
        }
    }

    public static List<Integer> bubbleSort(List<Integer> list){
        for(int i = 0; i< list.size(); i++){
            for(int j = 1; j< list.size(); j++){
                int i1 = list.get(j-1);
                int i2 = list.get(j);

                if (i1 < i2) {
                    list.set(j-1, i2);
                    list.set(j, i1);
                }
            }   
        }
        return list;
    }
}
