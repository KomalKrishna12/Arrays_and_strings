import java.util.*;
// we have given an array people in which weight of all people ig given and a limit is given
// we have infinite supply of boats we need to count no of boats we can use to fill all the people
// we can adjust at most 2 people
// first of all sort the array
// craete two pointer left and right
// run a loop till left is lesser and equal to right
// find weight of both left adnd right people
// if weight is less than equal to limit then incraese count and shift both left and right
// if weight is greater than limit then only ajust bigger weight people which is right so incraese
// count and shift right pointer
public class Q37_Boat_to_save_people {
    public static int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int weight = people[left] + people[right];
            if (weight <= limit) {
                count++;
                left++;
                right--;
            } else {
                count++;
                right--;
            }
        }

        return count;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] people = new int[n];

        for (int i = 0; i < n; i++)
            people[i] = scn.nextInt();

        int limit = scn.nextInt();
        scn.close();
        int boats = numRescueBoats(people, limit);
        System.out.println(boats);
    }
}
