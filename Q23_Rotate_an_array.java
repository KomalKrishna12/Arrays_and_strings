import java.util.*;
// rotate an array means reverse it by 90 degree clockwise
public class Q23_Rotate_an_array {
    public static void rotate(int[][] matrix) {
        // Transpose
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
          for (int j = i + 1; j < n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
          }
        }
    
        // revrse row
        for (int i = 0; i < n; i++) {
          int left = 0;
          int right = n - 1;
          while (left <= right) {
            int temp = matrix[i][left];
            matrix[i][left] = matrix[i][right];
            matrix[i][right] = temp;
            
            left++;
            right--;
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
        rotate(matrix);
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            System.out.print(matrix[i][j] + " ");
          }
          System.out.println();
        }
      }
}
