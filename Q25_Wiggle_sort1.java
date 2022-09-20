import java.util.*;
public class Q25_Wiggle_sort1 {
    public static void wiggleSort(int[] arr) {
        // write your code here
      }
    
      // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        int n = scn.nextInt();
        int[] arr = new int[n];
    
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }

        scn.close();
    
        wiggleSort(arr);
    
        for (int val : arr) {
          System.out.print(val + " ");
        }
        System.out.println();
      }
}
