import java.io.*;
import java.util.*;

public class AbsoluteValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // number of testcases
        while (T > 0) {
            int I = sc.nextInt();
            Absolute obj = new Absolute();
            System.out.println(obj.absolute(I));
            T--;
        }
    }
}

class Absolute {
   // The absolute value return logic
    int absolute(int I) {
        // Your code here
        return Math.abs(I);
    }
}
