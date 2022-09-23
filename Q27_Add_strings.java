import java.util.Scanner;
// given two no in form of strings we need to add them and show them in string format
// we can use two pointers i and j
// i points to end of num1 and j points to end of num2
// craete a var carry and initialize it as 0
// run a while loop till any of three condition is true
// in val use sum % 10 and next carry will be sum / 10 
public class Q27_Add_strings {
    
  public static String addStrings(String num1, String num2) {
    String res = "";
    int i = num1.length() - 1;
    int j = num2.length() - 1;

    int carry = 0;
    while (i >= 0 || j >= 0 || carry != 0) {
        
      int val1 = 0;
      if (i >= 0) val1 = num1.charAt(i) - '0';
      
      int val2 = 0;
      if (j >= 0) val2 = num2.charAt(j) - '0';
      
      int sum = val1 + val2 + carry;
      int val = sum % 10;
      carry = sum / 10;
      res = val + res;
      i--;
      j--;
    }

    return res;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String n1 = scn.nextLine();
    String n2 = scn.nextLine();
    scn.close();

    String res = addStrings(n1, n2);
    System.out.println(res);
  }
}
