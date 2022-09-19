import java.util.*;
// given an array which is sorted in increasing order
// we have to square all elements and then return the sorted array 
// eg: arr -> {-4, -1, 0, 3, 10}
// when we square each element it'll be {16, 1, 0, 9, 100}
// after sorting it'll be {0, 1, 9, 16, 100}
//
// Brute force :
// we run a loop in the array and make every element arr[i] = arr[i] * arr[i]
// after that sort that array
// it'll take o(n) + o(nlogn) time complexity
//
// Optimal approach :
// use two pointers i and j, the array is sorted so first index will nbe the min (may be negetive)
// and last index will be max
// so create a idx and an array ans and start idx from last index
// run a while loop till i <= j
// val1 = arr[i] * arr[i], val2 = arr[j] * arr[j]
// if val1 is greater then store it into ans[idx] and increase i++
// else store val2 and j--
// idx will decrease always
public class Q4_Square_of_sorted_array {
    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int idx = ans.length - 1;
        int i = 0;
        int j = nums.length - 1;

        while(i <= j){
            int val1 = nums[i] * nums[i];
            int val2 = nums[j] * nums[j];

            if(val1 > val2){
                ans[idx] = val1;
                i++;
            }
            else{
                ans[idx] = val2;
                j--;
            }
            idx--;
        }
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) 
            nums[i] = scn.nextInt();
         
        scn.close();    
        
        int[] res = sortedSquares(nums);

        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
