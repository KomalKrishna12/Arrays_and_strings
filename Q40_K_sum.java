import java.util.*;
// here we have given k so like in 4 sum we find out 3sum then 2 sum
// so we can use recursion and base case will be k equal to 2
public class Q40_K_sum {
    public static List<List<Integer>> kSum(int[] arr, int target, int k) {
        Arrays.sort(arr);
        return kSumHelper(arr, target, k, 0);
      }
    
      public static List<List<Integer>> kSumHelper(int[] arr, int target, int k, int si) {
        if (k == 2) {
          return twoSum(arr, si, target);
        }
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        if (n - si < k) return ans; // check if size of arrays is less than k then not possible to 
        // make k sum so return res
        for (int i = si; i <= n - k; i++) {
          if (i != si && arr[i] == arr[i - 1]) continue;
          int val = arr[i];
          List<List<Integer>> sub = kSumHelper(arr, target - val, k - 1, i + 1);
          for (List<Integer> list : sub) {
            list.add(val);
            ans.add(list);
          }
        }
        return ans;
      }
    
      public static List<List<Integer>> twoSum(int[] arr, int si, int tar) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n - si < 2) return ans;
        int left = si;
        int right = n - 1;
    
    
        while (left < right) {
          if (left != si && arr[left] == arr[left - 1]) {
            left++;
            continue;
          }
          int sum = arr[left] + arr[right];
          if (sum == tar) {
            List<Integer> sl = new ArrayList<>();
            sl.add(arr[left]);
            sl.add(arr[right]);
            ans.add(sl);
            left++;
            right--;
          }
          else if (sum > tar) {
            right--;
          }
          else {
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
        int k = scn.nextInt();
        scn.close();
        List<List<Integer>> res = kSum(arr, target, k);
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
