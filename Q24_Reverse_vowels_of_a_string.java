import java.util.*;
// given a string we have to reverse all vowels only
// suppose string is "pepCoding" here vowels are 'e' 'o' 'i' so we reverse it and it become 'i' 'o' 'e'
// using two pointers we can reverse vowels
// convert string into array so that we can swap characters in the array
// now run a loop till left is less then right
// whiile left is less than right and arr[left] is not vowel increase left by 1 and same with right 
// decrease right by 1
// now swap left and right chaarcters and left will incraese and right will decrease
// after whole vowels swapping again create a strign and add all char from array and return it
public class Q24_Reverse_vowels_of_a_string {
    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
    
        while (left < right) {
          while (left < right && !isVowel(arr[left])) {
            left++;
          }
          while (left < right && !isVowel(arr[right])) {
            right--;
          }
          char temp = arr[left];
          arr[left] = arr[right];
          arr[right] = temp;
          left++;
          right--;
        }
        s = "";
        for (char ch : arr) s += ch;
        return s;
      }
    
      public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'
            || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
            || ch == 'O' || ch == 'U') return true;
        return false;
      }
    
      // ~~~~~~~~~~~~Input Management~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
    
        String res = reverseVowels(str);
        System.out.println(res);
      }
}
