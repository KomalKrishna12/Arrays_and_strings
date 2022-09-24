import java.util.Scanner;
// given a number in the form of string we need to swap any two no at max one and made a max
// number
// eg: num : "99890" swap 8 with 9 num : "99980"
//
// Aproach 0: we can use two pointer i and j
// if i is 9 then continue bcoz their is no max no of 9
// else put j = i + 1 and search j to end of num and find max no and now swap ith num with jth num
// time complexity will be o(n^2)
//
// Aproach 1: create a right index arr and store every max index in right side of each element
// now traverse into num
// if num[i] == rightmaxindex[i] then continue else swap ith num with jth num that will be our max no
//
// Aproach 2:
// create last index of every digits from 0 to 9
// now traverse into no if digit is 0 then no swapping else find last digit of num from 9 to num+1
// if any last digit index is greater than current index than swap that digit with last index of greater 
// element
public class Q34_Maximum_swap {
    public static String maximumSwap(String num) {
        char[] arr = num.toCharArray();
        // last index of digits
        int[] li = new int[10];
        
        for(int i = 0; i < arr.length; i++){
            int digit = arr[i] - '0';
            li[digit] = i;
        }
        
        // swap with max digit
        boolean flag = false;
        for(int i = 0; i < arr.length; i++){
            int digit = arr[i] - '0';
            for(int j = 9; j > digit; j--){
                if(li[j] > i){
                    // swap i and j and break but here it is nested loop so after break it'll run for next digit so using flag mark true and break
                    swap(arr, i, li[j]);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        
        // now prepare string
        String ans = "";
        for(char ch : arr) ans += ch;
        return ans;
    }

    public static void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    // ~~~~~~~~Input Management~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();

        String ans = maximumSwap(str);
        System.out.println(ans);
    }
}
