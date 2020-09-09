import java.util.Arrays;
import java.util.Scanner;

public class MaximumAndValue {

    private static int maximumAndValue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the numbers");
        int size;
        size = sc.nextInt();

        // Edge case
        if(size==1){
            System.out.println(0);
            System.exit(0);
        }

        int[] numbers = new int[size];
        System.out.println("Enter the numbers now");

        // Input handling
        for (int i=0; i<size; i++)
            numbers[i] = sc.nextInt();

        LogBase2 logBase2 = new LogBase2();
        Arrays.sort(numbers);
        System.out.println("\nThe answer is: " + (int)Math.pow(2,maximumAndValue(size, numbers, logBase2)));
    }

    private static int maximumAndValue(int size, int[] numbers, LogBase2 logBase2){
        int tempVal;

        // Iterating in the descending order to find the best pair of maximum value to have the MaxAndValue
        for(int i= size-1; i>0; i--){
            tempVal = logBase2.log2(numbers[i]);
            // When the two powers of back to back numbers are same return as that is the best pair
            if(tempVal==maximumAndValue)
                return tempVal;
            // If not make the maxVal so far as the one that is different on the second chance as the new less best possible value
            maximumAndValue = tempVal;
        }
        // Nothing found is 0 and not the temp
        return 0;
    }
}
