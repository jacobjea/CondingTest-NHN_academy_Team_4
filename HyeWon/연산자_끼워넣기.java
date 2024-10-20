package backtracking;

/*
1. 아이디어 : 백트랙킹

nums : int[n]
min, max 
dfs(1, nums[0], add, sub, mul, div)

dfs(int targetIdx, int accum, add, sub, mul, div)
	// OPTION : 경계처리
	 
	// 종료조건
	if targetIdx == n
		min, max 갱신
		return
	
	if(add>0)
		dfs(targetIdx+1, accum+num[targetIdx], add-1, 그대로)
	// .. 

2. 시간복잡도
갈래 4, DFS 깊이 N-1
4^10 = 2^20 = (2^10)^2 > (10^3)^2 = 10^6 -> 가능
*/

import java.util.*;
public class 연산자_끼워넣기 {
	static int n, nums[], add, sub, mul, div;
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		
		add = sc.nextInt();
		sub = sc.nextInt();
		mul = sc.nextInt();
		div = sc.nextInt();
		
		dfs(nums[0], 1, add, sub, mul, div);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int accum, int targetIdx, int add, int sub, int mul, int div) {
		if(targetIdx == n) {
			min = Math.min(accum, min);
			max = Math.max(accum, max);
			return;
		}
		
		if(add>0) dfs(accum+nums[targetIdx], targetIdx+1, add-1, sub, mul, div);
		if(sub>0) dfs(accum-nums[targetIdx], targetIdx+1, add, sub-1, mul, div);
		if(mul>0) dfs(accum*nums[targetIdx], targetIdx+1, add, sub, mul-1, div);
		if(div>0) dfs(accum/nums[targetIdx], targetIdx+1, add, sub, mul, div-1);
	}

}
