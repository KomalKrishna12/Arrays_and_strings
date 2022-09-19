import java.util.*;
// step-1: create a boolean arra of size n+1 and fill with true
// step-2: now start traverse from i = 2 if isPrime[i] is true then mark all it's multiples as false
// step3: now in array all primes are marked as true so run a loop and print all primes 
public class Q18_sieve_of_eratosthenes{
    public static void printPrimeUsingSieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        
        for(int i = 2; i * i <= isPrime.length; i++){
            if(isPrime[i]){
                for(int j = 2*i; j < isPrime.length; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        
        for(int i = 2; i < isPrime.length; i++){
            if(isPrime[i]) System.out.print(i+" ");
        }
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        printPrimeUsingSieve(n);
    }
}