import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.io.BufferedReader;

public class 숫자놀이 {
    public static HashMap<String,String> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        map.put("0","zero");
        map.put("1","one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");
        map.put("5", "five");
        map.put("6", "six");
        map.put("7", "seven");
        map.put("8", "eight");
        map.put("9", "nine");
        
        int length = b-a+1;
        numInfo[] array = new numInfo[length];
        for(int i = 0; i < array.length; i++){
            array[i] = new numInfo(i+a);
        }

        Arrays.sort(array, new Comparator<numInfo>() {
            @Override
            public int compare(numInfo n1, numInfo n2) {
                return n1.numToEn.compareTo(n2.numToEn);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< array.length; i++){
            sb.append(array[i].num);

            if ((i+1) % 10 == 0) {
                sb.append("\n");
            }else if (i < array.length -1) {
                sb.append(" ");
            }
            
        }
        System.out.println(sb.toString());
    }

    public static class numInfo{
        int num;
        String numToEn;

        public numInfo(int num){
            this.num = num;
            numToEn = transfer(num);
        }

        public String transfer(int num){
            String[] array = String.valueOf(num).split("");
            String en = "";
            for(int i = 0; i< array.length; i++){
                en += map.get(array[i]) + " ";
            }
            return en.trim();
        }

        @Override
        public String toString(){
            return String.valueOf(num);
        }
    }
}
