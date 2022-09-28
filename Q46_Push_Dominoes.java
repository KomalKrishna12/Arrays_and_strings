import java.util.*;

public class Q46_Push_Dominoes {
    public static String pushDominoes(String str) {
        char[] arr = new char[str.length() + 2];
        // at start add 'l' bcoz it'll down towards left and no impat on other
        // at end ad 'R'
        arr[0] = 'L';
        int idx = 1;
        for (char ch : str.toCharArray())
            arr[idx++] = ch;
        arr[arr.length - 1] = 'R';

        int j = 0;
        int k = j + 1;
        while (k < arr.length) {
            while (k < arr.length && arr[k] == '.') {
                k++;
            }
            f(arr, j, k);
            j = k;
            k = j + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length - 1; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void f(char[] arr, int j, int k) {
        char ch1 = arr[j];
        char ch2 = arr[k];
        // both are same then between j and k all will be ch1 or ch2
        if (ch1 == ch2) {
            for (int i = j + 1; i < k; i++) {
                arr[i] = ch1;
            }
        } else if (ch1 == 'L' && ch2 == 'R') {
            // means both are in oppositte direction so no effect on between elements
            return;
        } else {
            // now ch1 is 'R' and ch2 is 'L' means both will fall
            // towards each other
            // now find out size of mid elements
            int size = k - j - 1;
            int mid = (j + k) / 2;
            // if size is even then from j+1 to mid mark ch1(R)
            // from mid+1 till k-1 mark ch2(L)
            // f off than the mid element will be the same so from
            // i+1 to mid-1 mark ch1 and from mid+1 to k-1 mark ch2
            if (size % 2 == 0) {
                for (int i = j + 1; i <= mid; i++) {
                    arr[i] = ch1;
                }
                for (int i = mid + 1; i < k; i++) {
                    arr[i] = ch2;
                }
            } else {
                for (int i = j + 1; i < mid; i++) {
                    arr[i] = ch1;
                }
                for (int i = mid + 1; i < k; i++) {
                    arr[i] = ch2;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        String res = pushDominoes(str);
        System.out.println(res);
    }
}
