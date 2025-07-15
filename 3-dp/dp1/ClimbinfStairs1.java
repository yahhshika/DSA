// import java.util.Arrays;

public class ClimbinfStairs1 {
    public static int climbRecur(int n){
        return climbRecurUtil(0, n);
    }
    public static int climbRecurUtil(int start, int end){
        if(start> end){
            return 0;
        }if(start==end){
            return 1;
        }
        return climbRecurUtil(start+1, end) +climbRecurUtil(start+2, end);

    }

    public static int climbMemoisation(int n){
        int[] dp = new int[n+1];
        // for(int i = 0; i<dp.length; i++){
        //     dp[i]=-1;
        // }
        return climbMemoisationUtil(n, dp);

    }
    public static int climbMemoisationUtil(int n, int[] dp){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = climbMemoisationUtil(n-1, dp) + climbMemoisationUtil(n-2, dp);
        return dp[n];
        

        
    }
    public static int climbTabulation(int n){
        int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<dp.length; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
    



    public static void main(String[] args) {
        System.out.println((climbTabulation(7)));
        System.out.println((climbRecur(7)));
        System.out.println((climbMemoisation(7)));
        
    }
}