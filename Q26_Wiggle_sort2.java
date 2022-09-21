import java.util.Scanner;

public class Q26_Wiggle_sort2 {
    public static void wiggleSort2(int[] nums) {
        // write your code here
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        wiggleSort2(arr);
        /*
         * -if index is even then smaller than next,
         * -if index is odd then greater than next element,
         * -to check any correct order, we will not print array, we will check
         * inequality
         * -if print false, that means wrong answer, if true than correct answer.
         */
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && arr[i] >= arr[i + 1]) {
                System.out.println(false);
                return;
            } else if (i % 2 == 1 && arr[i] <= arr[i + 1]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
