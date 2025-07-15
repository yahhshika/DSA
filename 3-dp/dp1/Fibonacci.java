public class Fibonacci {
    public static int fibonacci(int n , int[] fib){
        System.out.println("working on: "+n);
        if(n == 0 || n==1){
            return n;
        }
        if(fib[n]!=0){
            return fib[n];
        }
        fib[n] = fibonacci(n-1, fib)+fibonacci(n-2, fib);
        return fib[n];
    }

    public static void main(String[] args){
        int n = 32;
        System.out.println(fibonacci(n, new int[n+1]));

    }
}
