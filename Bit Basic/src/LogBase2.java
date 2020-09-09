import java.util.*;
public class LogBase2 {

    private static int log2(long number){
        int counter = 0;
        while (number != 1){
            number = number >> 1;
            counter++;
        }
        return counter;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for which we need a log base 2 result");
        long number = sc.nextLong();
        System.out.println("\nthe result is : " + log2(number));
    }
}
