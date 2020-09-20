import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static java.util.Arrays.asList;
import java.util.Map;

public class ThrottleGateway_Citadel {
    public static final int MAX_PER_SECOND = 3;
    public static final int MAX_TEN_SECONDS = 20;
    public static final int MAX_PER_MINUTE = 60;
    public static void main(String[] args) {
        List<Integer> requestTime1 = asList(
        100,
        100,
        101,
        102,
        102,
        103,
        103,
        105,
        105,
        106,
        106,
        106,
        107,
        107,
        109,
        109,
        109,
        109,
        110,
        110,
        110,
        111,
        111,
        112,
        114,
        115,
        115,
        116,
        116,
        116,
        117,
        118,
        118,
        120,
        120,
        121,
        121,
        122,
        122,
        123,
        123,
        124,
        124,
        125,
        127,
        128,
        128,
        129,
        131,
        133,
        134,
        135,
        135,
        135,
        136,
        137,
        137,
        137,
        138,
        138,
        140,
        140,
        140,
        141,
        141,
        143,
        144,
        145,
        146,
        149,
        149,
        149,
        149,
        149,
        151,
        151,
        152,
        152,
        154,
        154,
        155,
        156,
        156,
        157,
        158,
        158,
        159,
        159,
        160,
        160,
        160,
        162,
        162,
        162,
        164,
        166,
        167,
        167,
        169,
        169,
        172,
        172,
        172,
        172,
        174,
        175,
        175,
        175,
        176,
        177,
        177,
        177,
        179,
        179,
        180,
        180,
        180,
        180,
        181,
        181,
        181,
        182,
        182,
        183,
        183,
        183,
        184,
        184,
        187,
        187,
        188,
        188,
        188,
        188,
        189,
        189,
        189,
        190,
        191,
        191,
        192,
        192,
        193,
        195,
        195,
        195,
        195,
        197,
        198,
        198,
        199,
        199,
        200,
        200,
        200);
        ThrottleGateway_Citadel test = new ThrottleGateway_Citadel();
        System.out.println(test.droppedRequests(requestTime1));
    }

    public static HashMap<Integer, Integer> fillMap (List<Integer> arr){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (Integer i : arr) {
            Integer j = hm.getOrDefault(i, 0);
            hm.put(i, j + 1);
        }
        return hm;
    }

    public int droppedRequests(List<Integer> requestTime) {
        try {
            if (requestTime.size()<=3)
                return 0;
            HashMap<Integer, Integer> count = fillMap(requestTime);
            HashMap<Integer,Integer> lookup = new HashMap<>();
            for (int i=requestTime.get(0); i<requestTime.get(requestTime.size()-1)+1; i++){
                int lookupValue;
                try{
                    lookupValue = lookup.get(i-1);
                } catch (Exception err){
                    lookupValue = 0;
                }
                lookup.put(i, lookupValue+count.getOrDefault(i, 0));
            }
            for (int i=3; i<requestTime.size();i++){
                int temp1=0;
                int temp2 = 0;
                    if (lookup.keySet().contains(requestTime.get(i)-10)){
                        temp1 = lookup.get(requestTime.get(i)-10);
                    }
                    if(lookup.keySet().contains(requestTime.get(i)-60)){
                        temp2 = lookup.get(requestTime.get(i)-60);
                    }
                    if (requestTime.get(i-3).equals(requestTime.get(i))){
                        requestTime.set(i-3, -1);
                    } else if (i+1 - temp1 > 20){
                        requestTime.set(i, -1);
                    } else if ( i+1 - temp2 > 60){
                        requestTime.set(i, -1);
                    }
            }
            int answer = 0;
            for(int i=0; i<requestTime.size();i++){
                if(requestTime.get(i).equals(-1)){
                    answer++;
                }
            }

            return answer;
        } catch (Error e){
            return 0;
        }
    }
}