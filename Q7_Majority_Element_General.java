import java.util.*;
// given an array we have to store all the elements whose freq is more than n/k
// n is size of array and k is given
// here we use hasmap
// store all elements with its frequency
// create an arraylist and run loop on map
// and check freq of every element
// if it is greater than n/k then store it into res arraylist
// sort the list bcoz in ques it is mentioned and return
public class Q7_Majority_Element_General {
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > arr.length / k) {
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
    }
}
