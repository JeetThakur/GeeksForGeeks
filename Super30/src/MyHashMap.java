import java.util.Arrays;

public class MyHashMap {

    int[] hashMapKeys;
    int[] hashMapValues;
    int size;
    int occupancy;

    public MyHashMap() {
        size = 10;
        hashMapKeys = new int[10];
        hashMapValues = new int[10];
        Arrays.fill(hashMapKeys, -1);
        occupancy = 0;
    }

    // Thresholding -- increase the map size as required by 2
    public void grow(){
        size = size *2;
        occupancy = 0;
        fill();
    }

    // Refilling the map
    public void fill(){
        int[] tempK = hashMapKeys;
        int[] tempV = hashMapValues;
        hashMapKeys = new int[size];
        hashMapValues = new int[size];
        Arrays.fill(hashMapKeys, -1);

        for(int i=0; i<tempK.length; i++){
            if (tempK[i]!= -1)
                put(tempK[i], tempV[i]);
        }
    }

    // Retrieve the map value
    public int get(int key) throws Exception{
        int index = this.hashCode(key);
        if (hashMapKeys[index] == key){
            return hashMapValues[index];
        }
        int i = index;
        while (i != index-1){
            if (i == size){
                i = 0;
            }
            if (hashMapKeys[i] ==key)
                return hashMapValues[index];
            i++;
        }
       throw (new Exception("Key Error"));
    }

    // Check if anything else sits on that particular value of the same hash
    public int checkForCollisions(int index, int key){
        int i = index;
        while (i != index-1){
            if (i == size){
                i = 0;
            }
            if (hashMapKeys[i] == -1 || hashMapKeys[i]==key)
                return i;
            i++;
        }
        return -1;
    }

    // Return a unique hashcode for the size of the map
    public int hashCode(int key){
        return  key % size;
    }

    // Putting into the map
    public void put(int key, int value){
        if(++occupancy > size*0.8){
            grow();
        }
        else {
            int index = this.hashCode(key);
            if (hashMapKeys[index] == -1) {
                hashMapKeys[index] = key;
                hashMapValues[index] = value;
            } else {
                index = checkForCollisions(index, key);
                if(hashMapKeys[index] == -1){
                    hashMapKeys[index] = key;
                    hashMapValues[index] = value;
                }else{
                    hashMapValues[index] = value;
                }

            }
        }
    }

    // The getOrDefault returns a 0 for key not found
    public int getOrDefault(int key) throws Exception{
        try{
            return get(key);
        } catch (Exception e){
            return 0;
        }
    }

    // To remove a key no longer required
    public void remove(int key) throws Exception{
        int index = this.hashCode(key);
        if (hashMapKeys[index] == key)
            hashMapKeys[index] = -1;
        index = checkForCollisions(index, key);
        if(index == -1)
            throw (new Exception("Key Error"));
        else
            hashMapKeys[index] = -1;
    }



    public static void main(String[] args) throws Exception{
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,1);
        obj.put(3,1);
        obj.put(4,1);
        obj.put(5,1);
        obj.put(6,1);
        obj.put(7,1);
        obj.put(8,1);
        obj.put(9,1);
        obj.put(10,1);
        obj.put(11,1);
        obj.put(12,5);
        obj.remove(11);
        System.out.println(obj.get(12));

        // Simulating the getOrDefault behaviour of the map
        System.out.println(obj.getOrDefault(11));
    }
}
