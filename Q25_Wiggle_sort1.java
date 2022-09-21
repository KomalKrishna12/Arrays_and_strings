import java.util.*;

// wiggle sort
// evry odd index element is greater or equal than prev and next idx element
// every even index element is lesser or equal than prev and next
public class Q25_Wiggle_sort1 {
  public static void wiggleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      // odd index
      if (i % 2 == 1) {
        // check only next idx element
        // for odd next should be smaller or equal so if not than swap
        if (arr[i + 1] > arr[i]) {
          swap(arr, i, i + 1);
        }
      }
      // even index
      else {
        // for even next should be greater or equal if not then swap
        // no need to check prev bcoz prev of curr is already greater than only we're
        // here bcoz perev is
        // odd idx element
        if (arr[i + 1] < arr[i]) {
          swap(arr, i, i + 1);
        }
      }
    }
  }

  public static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
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
