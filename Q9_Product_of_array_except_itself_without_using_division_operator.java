import java.util.*;
// we can create two array left and right
// in left we store all left product so start from 0
// in right we store all right product so start from end
// now create a res array and for res[i] = left[i-1] * right[i+1]
// if i = 0 then res[i] will be right[i+1] only
// if i = arr.length - 1 then res[i] will be left[i-1] only
//
// we can solve this using one single right array also
// while calculating res create a var product and use that product in place of left array and
// after every iteration prod *= arr[i];
public class Q9_Product_of_array_except_itself_without_using_division_operator {
    public static int[] productExceptSelf(int[] arr) {
        int[] right = new int[arr.length];

        int prod = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            prod *= arr[i];
            right[i] = prod;
        }

        prod = 1;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            if (i == 0) {
                res[i] = right[i + 1];
            } else if (i == arr.length - 1) {
                res[i] = prod;
            } else {
                res[i] = prod * right[i + 1];
            }
            prod *= arr[i];
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        int[] res = productExceptSelf(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
