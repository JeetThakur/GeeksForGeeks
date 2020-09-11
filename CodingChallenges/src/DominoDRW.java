import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DominoDRW {

    static Map<int[],Integer> domino = new HashMap<>();
    static Map<Integer, Integer> number = new HashMap<>();
    static int[] numbers = new int[12];
    public static void main(String[] args) {
//        Do uncomment if required to get numbers from the user
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the array in a fashion where each value in on one line with 12 values only");
//        for(int i=0 ; i< 12 ; i++){
//            numbers[i] = sc.nextInt();
//        }

        // Seeded values
        numbers = new int[]{1,2,2,2,6,2,2,2,2,2,2,2};
        DominoDRW obj = new DominoDRW();
        System.out.println(obj.isDominoPossible(numbers));
    }

    boolean isDominoPossible(int[] numbers){

        for(int i=0; i<12; i=i+2){
            // Add the domino in the domino map
            int[] temp = new int[]{numbers[i], numbers[i+1]};
            Arrays.sort(temp);
            int value = 1;

            for(Map.Entry<int[], Integer> entry: domino.entrySet()){
                if(entry.getKey()[0] == temp[0] && entry.getKey()[1] == temp[1]){
                value = entry.getValue() + 1;
                domino.remove(entry.getKey());
                break;
                }
            }
            domino.put(temp, value);
            // Add the numbers in the respective numbers map
            putNumber(numbers[i]);
            putNumber(numbers[i+1]);
        }
        // Now base condition check that number map should have only 2 -> 1 value numbers to perform the pyramid
        int uniqueNumCounter = 0;
        int[] uniqueNums = new int[2];
        for (Map.Entry<Integer, Integer> entry: number.entrySet()){
            if (entry.getValue() == 1 && uniqueNumCounter < 3) {
                uniqueNums[uniqueNumCounter] = entry.getKey();
                uniqueNumCounter++;
            }
        }
        if (uniqueNumCounter != 2){
            return false;
        }

        // Now base condition that the domino map should have compulsory 1 entry 2 times else false
        // This holds the pair which is the end and the start at the same time
        int[] dupPair = {0,0};
        int[] tempDup = new int[2];
        boolean flag = true;
        for (Map.Entry<int[], Integer> entry: domino.entrySet()){
            if (entry.getValue() >= 2) {
                dupPair[0] = entry.getKey()[0];
                dupPair[1] = entry.getKey()[1];
                tempDup[0] = dupPair[0];
                tempDup[1] = dupPair[1];

                int value = entry.getValue() - 1;
                domino.remove(entry.getKey());
                domino.put(entry.getKey(), value);
                flag = false;
                break;
            }
        }
        if (flag){
            return false;
        }

        // Now all edge cases are done -- we will now go in and keep removing the domino map

//        for (Map.Entry<int[], Integer> entry: domino.entrySet()){
//            System.out.println(entry.getKey()[0]+" "+ entry.getKey()[1]);
//        }
        for (int i=0; i<2; i++){
            int toFindNext = findNextNumber(uniqueNums[i], -1);
            int isSameToDup = findNextNumber(toFindNext, uniqueNums[(i+1)%2]);
            if (isSameToDup == dupPair[0]){
                dupPair[0] = -1;
            } else if (isSameToDup == dupPair[1]){
                dupPair[1] = -1;
            }
        }
        if(dupPair[0] == -1 && dupPair[1]== -1 && domino.size()== 1){
            for(Map.Entry<int[], Integer> entry: domino.entrySet()){
                if (entry.getKey()[0] == tempDup[0] && entry.getKey()[1]==tempDup[1])
                    return true;
            }
        }
        System.out.println(domino);
        return false;
    }

    void putNumber(int num){
        int value = 1;
        if (number.containsKey(num)){
            value = number.get(num) + 1;
        }
        number.remove(num);
        number.put(num , value);
    }

    int findNextNumber(int num, int num2){
        for (Map.Entry<int[], Integer> entry: domino.entrySet()){
            int[] key = entry.getKey();
            if (entry.getKey()[0] == num && entry.getKey()[1] != num2 ){
                int value = entry.getValue() - 1;
                domino.remove(key);
                if(value !=0)
                    domino.put(key, value);
                return key[1];
            } else if ( entry.getKey()[1] == num && entry.getKey()[1] != num2){
                int value = entry.getValue() - 1;
                domino.remove(key);
                if(value !=0)
                    domino.put(key, value);
                return key[0];
            }
        }
        return -1;
    }
}
