package search.binary;

/*
1. 아이디어 : LIS + binary search
idx = 0
memo[idx] = input[0]
for n:
	if memo[idx] < input[i]
		memo[++idx] = input[i]
	else if memo[0] > input[i]
		memo[0] = input[i]
	else 
		target = binarySearch(memo, input[i], 0, idx+1)
		if target < 0 // < -1
			memo[-target-1] = input[i]
print input 길이 - (idx+1) 
		
2. 시간 복잡도
nlogn < nlog2^17 = 17n < 1억
 */
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 꼬인_전깃줄 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] input = new int [n];
		
		for(int i=0; i<n; i++)
			input[i] = Integer.valueOf(st.nextToken());
		
//		System.out.println(Arrays.toString(input));
		
		int[] memo = new int[n];
		
		int idx = 0;
		memo[idx] = input[0];
		
		for(int i=1; i<n; i++) {
			if (memo[idx] < input[i]) memo[++idx] = input[i];
			else {
				int target = Arrays.binarySearch(memo, 0, idx+1, input[i]);
				if (target < 0) // 생략 가능
					memo[-target-1] = input[i];
			}
		}
		
		System.out.println(n-(idx+1));
		
	}

}
