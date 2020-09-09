import java.util.*;
public class IsPowerOf2 {
    private static boolean isPowerOf2(long number){
        long answer =  number & number-1;
        return answer ==0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to check whether it is a power of 2 or not: ");
        long number = sc.nextLong();
        System.out.println("\nThe result is: " + isPowerOf2(number));

    }
}
