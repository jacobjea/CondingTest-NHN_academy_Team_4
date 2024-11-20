package gridy;

/*

0: 0~2, 5-6
1: 3-4

 */
import java.io.*;
import java.util.*;

public class 뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		List<int[]> zero = new LinkedList<>();
		List<int[]> one = new LinkedList<>();
		
		int start = 0;
		int end = 0;
		char pre = input.charAt(0);
		
		for(int i=1; i<input.length(); i++) {
			if(input.charAt(i)!=pre) {
				end=i-1;
				if(pre=='0') zero.add(new int[] {start, end});
				else one.add(new int[] {start, end});
					
				pre = input.charAt(i);
				start=i;
			}
		}
		
//		System.out.println(one);
		
		if(input.charAt(input.length()-1)=='0') zero.add(new int[] {start, input.length()-1});
		else one.add(new int[] {start, input.length()-1});
		
		if(zero.size() < one.size()) {
			System.out.println(zero.size());
		} else {
			System.out.println(one.size());
		}
	}

}
