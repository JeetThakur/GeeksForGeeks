

import java.util.*;
import java.lang.*;
import java.io.*;
public class FirstRightmostBitSet {
    /*  function to find position of rightmost different bit
     *   m, n : Integers to find rightmost different bits
     *   You can have a look in the locked code for information
     *   regarding other functions including driver code
     */
    public static int posOfRightMostDiffBit(int m, int n) {

        // Code passed all testcases on the geeksforgeeks platform
        if (m == n)
            return -1;
        int counter = 1;
        while( (m & 1) == (n & 1)){
            m = m >> 1;
            n = n >> 1;
            counter++;
        }

        return counter;

    }

public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc=new Scanner(System.in);
        //input number of testcases
        int t=sc.nextInt();
        int m,n;
        while(t-->0) {
            //input m and n
            m = sc.nextInt();
            n = sc.nextInt();
            System.out.println(posOfRightMostDiffBit(m, n));
        }
    }
}
