import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Arithmatic_Geeks {
    public static void main(String[] args) {

        Integer[] a = new Integer[]{0,4,8,16};
        Integer[] b = new Integer[]{0,2,6,12,14,20};
        Set<Integer> set = convertArrayToSet(a);
        set.addAll(Arrays.asList(b));

        System.out.println(set);
        Integer [] d = new Integer[set.size()];
        d = set.toArray(d);
        System.out.println(Solution(d));
    }
    public static <T> Set<T> convertArrayToSet(T array[])
    {

        // Create the Set by passing the Array
        // as parameter in the constructor
        Set<T> set = new HashSet<>(Arrays.asList(array));

        // Return the converted Set
        return set;
    }
    static int Solution(Integer []A)
    {
        int ans = 2;
        int n = A.length;
        if (n <= 2)
            return n;

        int []llap = new int[n];
        for(int i = 0; i < n; i++)
            llap[i] = 0;

        Arrays.sort(A);

        for (int j = n - 2; j >= 0; j--)
        {
            int i = j - 1;
            int k = j + 1;
            while (i >= 0 && k < n)
            {
                if (A[i] + A[k] == 2 * A[j])
                {
                    llap[j] = Math.max(llap[k] + 1, llap[j]);
                    ans = Math.max(ans, llap[j]);
                    i -= 1;
                    k += 1;
                }
                else if (A[i] + A[k] < 2 * A[j])
                    k += 1;
                else
                    i -= 1;
            }
        }
        return ans;
    }
}
