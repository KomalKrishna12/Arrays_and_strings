import java.util.*;

import javax.sound.sampled.Port;
public class Demo{
    // static int count = (int)1e9;
    // public static int partitionString(String s) {
    //    //ArrayList<String> list = new ArrayList<>();
    //     f(s, 0);
    //     return count;
    // }
    
    // public static void f(String s, int list){
    //     if(s.length() == 0){
    //         if(list < count){
    //             count = list;
    //         }
    //         return;
    //     }
    //     for(int i = 0; i < s.length(); i++){
    //         String str = s.substring(0, i+1);
    //         String ros = s.substring(i+1);
    //         if(valid(str)){
    //             f(ros, list + 1);
    //         }else{
    //             break;
    //         }
    //     }
    // }
    
    // public static boolean valid(String s){
    //     if(s.length() == 1) return true;
    //     HashSet<Character> set = new HashSet<>();
    //     for(int i = 0; i < s.length(); i++){
    //         char ch = s.charAt(i);
    //         if(set.contains(ch)) return false;
    //         set.add(ch);
    //     }
    //     return true;
    // }

    // public static void main(String[] args) {
    //     String s = "lvkmzlaeaxbprczpfarnlaptfvmutkfsatyywnxpmkpduwoqeeiltbdjipwihqi";
    //     System.out.println(partitionString(s));
    // }

    // static long minCost(long arr[], int n) 
    // {
    //     // your code here
    //     if(n == 1) return arr[0];
    //     long cost = 0;
        
    //     List<Long> list = new ArrayList<>();
    //     for(long val : arr) list.add(val);
    //     while(list.size() > 1){
    //         Collections.sort(list);
    //         long val1 = list.get(0);
    //         long val2 = list.get(1);
    //         long sum = val1 + val2;
    //         cost += sum;
    //         list.remove(0);
    //         list.remove(1);
    //         list.add(sum);
            
    //     }
        
    //     return cost;
    
    // }

    // public static void main(String[] args) {
    //     // long[] arr = {4, 3, 2, 6};
    //     // System.out.println(minCost(arr, arr.length));;
    //     int n = 2;
    //     String str = Integer.toBinaryString(16);
    //     System.out.println(str);
        
    //     ArrayList<Integer> power = new ArrayList<>();
        
    //     for(int i = 0; i < str.length(); i++){
    //         if(str.charAt(i) == '1'){
    //             int val = (int)Math.pow(2, i);
    //             power.add(val);
    //         }
    //     }
    //     System.out.println(power);
    // }
    static int minPower(int n, int x)
    {
        // if x is 1, return n since
        // any power of 1 is 1 only.
        if (x==1)
            return n;
     
        // Consider n = a * x + b where
        // a = n/x and b = n % x.
        int ans = 0;
        while (n > 0)
        {
            // Update count of powers
            // for 1's added
            ans += (n % x);
     
            // Repeat the process for reduced n
            n /= x;
        }
     
        return ans;
    }
     
    // Driver code
    public static void main (String[] args)
    {
        int n = 5, x = 2;
        System.out.println(minPower(n, x));
    }
} 

// public String pushDominoes(String dominoes) {
//     char[] arr = new char[dominoes.length()+2];
//     char[] ans = new char[dominoes.length()];
//     for(int i = 0; i < dominoes.length(); i++){
//         ans[i] = dominoes.charAt(i);
//     }
//     arr[0] = 'L';
//     arr[arr.length-1] = 'R';
    
//     int i = 1;
//     for(char ch : dominoes.toCharArray()){
//         arr[i++] = ch;
//     }
     
//     int j = 0;
//     int k = 0;
    
//     while(j < arr.length){
//         k = j+1;
        
//         while(k < arr.length){
//             if(arr[k] == '.') {
//                 k++;
//             }
//             else{
//                f(arr, j, k, ans);
//             }
//         }
        
//         j = k;
//     }
    
//     String res = "";
//     for(char ch : ans) res += ch;
//     return res;
// }

// public void f(char[] arr, int j, int k, char[] ans){
//     char ch1 = arr[j];
//     char ch2 = arr[k];
//     if(ch1 == ch2){
//         for(int i = j+1; i < k; i++) ans[i-1] = ch1;
//     }
//     else if(ch1 == 'L' && ch2 == 'R'){
//         return;
//     }
//     else if(ch1 == 'R' && ch2 == 'L'){
//         int size = k - j - 1;
//         int mid = (j+k)/2;
//         if(size % 2 == 0){
//             for(int i = j+1; i <= mid; i++){
//                 ans[i-1] = ch1;
//             }
//         }
//         else{
//             for(int i = j+1; i < mid; i++){
//                 ans[i-1] = ch1;
//             }
//             for(int i = mid+1; i < k; i++){
//                 ans[i-1] = ch2;
//             }
//         }
//     }
// }