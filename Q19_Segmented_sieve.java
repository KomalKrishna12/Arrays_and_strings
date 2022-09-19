import java.util.*;
public class Q19_Segmented_sieve {
    // find all the primes till number n
    // assume false means prime and true means not prime so that we don't need to fill the array
    // as true 
    public static ArrayList<Integer> soe(int n){
        boolean[] arr = new boolean[n+1]; // false: prime and true: not prime
        for(int i = 2; i < arr.length; i++){
            if(arr[i] == false){
                for(int j = 2*i; j < arr.length; j+=i){
                    arr[j] = true;
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 2; i < arr.length; i++){
            if(arr[i] == false) res.add(i);
        }
        return res;
    }
  
    public static void segmentedSieveAlgo(int a, int b) {
        // create a prime boolean array of length b-a+1
        boolean[] arr = new boolean[b - a + 1]; // false: prime, true: not prime
        
        // find out root of b
        int rootb = (int)Math.sqrt(b);

        // this primes list have all tghe prime till root of b
        ArrayList<Integer> primes = soe(rootb);
        
        // now one by one take each prime and find out its starting index using multiplication
        // multiplication = ceil(a*1.0/prime)
        // if mul is 1 then increase it by 1 otherwise it'll mark 2 as not prime
        // start idx will be mul*prime - a
        // now run a inner for loop and start from si and mark all idx as true means not prime
        for(int prime : primes){
            int mul = (int)Math.ceil(a*1.0/prime);
            if(mul == 1) mul++;
            int si = mul*prime - a;
            
            for(int j = si; j < arr.length; j += prime){
                arr[j] = true; // not prime
            }
        }
        
        // now traverse into array and check if arr[i] is false then print i+a
        // make sure i+a is not equal to 1 bcoz 1 is not a prime no
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == false && i + a != 1){
                // prime 
                int val = i + a;
                System.out.println(val);
            }
        }
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        scn.close();
        segmentedSieveAlgo(a, b);
    }
}
