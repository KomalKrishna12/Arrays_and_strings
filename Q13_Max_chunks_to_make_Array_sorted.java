import java.util.*;

// this is similar like previous
// here we have given some elements not indexes
// so we use two arrays
// leftmax which store max from left
// rightmin which store min from right
// and then craete a var chunks and un a loop into arr
// if leftmax[i] <= rightmin[i+1] means till ith index we can place this max value
// bcoz in i+1 index we have greater value so increase chunks
// we can skip craeting leftmax array and use a variable to store left max
public class Q13_Max_chunks_to_make_Array_sorted {
    public static int maxChunksToSorted2(int[] arr) {
        // generate right min\
        int[] rmin = new int[arr.length + 1];

        rmin[arr.length] = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        }

        // generate left max and count chunks
        int lmax = Integer.MIN_VALUE;
        int chunks = 0;
        for (int i = 0; i < arr.length; i++) {
            lmax = Math.max(lmax, arr[i]);
            if (lmax <= rmin[i + 1])
                chunks++;
        }
        return chunks;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        scn.close();
        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}
