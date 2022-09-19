import java.util.*;
// we have to find out product of max three numbers
// we can find max three no and product them and return but this will fail in negetetive no
// so we use two min1 min2 variable also bcoz if two no are negetive then their product will be 
// possitive
// so find all and in last compare
// prod1 = min1 * min2 * max1
// prod2 = max1 * max2 * max3
public class Q15_Max_product_of_three_numbers {
    public static int maximumProduct(int[] arr) {
       // find min1, min2, max1, max2 and max3
       int min1 = Integer.MAX_VALUE;
       int min2 = min1;
       
       int max1 = Integer.MIN_VALUE;
       int max2 = max1;
       int max3 = max1;
       
       for(int i = 0; i < arr.length; i++){
           int val = arr[i];
           
           // max check
           if(val >= max1){
               max3 = max2;
               max2 = max1;
               max1 = val;
           }
           else if(val >= max2){
               max3 = max2;
               max2 = val;
           }
           else if(val >= max3){
               max3 = val;
           }
           
           // min check
           if(val <= min1){
               min2 = min1;
               min1 = val;
           }
           else if(val <= min2){
               min2 = val;
           }
       }
       
       // compare
       return Math.max(min1*min2*max1, max1*max2*max3);
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        scn.close();

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}
