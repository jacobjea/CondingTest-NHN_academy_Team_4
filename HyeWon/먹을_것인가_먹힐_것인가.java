package search.binary;
/*
1. 아이디어 : 이분 탐색
(이분 탐색을 하기 위해) A, B 각각 오름차순 정렬
(A가 B를 먹을 수 있는 쌍의 개수를 누적할) cnt를 0으로 초기화
for A : 
	A_i를 B에서 찾기(이분 탐색)
	if 반환값이 양수 : // ex) B={1,3,6}에서 A의 첫 번째 요소(A_0)인 1을 찾을 때 B의 0번째 인덱스에 있기 때문에 반환값은 0 
		반환값 만큼 cnt에 누적 // 이유 : 
	else : // 반환값이 음수. ex) B에서 A의 4번째 요소(A_3)인 7을 이분 탐색하면 -1 반환
		"|반환값| -1" 만큼 cnt에 누적 

2. 시간 복잡도
T * N * MlogM = N * Mlog20000 < NM * log2^15 = O(15NM) = O(NM) = 20000^2 < 1억 
 */

import java.util.*;
public class 먹을_것인가_먹힐_것인가 {
	
	static int BinarySearch(int A, int[] B, int x, int y) {
		 
        int start = 0;
        int end = y;
        int count = 0;
        while (start <= end) {
           int mid = (start + end) / 2;
            if (A > B[mid]) {
                start = mid+1;
                count = mid +1;
            } else {
                end = mid-1;

            }
        }


    return count;
}

	public static void main(String[] args) {
//		int[] arr1 = {1, 1, 3, 7, 8};
//		int[] arr2 = {1, 3, 6};
		
//		System.out.println(Arrays.binarySearch(arr2, arr1[0])); // 0
//		System.out.println(Arrays.binarySearch(arr2, arr1[2])); // 1
//
//		System.out.println(Arrays.binarySearch(arr2, 0)); // -1
//		System.out.println(Arrays.binarySearch(arr2, 4)); // -3
//		System.out.println(Arrays.binarySearch(arr2, arr1[3])); // -4
//		System.out.println(Arrays.binarySearch(arr2, arr1[4])); // -4
//		System.out.println();
		
//		System.out.println(Arrays.binarySearch(arr2, arr1[0])); // 0
//		System.out.println(Arrays.binarySearch(arr2, arr1[2])); // 1
//
//		System.out.println(Math.abs(Arrays.binarySearch(arr2, 0))-1); // -1
//		System.out.println(Math.abs(Arrays.binarySearch(arr2, 4))-1); // -3
//		System.out.println(Math.abs(Arrays.binarySearch(arr2, arr1[3]))-1); // -4
//		System.out.println(Math.abs(Arrays.binarySearch(arr2, arr1[4]))-1); // -4
//		System.out.println();
//		System.out.println(BinarySearch(1, arr2, 0, 2));
//		System.out.println(BinarySearch(3, arr2, 0, 2));
//
//		System.out.println(BinarySearch(0, arr2, 0, 2));
//		System.out.println(BinarySearch(4, arr2, 0, 2));
//		System.out.println(BinarySearch(7, arr2, 0, 2));
//		System.out.println(BinarySearch(8, arr2, 0, 2));
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
	
		for(int t=0; t<T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] a = new int[n];
			int[] b = new int[m];
			
			for(int i=0; i<n ;i++) {
				a[i] = sc.nextInt();
			}
			
			for(int i=0; i<m ;i++) {
				b[i] = sc.nextInt();
			}
			
//			Arrays.sort(a);
			Arrays.sort(b);
			
			int cnt = 0;
			
			for (int i=0; i<n; i++) {
				int idx = Arrays.binarySearch(b, a[i]);
				if (idx >= 0) cnt += idx;
				else 
					//cnt += Math.abs(idx) -1;
					cnt += -(idx + 1);
			}
			
			System.out.println(cnt);
		}

	}

}