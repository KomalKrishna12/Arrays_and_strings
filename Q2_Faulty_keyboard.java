import java.util.Scanner;

// we have given two strings name and types
// a person is using a faulty keyboard in which some characters are typed one or more than one times
// we have to check that the typed name enter is correct or not
// eg : name : mannu, typed : mmaannu
// m and a is typed repeatedly but in same sequenece and every char present so it is true
// eg2 : name : abc, typed : bac
// here first char of naem was a but he or she typed b which is not correct so it is false
// 
// we use two pointers i and j
// i points to name string and j points to typed string
// now run a while loop till both idx is less than their string lengths
// if both char at their idx are equal then increase both
// if both are not equal than may be the user typed previous char repeatedly so check if char at (i -1)
// euqal to char(j) then increase j only
// else return false means it is not correctly typed
public class Q2_Faulty_keyboard {
    public static boolean isPossible(String name, String typed) {

        if(name.length() > typed.length()) return false;
        // if name's length is greater than typed length then it is not possible so return true

        int i = 0, j = 0;

        while (i < name.length() && j < typed.length()) {

            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
                // when we match with previous char check i index if it is 0 then i - 1 will be
                // out of bound
                j++;
            } else {
                return false;
            }

        }

        // no their is a chance that ith char is typed repeatedly so check the rest
        // string of typed
        while (j < typed.length()) {
            if (name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        // eq : name : aabbc, typed : aaabbb
        // here it is false becoz a and b typed repeatedly but c haven't typed so
        // there is chance that i is still left so check while returning
        // if i is less than name.length means still some char to match and j is not having
        // any char now so return false else return true 

        return i < name.length() ? false : true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        String typed = sc.next();

        sc.close();

        boolean res = isPossible(name, typed);

        System.out.println(res);
    }
}
