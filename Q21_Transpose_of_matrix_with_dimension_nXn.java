import java.util.*;
// in n*n dimension if we swap all then it'll become same 
// so start j from i we have to swap only upper or lower triangle elements
public class Q21_Transpose_of_matrix_with_dimension_nXn {
    public static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
            }
          }
    }
  
    // ~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int[][] matrix = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          matrix[i][j] = scn.nextInt();
        }
      }
      scn.close();
      transpose(matrix);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
      }
    }
}
