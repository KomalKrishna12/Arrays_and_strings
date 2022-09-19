import java.util.*;
// given an array we have to find find out majority element
// if any element frequency is more than n/2 than that element will be majority element
//
// eg :  [2,2,1,1,1,2,2]
// here 2 is aving freq as 4 which is greater than n/2 so it is majority element
//
// Brute Force
// we can use a hashmap and store freq of each element and then traverse into map and
// check freq if it greater than n/2 then return that element else return no majority element found
// but this approach ill take o(n) space complexity as well as time complexity
// 
// optimal
// we can colve this in o(n) time complexity and o(1) space complexity
// firstly find out valid candidate and then check that element freq and if it is greater than n/2 then 
// return that element
// to find out valid candidate
// we use two variable one is value and count
// initialize value with arr[0] and count as 1
// now start traversing into loop from 1 to n
// if arr[i] == value than increase count
// else decraease count means we're pairing up the value with arr[i]
// and check if count become 0 than make arr[i] as value and count as 1 
public class Q5_Majority_Element_I {
    public static int validCandidate(int[] arr) {
        int value = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == value) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                value = arr[i];
                count = 1;
            }
        }
        return value;
    }

    public static void printMajorityElement(int[] arr) {
        int value = validCandidate(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                count++;
        }

        if (count > arr.length / 2) {
            System.out.println(value);
        } else {
            System.out.println("No Majority Element exist");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        scn.close();
        printMajorityElement(arr);
    }
}
