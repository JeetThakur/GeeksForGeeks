import java.util.*;
public class Exactly3Divisors {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0)
        {
            Divisors obj=new Divisors();
            int N;
            N=sc.nextInt();

            System.out.println(obj.exactly3Divisors(N));


        }

    }
}

class Divisors
{
    public boolean isPrime(int n) {
        if (n==2 || n==3){
            return true;
        }
        if (n%2==0)
            return false;
        if (n%3==0)
            return false;
        for (int i = 5; i*i<=n; i=i+6){
            if (n%i==0)
                return false;
            if (n%(i+2)==0)
                return false;
        }
        return true;
    }

    public int exactly3Divisors(int N)
    {
        // Check for only numbers that have a perfect square less than the number itself
        // Once such a number is found then check if it is Prime if yes update counter
        int counter = 0;
        for(int i=2; i*i<=N; i++){
            if(isPrime(i))
                counter++;
        }
        return counter;
    }
}
