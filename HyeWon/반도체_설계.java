package search.binary;

/*
1. 아이디어 : LIS + binary search
a. idx = 0, memo[idx] = input[0]
b. for 1 ~ input길이-1 : 
	if memo[idx] > input[i] : memo[++idx] = input[i]
	else if memo[idx] < input[i] : 
		pos = binarySearch(memo, 0, idx까지, input[i])
		// memo : 2, 4, 6 / input[i] : 1 -> bs = -1
		if pos < 0 : memo[-pos - 1] = input[i]
c. memo 길이 출력

2. 복잡도
n * lgn = 40000 * lg2^16 = 40000 * 16 < 가능

3. 자료구조
input : int[]
memo : int[]

 */
import java.util.*;
public class 반도체_설계 {

	public static void main(String[] args) {
		
		/*
//		int[] memo = {2,4,6};
		int[] memo = {2};
		System.out.println(Arrays.binarySearch(memo, 0, memo.length, 1)); // -1 
		System.out.println(Arrays.binarySearch(memo, 0, memo.length, 3)); // -2 
		System.out.println(Arrays.binarySearch(memo, 0, memo.length, 5)); // -3
		// -> -rst - 1 
		*/
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] input = new int[n];
		
		for(int i=0; i<n; i++) input[i] = sc.nextInt();
		
		int[] memo = new int[n];
		
		int idx = 0;
		memo[idx] = input[0];
//		System.out.println(Arrays.toString(memo));
		for (int i=1; i < input.length; i++) {
//			System.out.printf("memo[%d]: %d, input[%d]: %d\n", idx, memo[idx], i, input[i]);
			if (memo[idx] < input[i]) memo[++idx] = input[i];
			else if (memo[idx] > input[i]) {
				int pos = Arrays.binarySearch(memo, 0, idx+1, input[i]);
//				System.out.printf("input[%d]: %d, pos: %d\n", i, input[i], pos);
				if (pos < 0) memo[-pos - 1] = input[i];
			}
//			System.out.println(Arrays.toString(memo));
//			System.out.println(idx);
		}
		
		System.out.println(idx+1);
		
 	}

}
