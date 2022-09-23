import java.util.Arrays;
import java.util.Scanner;

public class Q26_Wiggle_sort2 {
    public static void wiggleSort2(int[] nums) {
       // 1. sort the array
      Arrays.sort(nums);
      
      // 2. create extra array and manage equality
      // using two pointers
      // first will be i which point to 1 and second will be at end
      // while i is less than than we fill res[i] = nums[j]
      // and increase i by 2 and decrease j by 1
      // when i is greater than n then make i as 0 and now start
      // filling even indexes
      int[] res = new int[nums.length];
      int i = 1;
      int j = res.length - 1;
      while(i < nums.length){
          res[i] = nums[j];
          i += 2;
          j--;
      }
      
      i = 0;
      while(i < nums.length){
          res[i] = nums[j];
          i += 2;
          j--;
      }
      
      // 3. again fill nums as res
      for(int ii = 0; ii < nums.length; ii++){
          nums[ii] = res[ii];
      }
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
