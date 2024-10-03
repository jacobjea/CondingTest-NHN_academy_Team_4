package SeungWook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
public class 빈도_정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt( s[0]);
        int m = Integer.parseInt( s[1]);

        String[] strArray = br.readLine().split(" ");
        Integer[] intArray = new Integer[n];
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(strArray[i]);
            intArray[i] = num;

            if (!indexMap.containsKey(num)) {
                indexMap.put(num, i);
            }

            frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
        }

        Arrays.sort(intArray,(i1,i2)->{
            int frequencyValue = frequencyMap.get(i2).compareTo(frequencyMap.get(i1));
            if (frequencyValue != 0) return frequencyValue;
            return indexMap.get(i1).compareTo(indexMap.get(i2));
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<intArray.length; i++){
            sb.append(intArray[i]);
            if (i != intArray.length-1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
