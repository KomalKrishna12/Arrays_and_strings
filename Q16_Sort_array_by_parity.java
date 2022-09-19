import java.util.*;
public class Q16_Sort_array_by_parity {
    public static void sortArrayByParity(int[] nums) {
        // write your code here
        int i = 0; //unsolved indexes
        int j = 0; //odd indexes
        
        while(i < nums.length){
            if(nums[i]%2==0){
                //even -> swap i and j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++;
                j++;
            }
            else{
                // odd
                i++;
            }
        }
    }

    //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        scn.close(); 

        sortArrayByParity(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
