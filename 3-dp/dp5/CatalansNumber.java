package dp5;

public class CatalansNumber {
    public static int catalanRecur(int n){
        if(n==0 || n==1){
            return 1;
        }
        int cn = 0;
        for(int i = 0; i<n; i++){
            cn += catalanRecur(i)*catalanRecur(n-i-1);

        }
        return cn;
    }
    public static int catalanMemo(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return catalanMemoUtil(n, dp);
    }
    public static int catalanMemoUtil(int n, int[]dp){
        // if(n ==1 || n==0){
        //     return 1;
        // }
        if(dp[n]!=0){
            return dp[n];
        }

        for(int i = 0; i<n; i++){
            dp[n] += catalanMemoUtil(i, dp)*catalanMemoUtil(n-i-1, dp);
        }
        return dp[n];

    }
    public static int catalanTab(int n ){
        if(n == 1 || n == 0){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for( int i = 2; i<=n; i++){
            for(int j = 0; j<i; j++){
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        for(int i = 0 ; i<dp.length; i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        return dp[n];
    }
    public static void main(String[] args) {
        // System.out.println(catalanRecur(30));
        System.out.println(catalanMemo(5));
        System.out.println(catalanTab(5));

    }
}
// the exact same code is used to find number of bst formed using n numbers. 
// the exact same code is used to find number of mou