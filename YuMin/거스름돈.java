import java.util.Scanner;

public class 거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        while (true) {
            if (n % 5 == 0 && n != 0) {
                count++;
                n -= 5;
            }
            else if (n / 2 >= 1) {
                count++;
                n -= 2;
            }
            else if (n != 0) {
                System.out.println(-1);
                break;
            }
            else {
                System.out.println(count);
                break;
            }
        }
    }   
}
