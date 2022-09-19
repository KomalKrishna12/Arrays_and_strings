import java.util.*;
// we have given a number in the form of string, we have to find out the number which having 
// same count as in number but that no has to be just greater than given no
// like given "123" just greater no is 132
// like permuatation of 123
// 123 -> 132 -> 213 -> 231 -> 312 -> 321
// if no is 321 then their is no greatrer no possible so return -1
// we can say if no is in sorted order for each char then it is greater among all permuattions
// so we start traversing from end 
// whenevr any number found which is not in sorted order then mark it as i
// create other var k and assig it as arr.length -1 and check from end if any greater than arr[i]
// found then replace that ith element with kth element
// now create string and add 0 to ith char into string and then ad from arr.length - 1 to idx+1
//
public class Q8_Next_Greater_Element_III {
    public static String nextGreaterElement(String str) {
        char[] arr = str.toCharArray();
        int idx = arr.length - 2;

        // find element which is not is sorted order
        while (idx >= 0 && arr[idx] >= arr[idx + 1]) {
            idx--;
        }

        if (idx == -1)
            return "-1";

        // now we have an element which is not in sorted order
        // now use a var k and start traversing into arr again from
        // back and decrease k till we got any arr[k] which is
        // greater than arr[idx]

        int k = arr.length - 1;
        while (arr[k] <= arr[idx]) {
            k--;
        }

        // now swap idx and k values
        char temp = arr[idx];
        arr[idx] = arr[k];
        arr[k] = temp;

        // reverse char from idx+1 to end
        // so we create string and add 0 to idx values and then in reverse
        // from end - 1 to idx + 1

        String ans = "";

        for (int i = 0; i <= idx; i++) {
            ans += arr[i];
        }

        for (int i = arr.length - 1; i > idx; i--) {
            ans += arr[i];
        }

        return ans;
    }

    // ~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        scn.close();

        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}