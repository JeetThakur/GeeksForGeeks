import java.util.*;

public class HighestBitSet {

    public static void main(String[] args) {
        // Re-using the method already written to find the logBase2 of a number
        // Or else write those 4 lines here again and remove the object creation
        LogBase2 logBase2 = new LogBase2();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to find it's highest bit set");
        long number = sc.nextLong();
        System.out.println("\nThe result is : " +  (int)Math.pow(2, logBase2.log2(number)));
    }
}
