import java.util.*;
// we have given an array we have to find out max product of any subarray, subarray atleast
// contains 1 number
// we can say that max product subarray either start from 0 or from end
// which is proved we can check by assuming a, (subarray), b asume subarray +ve and +ve and assume for both
// a and b also and check
// but in case of zero start or end of subarray change it shift to after zero
public class Q47_Maximum_product_subarray {
    public static int max(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cprod = 1;
        // firstly traverse from start then traverse from end
        for(int i = 0; i < nums.length; i++){
            cprod *= nums[i];
            ans = Math.max(cprod, ans);
            // if nums[i] is zero so we need to fix start again so we mark cprod 1 so from next i it'll check
            // another subarray
            if(cprod == 0){
                cprod = 1;
            }
        }
        
        cprod = 1; // again set cprod as 1 to check subarray from end
        
        for(int i = nums.length - 1; i>=0; i--){
            cprod *= nums[i];
            ans = Math.max(cprod, ans);
            if(cprod == 0){
                cprod = 1;
            }
        }
        return ans;
   
        }
   
        public static void main(String[] args) {
   
             Scanner s = new Scanner(System.in);
             int n = s.nextInt();
             int[] a = new int[n];
             for (int i = 0; i < a.length; i++) {
                  a[i] = s.nextInt();
             }
             s.close();
             System.out.println(max(a));
   
        }
}
