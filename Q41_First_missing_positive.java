import java.util.*;
// we have given an array, we have to find out smallest positive number which is not 0
// suppose arr : {3,4,-1,1}
// here 1 is present, 2 is not present so missing positive no is 2
// arr : {1,2,3,4}
// here all no are their from 1 to 4 so smallest positive missing no will be 5
//
// Aproach 0:
// we can solve this o(n^2) firstly find out 1 if it is their then find out 2 and till we get any
// positive
//
// Aproach 1: o(nlogn)
// we can solve this using priority queue also, use a variable ans, initialize it with 1
//  now start removing priority queue elements it'll give priority to small elements
// if remove element is less than equal to 0 do nothing
// if element is equal to ans that means this is not missing no so increase it by 1 and at 
// end return ans
//
// PriorityQueue<Integer> pq = new PriorityQueue<>() ;
// for (int val : nums) pq.add(val);
// int ans = 1;
// while(pq.size() > 0){
//     int val = pq.poll();
//     if(val <= 0){
//     }
//     else if(val == ans){
//         ans++;
//     }
// }
// return ans;
//
// Aproach 1: o(nlogn)
// we can sort the array and start traversing into the array
// find 1 if available then increase 1 by 1 so it'll be 2 now find 2 if available then 3 else return 2
//Arrays.sort(nums);
// int ans = 1;

// for (int i = 0; i < nums.length; i++) {
//   if (nums[i] > 0 && nums[i] == ans) {
//     ans++;
//   }
//   else if(ans < nums[i]){
//       return ans;
//   }
// }
// return ans;
//
// Aproach 2: o(n) (optimized aproach)

public class Q41_First_missing_positive {
    public static int firstMissingPositive(int[] nums) {
      int n = nums.length; // check misising between 1 to n
    
      for(int i = 0; i < n; i++){
          int element = nums[i];
          int correctPosition = element - 1;
          // if element is 2 then it's correcrt position is 1
          // we have to check for numbers which are in range and range are from 1 to n
          
          if(element >= 1 && element <= n){
              // now check if it is already is the correct position then do nothing else 
              // swap nums[i] with nums[currentPosition] and mark i-- bcoz their is a chance that after swapping with ith 
              // position we place some element to it's wrong position
              if(nums[correctPosition] != element){
                  // swap 
                  int temp = nums[i];
                  nums[i] = nums[correctPosition];
                  nums[correctPosition] = temp;
                  i--;
              }
          }
      }
      
      // after this traverse in the loop and check if i+1 element is at ith position or not
      // if not than return i+1
      // if every index containing correct element then return n+1 means smallest positive no who is missing is n+1
      for(int i = 0; i < n; i++){
          if(i+1 != nums[i]) return i+1;
      }
      
      return n+1;
      }
    
      //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
    
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
    scn.close();
        int res = firstMissingPositive(arr);
        System.out.println(res);
      }
}
