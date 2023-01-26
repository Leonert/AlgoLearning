package l01;

import java.util.Arrays;

public class Fibonacci {
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public static void main(String[] args) {
        int fib = 40;
        long time = System.currentTimeMillis();
        System.out.println(fib(fib + 1));
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        System.out.println(fibR(fib + 1));
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        System.out.println(fibb(fib));
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        System.out.println(fibS(fib));
        System.out.println(System.currentTimeMillis() - time);
    }

    public static int fibS(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return fibS(n - 2) + fibS(n - 1);
    }

    public static int fib(int n) {
        int[] fib = new int[n];
        if (n > 0) fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }

    //n = 5, current = 1
    private static int fibR(int n, int current, int[] arr) {
        arr[current] = arr[current - 1] + arr[current - 2];
        if (current == n - 1) return arr[current];
        return fibR(n, current + 1, arr);
    }

    public static int fibR(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] arr = new int[n];
        arr[1] = 1;
        return fibR(n, 2, arr);
    }

    public static int fibb(int n) {
        //1. recursion
        // if(n==1 || n==0)return n;
        // return fib(n-1) + fib(n-2);

        //2. Top-down :- memoization
        // int dp[] = new int[n+1];
        // for(int i=0; i<n+1; i++)
        //     dp[i]=-1;
        // return memo(n,dp);

        //3. Bottom-up :- dp
        return dp(n);
    }
    public static int memo(int n, int dp[]){
        if(n==1 || n==0)return n;
        if(dp[n]!=-1)return dp[n];
        dp[n]=memo(n-1,dp) + memo(n-2,dp);
        return dp[n];
    }
    public static int dp(int n){
        if(n==0)return 0;
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2; i<=n; i++)
            dp[i]=dp[i-1]+dp[i-2];

        return dp[n];
    }
}
