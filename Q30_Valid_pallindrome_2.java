import java.util.*;
// we have given a string we have to check that the string is pallindrome or not if not then if we remove one char
// then it is becoming pallindrome or not
// using two pointer we can check this
// if ith and jth char are same then i++ adn j--
// else skip ith character and check that the rest string from i+1 to j is pallindrome or not
// else skip jth char and check that the rest string from i to j-1 is apllindrome or not
public class Q30_Valid_pallindrome_2 {
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                // if in both case of skipping one char rest string is not pallindrome then
                // return false
                return isPallindrome(s, i + 1, j) || isPallindrome(s, i, j - 1);
            }
        }

        // at end return true means string is already pallindrome
        return true;
    }

    public static boolean isPallindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();

        boolean res = validPalindrome(str);
        System.out.println(res);
    }
}
