// number of stairs allowed to climb to reach nth level: 1,2 or 3 

import java.util.Arrays;

public class ClimbingStairss2 {
    public static int climbMemoisation(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return climbMemoisationUtil(n, dp);


    }
    public static int climbMemoisationUtil(int n, int[] dp){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = climbMemoisationUtil(n-1, dp)+climbMemoisationUtil(n-2, dp)+ climbMemoisationUtil(n-3, dp);
        return dp[n];

    }
    public static void main(String[] args) {
        System.out.println(climbMemoisation(5));
        
    }
    
}
