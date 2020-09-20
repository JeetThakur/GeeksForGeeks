import java.util.Arrays;

public class monotonic_Robinhood {
    static int[] num = {10,10,10};

    public static void main(String[] args) {
        int[] answer = new int[num.length-2];
        Arrays.fill(answer,-1);

       // boolean flag = true;
        for (int i=0; i<answer.length; i++){
            // 1 check to monotonic
            if (num[i+1]>num[i]){
                // second check if false make flag as downward and make i=0
                if (num[i+2]>num[i+1])
                    answer[i]=1;
                else
                    answer[i]=0;
            } else if (num[i+1]<num[i]) {
                    if (num[i+2]<num[i+1])
                        answer[i] = 1;
                    else
                        answer[i] = 0;
            } else
                answer[i] = 0;
        }
        for (int i=0; i<answer.length; i++)
            System.out.println(answer[i]);
    }
}
