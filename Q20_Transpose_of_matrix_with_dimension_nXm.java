import java.util.*;
public class Q20_Transpose_of_matrix_with_dimension_nXm {
    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] trans = new int[m][n];
        
        for(int i = 0; i < trans.length; i++){
            for(int j = 0; j < trans[0].length; j++){
                trans[i][j] = matrix[j][i];
            }
        }
        
        return trans;
      }
    
    
      // ~~~~~~~~~~~Input Management~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
    
        int[][] matrix = new int[n][m];
    
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            matrix[i][j] = scn.nextInt();
          }
        }

        scn.close();
    
        int[][] res = transpose(matrix);
    
        for (int i = 0; i < res.length; i++) {
          for (int j = 0; j < res[0].length; j++) {
            System.out.print(res[i][j] + " ");
          }
          System.out.println();
        }
      }
}
