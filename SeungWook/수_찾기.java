package SeungWook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class 수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String[] s = br.readLine().split(" ");
        String m = br.readLine();
        String[] targets = br.readLine().split(" ");

        Arrays.sort(s);

        for (int i = 0; i < targets.length; i++) {
            int index = BinarySearch(s, targets[i]);
            String Message = index == -1 ? "0" : "1";
            System.out.println(Message);
        }
    }

    public static int BinarySearch(String[] array, String target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comprision = array[mid].compareTo(target);
            if (comprision == 0) {
                return mid;
            }
            if (comprision > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
