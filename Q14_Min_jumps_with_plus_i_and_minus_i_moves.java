import java.util.*;
public class Q14_Min_jumps_with_plus_i_and_minus_i_moves {
    public static int minJumps(int x) {
        // Write your code here
        int sum = 0;
        int jump = 1;
        
        while(sum < x){
            sum += jump;
            jump++;
        }
        
        if((sum-x)%2==0) return jump-1;
        else if((sum+jump-x)%2==0) return jump;
        else return jump+1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        scn.close();

        int jumps = minJumps(x);
        System.out.println(jumps);
    }
}
