package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");

        Arrays.sort(s1);
        for (int i = 0; i < s2.length; i++) {
            int index = BinarySearch(s1, s2[i]);
            String message = index == -1 ? "0" : "1";
            System.out.println(message);
        }
    }

    public static <T extends Comparable<T>> int BinarySearch(T[] array, T target) {
        int low = 0;
        int high = array.length - 1;
        
        int count = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparetion = array[mid].compareTo(target);
            if (comparetion == 0) {
                return mid;
            } else if (comparetion > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
