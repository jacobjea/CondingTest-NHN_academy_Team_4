package implementation;

import java.util.*;

public class 피보나치_수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] memo = new int[n+1];
		memo[0] = 0;
		memo[1] = 1;
		
		for(int i=2; i<n+1; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}

//		System.out.println(Arrays.toString(memo));
		System.out.println(memo[n]);
	}

}
