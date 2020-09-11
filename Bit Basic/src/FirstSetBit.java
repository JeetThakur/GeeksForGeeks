import java.util.*;
import java.lang.*;

public class FirstSetBit {
    /*  Function to find position with first set bit
     *   n: input integer
     */
    public static int getFirstSetBitPos(int n){
        // For 0 return 0
        if (n==0){
            return 0;
        }
        // All odd numbers will have the 1 position always flagged so return 1
        if ( (n & 1) == 1){
            return 1;
        }
        // To check if number is a power of 2
        if ( (n & n-1) == 0){
            return powerOf2(n);
        }
        // If not power of 2 or odd keep dividing till we find a 1
        int counter = 1;
        while( n != 1){
            n = n >> 1;
            counter++;
        }
        return counter;
    }
    // Power of 2 function to find the bit set
    public static int powerOf2(int n){
        int counter=1;
        while (n != 1){
            n=n>>1;
            counter++;
        }
        return counter;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            System.out.println(getFirstSetBitPos(n));
        }
    }
}