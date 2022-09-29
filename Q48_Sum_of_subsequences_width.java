import java.util.*;
// we have given an array we have to find out width of all the subsequence and add them
// width will be diff between maximum and minimum element of subsequence
// eg: arr: {2,1,3}
// arr susequences are :
// {2} -> for single length max and min is same so width = 0
// {1} -> 0
// {3} -> 0
// {2,1} -> 2-1 -> 1
// {2,3} -> 3-2 -> 1
// {1,3} -> 3-1 -> 2
// {2,1,3} -> 3-1 -> 2
// {} empty is not consideranle
// sum of all width is 0 + 0 + 0 + 1 + 1 + 2 + 2 = 6
//
// Aproach0 : Brute force
// find out all subsequences and then find max and min for every subsequence and find width and add
// into the ans
//
// Aproach1 : optimal
// if we sort the array than their will be n effect of width
// like {2,1,3} -> after sort -> {1,2,3}
// subsequcne of {1,2,3} are {1} -> 0, {2} -> 0, {3} -> 0, {1,2} -> 1, {1,3} -> 2, {1,2,3} -> 1, {2,3} -> 1
// width is same bcoz we are finding max and min, order not matter
// now for suppose 3 prev elements are {1,2} and possible subsequence are {1}, {2}, {1,2}, {}
// if we add 3 at end {1,3}, {2,3}, {1,2,3}, {3} in all prev 3 is max bcoz array is sorted
// so add ans = ans + 3 * 2pow2 basically subsequcne of n number are 2^n
// after 3 suppose {4} is their and for 1 no only 2 subsequnce possible {4} and {} if we add 3
// it'll be {3,4}, {3} 3 is always min for all the subsequnce after 3
// so w can find this for all numbers and add in arr
// ans = ans + arr[i] * 2^a - arr[i] * 2^b
//     = ans + arr[i] * (2^a - 2^b)
// a is no of elements before ith element and b is no of element after ith element
// it is 0 based indexing so no of element before ith is i itself and after will be (n-i-1)
// so we craeet an array for pow itself we need power of 2^0 till 2^n-1 so store it into array
public class Q48_Sum_of_subsequences_width{
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] A= new int[n];
        for(int i=0;i<n;i++){
            A[i]=scn.nextInt();
        }
        scn.close();
        System.out.print(sumSubseqWidths(A));
     }
     
     // -----------------------------------------------------
     // This is a functional problem. Only this function has to be written.
     // This function takes as input an array
     // It should return the required output

    public static int sumSubseqWidths(int[] arr) {
         Arrays.sort(arr);
         int n = arr.length;
         long ans = 0; // usex long so big values can be adjusted
         long mod = 1000000007;
         long[] pow = new long[n];
         pow[0] = 1; //2^0 = 1
         
         for(int i = 1; i < n; i++){
             pow[i] = (pow[i-1]*2)%mod;
         }
         
         for(int i = 0; i < n; i++){
             ans = (ans + arr[i] * (pow[i] - pow[n-i-1])) % mod;
         }
         return (int)ans;
     }
}