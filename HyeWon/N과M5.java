package backtracking;

import java.util.*;

public class N과M5 {
	static int N, M;
	static int[] nums;
	static boolean[] visited;
	static LinkedList<LinkedList<Integer>> result = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int [N];
		
		for(int i=0; i<N; i++)
			nums[i] = sc.nextInt();
		
		Arrays.sort(nums);
		
		visited = new boolean [N];
		
		dfs(0, new LinkedList<>());
		
		StringBuilder sb = new StringBuilder();
		for(LinkedList<Integer> list : result) {
			for(int num : list)
				sb.append(num).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int cnt, LinkedList<Integer> seq) {
		if (cnt == M) {
			result.add(seq);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(cnt+1, addNum(seq, nums[i]));
				visited[i] = false;
			}
		}
	}
	
	static LinkedList<Integer> addNum(LinkedList<Integer> list, int num) {
		LinkedList<Integer> newList = new LinkedList<>(list);
		newList.add(num);
		return newList;
	}
}
