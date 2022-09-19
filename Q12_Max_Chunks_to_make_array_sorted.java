import java.util.*;
// given an array of {0,1,2.....arr.length - 1} which is one of the permuattion of indexes
// we have to partition that permutation into some partition so that if we sort each partition
// after merging all partitions it will be in a sorted array form
//
// we use chunks method
// create two var max and count
// run a loop into the array update max if any value is greater than max
// if max==i increase count by 1
// at end return count 
public class Q12_Max_Chunks_to_make_array_sorted {
    public static int maxChunksToSorted(int[] arr) {
        int max = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if(max == i) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        scn.close();

        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }
}
  