package gridy;

/*
1. 아이디어 : gridy
A : 오름차순 정렬
B : 내림차순 정렬
result = 0
for n : result += Ai x Bi

2. 시간 복잡도
정렬 : nlogn < 50log2^6 = 50*6

3. 자료구조
배열 A : int[]
배열 B : int[]
정답 : int
 */
import java.io.*;
import java.util.*;

public class 보물 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			a[i] = Integer.valueOf(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			b[i] = Integer.valueOf(st.nextToken()); 
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int result = 0;
		for(int i=0; i<n; i++)
			result += a[i] * b[n-1-i];

		System.out.println(result);
	}

}
