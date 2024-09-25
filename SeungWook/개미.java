import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class 개미 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        String[] array1 = br.readLine().split("");
        String[] array2 = br.readLine().split("");
        int t = Integer.parseInt(br.readLine());


        int left = 0;
        int right = array1.length -1;
        while (left < right) {
            String temp = array1[left];
            array1[left] = array1[right];
            array1[right] = temp;

            left++;
            right--;
        }

        Ant[] ants = new Ant[a+b];
        for(int i = 0; i < array1.length; i++){
            ants[i] = new Ant(array1[i], "a");
        }

        for(int i = 0; i < array2.length; i++){
            ants[i+a] = new Ant(array2[i], "b");
        }

        Ant[] newAnts = ants.clone();
        for(int i = 0; i < t; i++){
            for(int j = 0; j < ants.length-1; j++){
                if (ants[j].getGroup() != ants[j+1].getGroup()) {
                    Ant temp = newAnts[j];
                    newAnts[j] = newAnts[j+1];
                    newAnts[j+1] = temp;
                    j++;
                }
            }
            ants = newAnts.clone();
        }
        System.out.println(Arrays.toString(newAnts));

    }
    static class Ant{
        String name;
        Ant next;
        String group;

        public Ant(String name, String group){
            this.name = name;
            this.group = group;
        }

        public String getname(){
            return name;
        }

        public String getGroup(){
            return group;
        }

        @Override
        public String toString(){
            return name;
        }
    }
}
