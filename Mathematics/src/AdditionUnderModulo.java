import java.io.*;
import java.lang.*;

public class AdditionUnderModulo {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] str = read.readLine().trim().split(" ");
            long a = Long.parseLong(str[0]);
            long b = Long.parseLong(str[1]);
            System.out.println(new Modulo().sumUnderModulo(a, b));
        }
    }
}

class Modulo {
     long sumUnderModulo(long a, long b) {
        int M = 1000000007;
        // Your code here, return sum of a and b
        // This is the destructuring of the addition under modulo (a+b)% m = (a % m + b % m)% m The formula is utilized
        return (a % M + b % M) % M;
     }
}
