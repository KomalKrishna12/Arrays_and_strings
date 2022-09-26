import java.util.Scanner;
// given two arrays tops and bottoms we have to convert any one row equal with minimum
// swapping
// the number we can make in all place of equal row can be top[0] or bottom[0]
// so total 4 cases are possible
// case 1: make top array element as top[0]
// case 2: make bottom array element as top[0]
// case 3: make top array element as bottom[0]
// case 4: make bottom array element as bottom[0]
// and return min of all four if res is Integer.MAX_VALUE then return -1 means not possible to make
// any row equal
public class Q35_Minimum_domino_rotations_for_equal_row {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int num1 = tops[0];
        int num2 = bottoms[0];
       
        int count1 = 0;  // count1 is used to count no of swaps to make top array as equal to num1
        int count2 = 0;  // count2 is used to count no of swaps to make bottom array as equal to num1
        int count3 = 0;  // count3 is used to count no of swaps to make top array as equal to num2
        int count4 = 0;  // count4 is used to count no of swaps to make bottom array as equal to num2

        for(int i = 0; i < tops.length; i++){
            // case 1:  make top array element as num1
            if(count1 != Integer.MAX_VALUE){
                if(tops[i] == num1){
                    // nothing to do
                }
                else if(bottoms[i] == num1){
                    // incraese swap count
                    count1++;
                }
                else{
                    // not possible to make top array as equal to num1 so make count1 as max so 
                    // it'll stop here
                    count1 = Integer.MAX_VALUE;
                }
            }

            // case 2:  make bottom array element as num1
            if(count2 != Integer.MAX_VALUE){
                if(bottoms[i] == num1){
                    // nothing to do
                }
                else if(tops[i] == num1){
                    // incraese swap count
                    count2++;
                }
                else{
                    // not possible to make bottom array as equal to num1 so make count3 as max so 
                    // it'll stop here
                    count2 = Integer.MAX_VALUE;
                }
            }

            // case 3:  make top array element as num2
            if(count3 != Integer.MAX_VALUE){
                if(tops[i] == num2){
                    // nothing to do
                }
                else if(bottoms[i] == num2){
                    // incraese swap count
                    count3++;
                }
                else{
                    // not possible to make top array as equal to num1 so make count1 as max so 
                    // it'll stop here
                    count3= Integer.MAX_VALUE;
                }
            }

            // case 4:  make bottom array element as num2
            if(count4 != Integer.MAX_VALUE){
                if(bottoms[i] == num2){
                    // nothing to do
                }
                else if(tops[i] == num2){
                    // incraese swap count
                    count4++;
                }
                else{
                    // not possible to make bottom array as equal to num1 so make count3 as max so 
                    // it'll stop here
                    count4 = Integer.MAX_VALUE;
                }
            }
        }

        int res = Math.min(Math.min(count1, count2), Math.min(count3, count4));

        return res == Integer.MAX_VALUE ? -1 : res;
      }
    
      //~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int[] top = new int[n];
        int[] bottom = new int[n];
    
        // read top
        for (int i = 0; i < top.length; i++) {
          top[i] = scn.nextInt();
        }
        // read bottom
        for (int i = 0; i < bottom.length; i++) {
          bottom[i] = scn.nextInt();
        }
    
        int rotation = minDominoRotations(top, bottom);
        System.out.println(rotation);
      }
}
