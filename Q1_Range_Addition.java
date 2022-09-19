// in this question we have given length which means we have an array of size length 
// intially it is filled with 0
// we have also given a queries[][] array which have 3 columns
// first denotes : start index
// second denotes : end index
// third denotes : increament value
// means we have to add increament value into array from start to end indx which is given
// into first and second index of queries
//
// Brute force : is we run loop for all rows of queries array and inside it run a loop
// into array for si and ei given and add increament value into that index values and
// at end return arr
//
// optimal:
// add arr[si] with given inc value
// add -inc into arr[ei + 1] if that index exists that means we are adding till ei index and
// after that decrease by inc value
// do this for all queries
// now make this arr as prefix array, it'll be our ans
import java.util.*;
public class Q1_Range_Addition{
    public static int[] getModifiedArray(int length, int[][] queries) {
        int[] arr = new int[length];
        for(int i = 0; i < queries.length; i++){
            int si = queries[i][0]; // start index
            int ei = queries[i][1]; // end index
            int inc = queries[i][2]; // inceament
            // add inc into arr[si]
            // if ei + 1 is in the range of array then add -inc into arr[ei + 1]
            // bcoz we have to add inc from si to ei so after ei + 1 decrease this inc value 
            arr[si] += inc;
            if(ei + 1 < length){
                arr[ei + 1] += -inc;
            } 
        }
        // now make arr as prefix array
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            arr[i] = sum;
        }
        return arr;
      }
    
      // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        int length = scn.nextInt();
    
        int nq = scn.nextInt();

        scn.close();
    
        int[][] queries = new int[nq][3];
    
        for (int q = 0; q < nq; q++) {
          queries[q][0] = scn.nextInt();
          queries[q][1] = scn.nextInt();
          queries[q][2] = scn.nextInt();
        }
    
    
        int[] res = getModifiedArray(length, queries);
    
        for (int i = 0; i < res.length; i++) {
          System.out.print(res[i] + " ");
        }
      }
}