import java.util.*;
// given a variable r which denoted rowIndex
// 0 - 1
// 1 - 1 1
// 2 - 1 2 1 
// 3 - 1 3 3 1
// 4 - 1 4 6 4 1
// basically if row is 4 then it's length will be 5 and 0th and 4th index will be 1
// 1st idx = summation of 0th and 1th idx of row 3 = 4
// 2nd idx = summation of 1st and 2nd idx of row 3 = 6
// 3rd idx = summation of 2nd and 3rd idx of row 3 = 4
// so and for row = 4 will be {1, 4, 6, 4, 1}
//
// Aproach 0 : recursion
// we can solve this using rercurison
// if r is 0 then return array list which contains 1 only {1}
// if r is 1 then retrun array list which contains 1 and 1  {1,1}
// and for rest call reursively for row - 1
// now we have list for row - 1 
// now create an ans array list
// add 1 as first element
// now run a loop from 0 to length - 1
// find ith and (i+1)th val, add summation of both into ans
// and after all at end add 1 and return ans
//
// Aproach 1: combinations
// we can solve this using combination
// if row = 4 and ans will be
// {4C0, 4C1, 4C2, 4C3, 4C4}
// nC0 = 1, nCn = 1, nC1 = n and nCn-1 = n
// nCr = (n!)/(r!)(n-r)!
// to find out nCr+1 we can multiply a factor into nCr
// nCr+1 = nCr * factor
// factor = (n-r)/(r+1)
// row = 4 so here n is 4
// col = 5 (0, 4)
// ans : {4C0, 4C1, 4C2, 4C3, 4C4}
// 4C0 = 1;
// 4C1 = 4;
// 4C2 = 4C1 * (4-1)/(1+1) = 4 * 3/2 = 2*3 = 6
public class Q42_Pascals_triangle {

  // recursion aproach
    // public static ArrayList<Integer> pascalRow(int r) {
    //     return f(r);
    //   }
    
    //   public static ArrayList<Integer> f(int r) {
    //     if (r == 0) {
    //       ArrayList<Integer> list = new ArrayList<>();
    //       list.add(1);
    //       return list;
    //     }
    //     if (r == 1) {
    //       ArrayList<Integer> list = new ArrayList<>();
    //       list.add(1);
    //       list.add(1);
    //       return list;
    //     }
        
    //     ArrayList<Integer> list = f(r-1);
        
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     ans.add(1);
    //     for(int i = 0; i < list.size()-1; i++){
    //         int val1 = list.get(i);
    //         int val2 = list.get(i+1);
    //         ans.add(val1+val2);
    //     }
    //     ans.add(1);
    //     return ans;
        
    //   }
    
    public static ArrayList<Integer> pascalRow(int r) {
      ArrayList<Integer> ans = new ArrayList<>();
      int val = 1;

      for(int j = 0; j <= r; j++){
        ans.add(val);
        val = val * (r-j)/(j+1);
      }

      return ans;
    }
    // combination aproach (optimal aproach)

      // ~~~~~~~~~~~Input management~~~~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
    
        ArrayList<Integer> res = pascalRow(n);
        for (int val : res) {
          System.out.print(val + " ");
        }
        System.out.println();
      }
}
