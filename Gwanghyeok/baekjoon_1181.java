import java.util.*;

@FunctionalInterface
interface Comparator<T>{
  int compare(T o1, T o2);
  
}

public class baekjoon_1181 implements Comparator<String>{

  static String[] array;

  @Override
  public int compare(String a, String b){
    
    if(a.length()<b.length())
      return -1;
    else if(a.length() == b.length())
      return a.compareTo(b);
    else return 1;
  }

  
  public static void main(String[] args) {


    Scanner sr = new Scanner(System.in);
    baekjoon_1181 b = new baekjoon_1181();
    int index=0;
    int n = sr.nextInt();
    sr.nextLine();
    array = new String[n];

    
    for(int i=0;i<n;i++){
      array[i]=sr.nextLine();
    }
    
    // 중복을 처리하기 위해 Set을 이용
    Set<String> hash = new HashSet<>();

    for(String i:array){
      hash.add(i);
    }

    // 중복을 처리한 후 크기로 배열을 재생성하고 배열에 값을 넣어줌
    array = new String[hash.size()];
    for(String i:hash){
      array[index] = i;
      index++;
      
    }

    //compare 함수와 버블정렬을 이용해서 길이와 사전순으로 정렬
    for(int i=0;i<array.length;i++){

      for(int j=0;j<array.length-i-1;j++){

        if(b.compare(array[j],array[j+1]) > 0){
          String temp = array[j+1];
          array[j+1] = array[j];
          array[j] = temp;
        }
      }
    }

    for(int i=0;i<array.length;i++){
      System.out.println(array[i]);
    }
  }
}