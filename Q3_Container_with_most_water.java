import java.util.*;
// we have given an array which contains heights of some containers
// which are present in vertical lines
// we have to return max volume (width * heigth) of water which we can fill using any two points
// points means heights given in array
// it is like we have given rectangle of width 1 and height heights[i]
// we have to fin out max rectangle
// 
// Brute force:
// we can use O(n^2) approach run a loop start from i = 0 to heights.length
// and j from i + 1 to heights end
// we can take height as min(height[i], height[j])
// becoz it is rectangle so the height have to be same from both side
// and width will be j - i
// area will be width * height and do this for all partitions and find out max area
// int area = 0;
// for(int i = 0; i < heights.length; i++){
//     for(int j = i + 1; j < heights.length; j++){
//         int height = Math.min(heights[i], heights[j]);
//         int width = j - i;
//         area = Math.max(area, height * width);
//     }
// }
// return area;
//
// optimal approach :
// use two pointers i and j
// i point to start index which is 0 and j points to end index which is height.length - 1
// now run a while loop till i is les than j when i == j then break the loop bcoz we cannot
// storewater into a single vessel
// findout width using same formula j - i and height using same min of both i and j heights
// now compare width * height with previous and store max into water or area
// if ith value is minimum then increase i bcoz it is already min so their is chance that 
// next idx will be greater
// j is already max so their is only chance of decrease bcoz if next j which is j--(bcoz j is end idx)
// is greater then also it will decrease bcoz ith idx height is small and if next j is small
// then also it'll decraese so we go with min values bcoxz their is a chance of getting next
// greater height 
public class Q3_Container_with_most_water {
    public static int mostWater(int[] heights) {
        int water = 0;
        int i = 0;
        int j = heights.length - 1;
        while(i < j){
            int width = j - i;
            int height = Math.min(heights[i], heights[j]);
            water = Math.max(water, width * height);

            if(heights[i] < heights[j]) i++; // increament that index which have min height
            else j--;
        }
        return water;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }
        scn.close();
        int res = mostWater(heights);
        System.out.println(res);
    }
}
