package search.binary;

/*
1. 식 도출
정답 변수인 z = a + b
a : c = z : sqrt(y^2-z^2)
b : c = z : sqrt(x^2-z^2)
zc / sqrt(y^2-z^2) = a
zc / sqrt(x^2-z^2) = b
z = zc / sqrt(y^2-z^2) + zc / sqrt(x^2-z^2)

2. 아이디어 : 이분탐색
0 < z < min(x, y)

low = 0
high = min(x,y)
while(low <= high)
	z = (low+high)/2
	aPlusB = cal(z)
	if ( abs(z-aPlusB) <= 0.001 ) break
	if ( z < aPlusB) high = z
	else low = z
z 출력

double cal(double z):
	double a = zc / sqrt(y^2-z^2) 
	double b = zc / sqrt(x^2-z^2)
	return a + b

 */
import java.util.*;
public class 사다리 {
	static double x, y, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		x = sc.nextDouble();
		y = sc.nextDouble();
		c = sc.nextDouble();
		
		double low = 0;
		double high = Math.min(x, y);;
		
		double z = 0;
		
		while(low <= high) {
			z = (low+high)/2;
			double aPlusB = cal(z);
			if (Math.abs(z-aPlusB) <= 0.001) break;
			if (z<aPlusB) high = z;
			else low = z;
		}
		
		System.out.println(z);
	}

	private static double cal(double z) {
		double a = z * c / Math.sqrt(y*y-z*z);
		double b = z * c / Math.sqrt(x*x-z*z);
		return a + b;
	}

}
