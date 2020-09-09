import java.util.*;
public class LogBase2 {

    protected int log2(long number){
        int counter = 0;
        while (number != 1){
            number = number >> 1;
            counter++;
        }
        return counter;
    }
    public static void main(String[] args) {
        LogBase2 logBase2 = new LogBase2();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for which we need a log base 2 result");
        long number = sc.nextLong();
        if (number < 0){
            System.out.println("Bad Number");
            System.exit(0);
        }

        System.out.println("\nthe result is : " + logBase2.log2(number));
    }
}
