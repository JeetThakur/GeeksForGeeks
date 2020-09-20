import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hackerrank_CarrerFair_BalancedTeam {
    static TreeMap<Integer, Integer> numbers = new TreeMap<>();
    static TreeSet<Integer> addedNum = new TreeSet<>();
    static int maximum = 0;
    public static void main(String[] args) {
         int[] nums = {5,3,1,4,4};
//        int[] nums = {5,2};
        int toHire = 2;

        int answer = maxStable(nums, toHire);
        System.out.println(answer);

    }

    public static int maxStable(int[] nums , int toHire){
        // sort the array
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i< length; i++){
            int number = nums[i];
            // Adding the number to the set and to the map
            addedNum.add(number);
            int value = numbers.getOrDefault(number,0) + 1;

            // Update global maximum
            if (value > maximum){
                maximum = value;
            }
            numbers.put(number , value);

            // Add all its additive solution to the set -- dups will be ignored in general
            for (int j = 1 ; j<=toHire; j++){
                    addedNum.add(number+j);
            }
        }

          // This worked ... now let us see how to go about this in detail
//        System.out.println(addedNum);
//        System.out.println(numbers.keySet() + " " + numbers.values());

        // Now loop over the set addedNum and work with the differences with the numbers sorted list

        while (addedNum.size()>0){
            int counter = 0;
            int tempToHire = toHire;
            // Get last and then remove
            int number = addedNum.pollLast();
            addedNum.remove(number);

            // Loop the numbers here fuck the keys as of now
            for (int i=length-1 ; i >=0 ; i --){
                int thisNumber = nums[i];
                // only check for numbers less than that number -- the equal number count is present in the map
                if (thisNumber < number){
                    int diff = number - thisNumber;
                    if ( diff <= tempToHire) {
                        counter++;
                        tempToHire-=diff;
                    } else {
                        break;
                    }
                }
            }
            int val = numbers.getOrDefault(number,0) + counter;
            if (val > maximum)
                maximum = val;

            //System.out.println("Set val: " + number + " " + "Value: " + counter);
        }
        return maximum;
    }
}
