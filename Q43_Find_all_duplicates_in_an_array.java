import java.util.*;

// we have given an array nums in the array all the elements are in the range of [1,arr.length]
// we have to find out all the elements who is duplicate and store them into array list
// 
// Aproach 0: brute force o(n^2) complexity
// run a for loop find an element and another run a or loop inside and check if that
// element is existing than add in the and and do this for all the array elements
//
// Aproach 1: sort the array o(nlogn)
// sort the array and traverse through array check next element if it is same then add that into list
//
// Aproach 1: using HashMap
// we can solve this using Hashmap, we can store freq of eah element and at end store all
// element whose freq is more than 1
// but we need to solve this using o(n) time complexity 
// 
// Aproach 2: using another array complexity o(N) but taking space bcoz we create an array
// we can craete an array arr of same size and run a for loop into nums array 
// now if any nums[i] = 5 then increase arr[5-1] count by 1 and if arr[5-1] is greater than 1 
// then store it into ans
//
// Aproach 3: optimized o(n) complexity and constant space
// run a for loop get element as nums[i] get it's index as i-1
// step1: find index and mark it's presence
// step2: if index is already marked that mean's we found a duplicate element so add it into and list
public class Q43_Find_all_duplicates_in_an_array {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int ele = (int) Math.abs(nums[i]); // abs bcoz if we mark nums[i] as negetive that's why 
            int idx = ele - 1;
            if (nums[idx] < 0) {
                // already marked so add ele into ans
                ans.add(ele);
            } else {
                // mark element
                nums[idx] = -nums[idx]; // to convert into negetive we can multiply with -1 also
            }
        }

        return ans;
    }

    // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        List<Integer> res = findDuplicates(arr);
        if (res.size() == 0) {
            System.out.println("Empty");
            return;
        }
        Collections.sort(res);
        for (int val : res)
            System.out.print(val + " ");
        System.out.println();
    }
}
