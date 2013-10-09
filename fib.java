public class fib {

    public static void main(String[] args)
    {
        System.out.println(fibRecursive(50));
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
}
