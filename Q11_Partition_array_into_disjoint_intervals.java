import java.util.*;
// in this ques we have given an array we have to divide them into two subarrays so that
// each element of left subarray is less than or equal to each element of right subarrays 
// we use concept of chunks
// use leftmax and rightmin
// now traverse into leftmax and check if leftmax[i] < rightmin[i+1] then mark ans and break
// return ans + 1 which will be the size of left subarray
public class Q11_Partition_array_into_disjoint_intervals {
    // o(n) space complexity
    public static int partitionDisjoint(int[] arr) {
        // generate rightmin
        int n = arr.length;
        int[] rmin = new int[n + 1];
        rmin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        }

        // manage leftmax and mark ans as i if any lmax[i] < rmin[i+1]
        // means in next ith index value is greater than curent so break
        int lmax = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            lmax = Math.max(lmax, arr[i]);
            if (lmax <= rmin[i + 1]) {
                ans = i;
                break;
            }
        }

        return ans + 1;
    }

    // o(1) complexity bcoz we use two variables only
    // when arr[i] > greater than update greater with arr[i]
    // if arr[i] < leftmax that means we can add this no into leftsubarray so set ans as i
    // and update leftmax as greater
    public static int partitionDisjoint2(int[] arr) {
        int leftmax = arr[0];
        int greater = arr[0];
        int ans = 0;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > greater){
                greater = arr[i];
            }
            else if(arr[i] < leftmax){
                ans = i;
                leftmax = greater;
            }
        }
        
        return ans + 1;
      }

    // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        scn.close();

        int len = partitionDisjoint(arr);
        System.out.println(len);
    }
}
