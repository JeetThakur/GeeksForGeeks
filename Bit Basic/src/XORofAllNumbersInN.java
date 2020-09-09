import java.util.Scanner;

public class XORofAllNumbersInN {

    protected static long xorValue(long number){
        int remainder = (int) (number % 4);

        // Fact of XOR -- refer notes -- https://practice.geeksforgeeks.org/tracks/DSASP-BitMagic/?batchId=155
        switch (remainder){
            case 0:
                return number;

            case 1:
                return 1;

            case 2:
                return number+1;

            default:
                return 0;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for the range inclusive");
        long number = sc.nextLong();
        if (number < 0){
            System.out.println("Bad Number");
            System.exit(0);
        }
        System.out.println("\nThe XOR value of all the numbers in the range mentioned above is: " + xorValue(number));

    }
}
