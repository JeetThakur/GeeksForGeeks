import java.util.*;
import static java.util.Arrays.asList;


public class IPO_New_Citadel {

    public static void main(String[] args) {
        List<List<Integer>> bids = asList(asList(1, 2, 5, 0), asList(2, 1, 4, 2), asList(3, 5, 4, 6));
        int totalShares = 3;
        List<Integer> ans = getUnalottedUsers(bids, totalShares);
        for(int i=0; i< ans.size(); i++){
            System.out.println(ans.get(i));
        }

    }


    public static List<Integer> helper(List<List<Integer>> bids, Map<Integer, Integer> shares_recieved) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> eachList : bids) {
            if (!shares_recieved.keySet().contains(eachList.get(0))) {
                result.add(eachList.get(0));
            }
        }
       // Sort the result
        Collections.sort(result);
        return result;
    }

    public static List<Integer> getUnalottedUsers(List<List<Integer>> bids, int totalShares) {
        Collections.sort(bids, new valueSorter());
        Collections.sort(bids, new secondValueSorter());

        Map<Integer, Integer> shares_recieved = new HashMap<>();
        for (int i = 0; i < bids.size(); i++) {
            if (totalShares > 0) {
                if (bids.get(i).get(2) > bids.get(i + 1).get(2)) {
                    if (totalShares < bids.get(i).get(1)) {
                        shares_recieved.put(bids.get(i).get(0), 1);
                        // Return statement in python
                        return helper(bids, shares_recieved);
                    } else {
                        totalShares -= bids.get(i).get(1);
                        shares_recieved.put(bids.get(i).get(0), 1);
                    }
                } else {
                    int sum_req = bids.get(i).get(1);
                    int end = i;
                    for (int j = i; j < bids.size(); j++) {
                        if(j+1 < bids.size()){
                            end = j;
                        if (bids.get(j).get(2).equals(bids.get(j + 1).get(2))) {
                            sum_req += bids.get(j + 1).get(1);
                            continue;
                        } else {
                            break;
                        }
                        }
                    }
                    if (totalShares < end - i) {
                        for (int k = i; k < bids.size(); k++) {
                            if (totalShares > 0) {
                                shares_recieved.put(bids.get(k).get(0), 1);
                                totalShares -= 1;
                            } else {
                                // Return statement
                                return helper(bids, shares_recieved);
                            }

                        }
                    } else if (totalShares > sum_req) {
                        for (int x = i; x < end + 1; x++) {
                            shares_recieved.put(bids.get(x).get(0), 1);
                        }
                        totalShares -= sum_req;

                    } else {
                        for (int x = i; x < end + 1; x++) {
                            shares_recieved.put(bids.get(x).get(0), 1);
                        }
                        // Return statement
                        return helper(bids, shares_recieved);

                    }
                }
            } else {
                return helper(bids, shares_recieved);
            }
        }

        return new ArrayList<>();

    }


    static class valueSorter implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            if (o2.get(3).equals(o1.get(3)))
                return o1.get(3) - o2.get(3);
            return 0;
        }
    }

    static class secondValueSorter implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o2.get(2) - o1.get(2);
        }
    }
}