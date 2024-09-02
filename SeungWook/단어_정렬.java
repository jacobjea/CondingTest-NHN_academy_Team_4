package SeungWook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class 단어_정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        // map사용하여 중복제거
        Set<String> wordMap = new HashSet<>();
        for(int i = 0; i < count; i++){
            String word = br.readLine();
            wordMap.add(word);
        }

        List<String> wordList = new ArrayList<>(wordMap);

        Collections.sort(wordList, new Comparator<String>(){
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                }
                return s1.compareTo(s2);
            }
        });

        for(String w : wordList){
            System.out.println(w);
        }
    }
}
