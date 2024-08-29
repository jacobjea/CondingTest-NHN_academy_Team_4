package SeungWook;

//c=, c-, dz=, d-, lj, nj, s=, z=
// 문자열 덩어리들이 있을 때 이것을 구분해야한다.

// 문자열 c를 받으면 그 다음 문자열이 =인지 - 인지 확인, d다음 z 그다음 = 라면 

// c= b c- d
// lj e s= nj a k
// d dz= z=
// nl j j

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 크로아티아_알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] array = s.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (i <= array.length - 3) {
                if (array[i] == 'd' && array[i + 1] == 'z' && array[i + 2] == '=') {
                    i += 2;
                }
            }
            if (i <= array.length - 2) {
                if (i <= array.length - 2 && array[i] == 'c' && array[i + 1] == '=' || array[i + 1] == '-') {
                    i++;
                } else if (i <= array.length - 2 && array[i] == 'c' && array[i + 1] == '=' || array[i + 1] == '-') {
                    i++;
                } else if (i <= array.length - 2 && array[i] == 'l' && array[i + 1] == 'j') {
                    i++;
                } else if (i <= array.length - 2 && array[i] == 'n' && array[i + 1] == 'j') {
                    i++;
                } else if (i <= array.length - 2 && array[i] == 's' && array[i + 1] == '=') {
                    i++;
                } else if (i <= array.length - 2 && array[i] == 'z' && array[i + 1] == '=') {
                    i++;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}