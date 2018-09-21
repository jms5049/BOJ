import java.util.*;

public class p14888 {
    static int N;
    static int[] numbers;
    static int[] operations;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        operations = new int[4];
        
        for(int i = 0; i < N ; i++) {
            numbers[i] = sc.nextInt();
        }
        
        for(int i = 0; i < 4; i++) {
            operations[i] = sc.nextInt();
        }
        

        dfs(operations[0],operations[1],operations[2],operations[3],1,numbers[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int plus,int minus, int mult, int div, int depth, int sum) {
        // TODO Auto-generated method stub
        
        if(depth == N) {
            if(sum > MAX)
                MAX = sum;
            if(sum < MIN)
                MIN = sum;
            return;
        }
        
      //plus
        if (plus > 0)           
        {
            int temp = 0;
            temp = sum + numbers[depth];

            dfs(plus - 1, minus, mult, div, depth + 1, temp);
        }

        //minus
        if (minus > 0)
        {
            int temp = 0;
            temp = sum - numbers[depth];

            dfs(plus, minus - 1, mult, div, depth + 1, temp);

        }

        //mult
        if (mult > 0)
        {
            int temp = 0;
            temp = sum * numbers[depth];

            dfs(plus, minus, mult - 1, div, depth + 1, temp);
        }

        //div
        if (div > 0)
        {
            int temp = 0;
            temp = sum / numbers[depth];

            dfs(plus, minus, mult, div - 1, depth + 1, temp);
        }
               
        
    }

}
