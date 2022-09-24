import java.util.Scanner;

// we have given an array and a left and right we have to count all the subarrays who's max is
// in the range of [left, right] inclusive
// arr : {2, 1, 4, 3}, left : 2, right : 3
// all subarrays of arr will be {2}, {2, 1}, {2, 1, 4}, {2, 1, 4, 3}, {1}, {1, 4}, {1, 4, 3},
// {4}, {4, 3},{3}
// in all subarrays {2}, {2, 1}, {3} these are in range bcoz in all these subarrays max is in
// range
//
// Aproach 0: generate all subarrays
// find max and increase count if max is in range
// but it'll take n(n+1)/2 complexity in generating all subarrays and again in finding it'll take
// more complexity
//
// Aproach 1:
public class Q33_Number_of_subarrays_max_bounded {
    public static int numSubarrayBoundedMax(int[] arr, int left, int right) {
        int si = 0;
        int ei = 0;
        int count = 0;
        int preCount = 0;

        while (ei < arr.length) {
            // case 1 : arr[ei] is in limit so preCount will be ei - si + 1
            // {2, 3} left = 2 and right = 4, arr[ei] == 3 which is in range so subarrays
            // which end at 3 are {3}, {2,3}
            // prevCount = ei - si + 1 = 1 - 0 + 1 = 2
            if (arr[ei] >= left && arr[ei] <= right) {
                preCount = ei - si + 1;
                count += preCount;
            }
            // case 2 : arr[ei] is less than left so subarray count will be same as preCount
            // {2, 3, 1} left = 2 and arr[ei] == 1 than possible subarray which end at 1
            // will be {1}, {3,1}, {2,3,1} here max of {1} is not
            // in range so it is similar to preCount we simple add 1 in all previous
            // subarray
            else if (arr[ei] < left) {
                count += preCount;
            }
            // case 3 : arr[ei] is greater than right
            // {2,3,5} left = 2 and right = 4 and arr[ei] = 5 subarrays which end at 5 are
            // {5}, {3,5}, {2,3,5} in all subarrays max is greater
            // than right so no subarrays will be counted and si will change and set at ei +
            // 1 also set preCount as 0 so when after this
            // and element less than left encounter so 0 will be count
            // {2,3,5,1} till 5 count : {2}, {3}, {2,3}, so preCount is 3 so set as 0
            // otherwise in next arr[ei] = 1 so it count 3 more
            else {
                si = ei + 1;
                preCount = 0;
            }
            ei++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int left = scn.nextInt();
        int right = scn.nextInt();
        scn.close();

        int count = numSubarrayBoundedMax(arr, left, right);
        System.out.println(count);
    }
}
