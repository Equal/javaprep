public class fib {

    static long[] fibResults;
    public static void main(String[] args)
    {
        int n = 50;
        //System.out.println(fibRecursive(n));

        fibResults = new long[n+1];
        fibResults[0] = 1;
        fibResults[1] = 1;
        System.out.println(fibMemoization(n));
    }

    //I think the O(n) for fibRecursive is 2^n, since every call to fibRecursive results in two more calls to it, and it starts with n
    private static int fibRecursive(int n)
    {
        if (n == 1 || n == 0)
        {
            return 1;
        }
        else
        {
            return fibRecursive(n-1) + fibRecursive(n-2);
        }
    }

    private static long fibMemoization(int n)
    {
        if (fibResults[n] != 0)
        {
            return fibResults[n];
        }
        else
        {
            fibResults[n] = fibMemoization(n-1) + fibMemoization(n-2);
            return fibResults[n];
        }
    }
}
