import java.util.*;
public class Q39_Four_sum {
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> ans = new ArrayList<>();
    if(n < 4) return ans;
    
    for(int i = 0; i <= n-4; i++){
        if(i != 0 && nums[i] == nums[i-1]) {
            continue;
        }
        int val1 = nums[i];
        int tar = target - val1;
        List<List<Integer>> list = threeSum(nums, i+1, n-1, tar);
        for(List<Integer> sl : list){
            sl.add(val1);
            ans.add(sl);
        }
    }
    
    return ans;
  }
  
  public static List<List<Integer>> threeSum(int[] nums, int si, int li, int target){
      List<List<Integer>> ans = new ArrayList<>();
      if(li-si+1 < 3) return ans;
      for(int i = si; i <= li - 2; i++){
          if(i != si && nums[i] == nums[i-1]){
              continue;
          }
          int val1 = nums[i];
          int tar = target - val1;
          List<List<Integer>> list = twoSum(nums, i+1, li, tar);
          for(List<Integer> sl : list){
            sl.add(val1);
            ans.add(sl);
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

    
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        List<List<Integer>> res = fourSum(arr, target);
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
