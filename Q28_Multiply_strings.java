import java.util.Scanner;

public class Q28_Multiply_strings {
  public static String multiplication(String num1, String num2) {
    // write your code here
    if(num1.equals("0") || num2.equals("0")) return "0";
    int l1 = num1.length();
    int l2 = num2.length();
    int[] res = new int[l1 + l2];
    int pf = 0; // power factor

    int i = l2 - 1;
    while (i >= 0) {
      int ival = num2.charAt(i) - '0';
      i--;

      int j = l1 - 1;
      int k = res.length - 1 - pf;
      int carry = 0;

      while (j >= 0 || carry != 0) {
        int jval = j >= 0 ? num1.charAt(j) - '0' : 0;
        j--;

        int prod = ival * jval + carry + res[k];

        res[k] = prod % 10;
        carry = prod / 10;
        k--;
      }

      pf++;

    }

    String ans = "";
    boolean flag = false;

    for (int ii = 0; ii < res.length; ii++) {
      if (res[ii] == 0 && flag == false) {
        // leading zeroes
        continue;
      } else {
        flag = true;
        ans += res[ii];
      }
    }

    return ans;
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    String str1 = scn.nextLine();
    String str2 = scn.nextLine();

    scn.close();

    String res = multiplication(str1, str2);
    System.out.println(res);
  }
}
