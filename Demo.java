import java.util.*;
public class Demo{
    static int count = (int)1e9;
    public static int partitionString(String s) {
       //ArrayList<String> list = new ArrayList<>();
        f(s, 0);
        return count;
    }
    
    public static void f(String s, int list){
        if(s.length() == 0){
            if(list < count){
                count = list;
            }
            return;
        }
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(0, i+1);
            String ros = s.substring(i+1);
            if(valid(str)){
                f(ros, list + 1);
            }else{
                break;
            }
        }
    }
    
    public static boolean valid(String s){
        if(s.length() == 1) return true;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "lvkmzlaeaxbprczpfarnlaptfvmutkfsatyywnxpmkpduwoqeeiltbdjipwihqi";
        System.out.println(partitionString(s));
    }
}