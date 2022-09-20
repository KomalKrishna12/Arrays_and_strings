// we have to find the shortet subarray that can sort the whole arary if that subarray is sorted
// firstly find out end of that subarray
// if any value that is greater than that end in the left then that will be our end indx
// and also find out start of subarray
// if any value is greater than our start index in right side then that will be our start idx
// at end subtract end - start and add 1 bcoz it is 0 based indexing
public class Q22_Shortest_unsorted_continuous_subarray {
    public static int findUnsortedSubarray(int[] nums) {
        int end = -1;
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (max > nums[i]) {
                end = i;
            } else {
                max = nums[i];
            }
        }

        int start = -1;
        int min = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (min < nums[i]) {
                start = i;
            } else {
                min = nums[i];
            }
        }

        if (start == -1 && end == -1)
            return 0; // means array is already sorted

        return end - start + 1;
    }

    public static void main(String[] args) {

        int[] arr = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(arr));

    }
}
