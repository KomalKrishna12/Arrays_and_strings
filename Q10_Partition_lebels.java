import java.util.*;
// given a string, we have to partition that string into some partition in which all individual chars are
// there no char are present in another partiotion
// create a hashmap of char and int
// store highest index of all char
// create two var prev and max 
// intialize prev with -1 and max with 0
// start travering into the string again
// store max idx of char into max
// when max == i then add max - prev into list and assign prev with max value
public class Q10_Partition_lebels {
  public static List<Integer> partitionLabels(String s) { 
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, i);
    }

    List<Integer> res = new ArrayList<>();

    int prev = -1;
    int max = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      max = Math.max(max, map.get(ch));
      if (max == i) {
        res.add(max - prev);
        prev = max;
      }
    }

    return res;
  }

  // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    scn.close();

    List<Integer> res = partitionLabels(str);
    for (int val : res) {
      System.out.print(val + " ");
    }
  }
}
