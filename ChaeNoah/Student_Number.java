import java.io.*;
import java.util.*;

public class Student_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(bufferedReader.readLine());
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            String input = bufferedReader.readLine();
            strings.add(input);
        }
        int k = strings.get(0).length();
        int result = 1;
        for(int i = 0; i < strings.get(0).length(); i++) {
            Set<String> set= new HashSet<>();
            for(String str : strings) {
                String tmp = str.substring(k-i-1);
                set.add(tmp);
            }
            if(set.size() != strings.size()) {
                result++;
            } else {
                break;
            }
        }
        bufferedWriter.write(Integer.toString(result));
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
