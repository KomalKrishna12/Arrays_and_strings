import java.util.*;
// we have given an array and a target we have to find triplet (val1, val2, val3)
// whose sum is equal to target like we did in twoSum for pairs
// we use twoSum approach here
// first of all sort the array
// check if te arr elmeent is less then 3 then return null list bcoz not possible to make 
// triplet using two elements
// run a loop from i = 0 to n-3
// check if i is not 0 and prev ith and curr ith is same then continue otherwise it'll make duplicate
// pairs, now store arr[i] into val1 now we have one element of triplet now we need to find out
// rest two element so find this in (i+1 to n) so paas this in twoSum method
// from twoSum method we'll get an arraylist of pairs now fetch all list and add val1 into that and
// add that into and list 
public class Q38_Three_sum{
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = nums.length;
        if(n < 3) return ans;
        
        for(int i = 0; i <= n-3; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int val1 = nums[i];
            int tar = target - val1;
            List<List<Integer>> sublist = twoSum(nums, i+1, n-1, tar);
            for(List<Integer> sub: sublist){
                sub.add(val1);
                ans.add(sub);
            }
        }
        
        return ans;
        
      }
      
      public static List<List<Integer>> twoSum(int[] nums, int si, int li, int tar){
          int left = si;
          int right = li;
          List<List<Integer>> ans = new ArrayList<>();
          
          while(left < right){
              if(left != si && nums[left] == nums[left-1]){
                  left++;
                  continue;
              }
              int sum = nums[left] + nums[right];
              if(sum == tar){
                  List<Integer> list = new ArrayList<>();
                  list.add(nums[left]);
                  list.add(nums[right]);
                  ans.add(list);
                  left++;
                  right--;
              }
              else if(sum > tar){
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
        List<List<Integer>> res = threeSum(arr, target);
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