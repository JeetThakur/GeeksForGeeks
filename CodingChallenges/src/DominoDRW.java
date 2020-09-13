import java.util.*;

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
        numbers = new int[]{2,3,2,3,2,3,2,3,3,3,3,3};
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

        // Now base condition that the domino map should have compulsory 1 entry 2 times else false
        // This holds the pair which is the end and the start at the same time
        int[] tempDup = new int[2];
        int globalMax = 0;
        for (Map.Entry<int[], Integer> entry: domino.entrySet()) {
            if (entry.getValue() > globalMax && number.get(entry.getKey()[0])>=3 && number.get(entry.getKey()[1])>=3 ) {
                tempDup = entry.getKey();
                globalMax = entry.getValue();
            }
        }
        if (globalMax == 1){
            return false;
        }
        // The max pair is now the center tile domino and the one that will end the same domino pyramid
        int value = globalMax - 2;
        domino.remove(tempDup);
        if (value !=0)
            domino.put(tempDup, value);

        System.out.println("The centeral pair: " + tempDup[0] + " " + tempDup[1]);

        // Now take the center and find all the numbers
        // And then for each center value make 2 pass calls to find out the two dominos that can be placed as a bfs solution
        List<int[]> visited = new ArrayList<>();
        List<int[]> toVisit = new ArrayList<>();
        for(int i=0; i<2;i++){
            boolean flag = true;
            int centerVal = tempDup[i];
            // All possible mid layer placements
            toVisit = findAllPairs(toVisit , centerVal);

            while (flag && !toVisit.isEmpty()){
                // Only end when we find a placement possible for one more than the one chosen else return false
                int[] possiblity = toVisit.remove(0);

                if (isPlacable(possiblity, centerVal, visited)){
                    flag = false;
                    break;
                }
                visited.clear();
            }
            if (flag){
                return false;
            }
            visited.clear();
            toVisit.clear();
        }

        return true;
    }

    boolean isPlacable(int[] possiblity, int centerVal, List<int[]> visited){
        int toFind;
        if(possiblity[0] == centerVal)
            toFind = possiblity[1];
        else
            toFind = possiblity[0];
        visited.add(possiblity);
        for(Map.Entry<int[], Integer> entry : domino.entrySet()){
            int[] temp = entry.getKey();
            int value = entry.getValue();
            //domino.remove(temp);
            if( value >1 || !visited.contains(temp)){
                value = value - 1;

                visited.add(temp);
                if(temp[0] == toFind || temp[1] == toFind){
                    domino.put(temp,value);
                    return true;
                }
            }
            domino.put(temp,value);
        }
        return false;
    }

    List<int[]> findAllPairs(List<int[]> toVisit, int centerVal){
        for(Map.Entry<int[] , Integer> entry : domino.entrySet()){
            if(entry.getKey()[0] == centerVal || entry.getKey()[1]==centerVal){
                toVisit.add(entry.getKey());
            }
        }
        return toVisit;
    }


    void putNumber(int num){
        int value = 1;
        if (number.containsKey(num)){
            value = number.get(num) + 1;
        }
        number.remove(num);
        number.put(num , value);
    }


}
