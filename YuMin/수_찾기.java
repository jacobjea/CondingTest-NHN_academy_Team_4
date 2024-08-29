import java.util.*;
import java.io.*;

public class 수_찾기 {
    // 이분 탐색
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return 1;

            if (arr[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String[] strArr1 = str1.split(" ");
        int[] intArr1 = new int[N];
        for (int i = 0; i < N; i++) {
            intArr1[i] = Integer.parseInt(strArr1[i]);
        }
        Arrays.sort(intArr1);

        int M = Integer.parseInt(br.readLine());
        String str2 = br.readLine();
        String[] strArr2 = str2.split(" ");
        int[] intArr2 = new int[M];
        for (int i = 0; i < M; i++) {
            intArr2[i] = Integer.parseInt(strArr2[i]);
        }

        boolean result = false;
        
        for (int i = 0 ; i < M; i++) {
            System.out.println(binarySearch(intArr1, intArr2[i]));
        }
    }
}
