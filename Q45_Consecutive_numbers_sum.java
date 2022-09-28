import java.util.*;

public class Q45_Consecutive_numbers_sum {
    public static int consecutiveNumbersSum(int n) {
        int count = 0;

        for (int k = 1; 2 * n > k * (k - 1); k++) {
            int numerator = n - (k * (k - 1) / 2);
            if (numerator % k == 0)
                count++;
        }

        return count;
    }

    // ~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        scn.close();
        int res = consecutiveNumbersSum(num);
        System.out.println(res);
    }
}
