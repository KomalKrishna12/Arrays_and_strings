import java.util.*;
// given an array and a target we have to find all the unique pairs whose sum is equal to target
// arr: {2, 2, 4, 4} tar = 6 so it's unique pair is {2,4}
//
// in order to get unique pair firstly we sort the array so we can avoid duplicate elements
// by checking prev element bcoz it is sorted to same element will be together
// craete two pointer left amnd right
// left point to first index i.e 0 and right point to last index i.e arr.length - 1
// now run a while loop till left is less than right
// firstly check if left is not 0 and prev left element and curr left element is same then
// incraese left and continue
// now find sum of both left and right element and check if it equal to target then create array list and
// add both numbers and add that array list into and arraylist do left++ and right--
// if sum is greater than target then reduce right and if less than target then increase left
public class Q36_Two_Sum {
    public static List<List<Integer>> twoSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(arr);
    int left = 0;
    int right = arr.length - 1;
    while(left < right){
        if(left != 0 && arr[left] == arr[left-1]){
            left++;
            continue;
        }
        int sum = arr[left] + arr[right];
        if(sum == target){
            List<Integer> sl = new ArrayList<>();
            sl.add(arr[left]);
            sl.add(arr[right]);
            ans.add(sl);
            left++;
            right--;
        }
        else if(sum > target){
            right--;
        }
        else{
            left++;
        }
    }
    return ans;
      }
    
      // ~~~~~~~~~~Input Management~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        List<List<Integer>> res = twoSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
          Collections.sort(list);
          String ans = "";
          for (int val : list) {
            ans += val + " ";
          }
          finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
          System.out.println(str);
        }
      }
}
