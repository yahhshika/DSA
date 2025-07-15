package dp2;

public class UnboundedKnap {
    public static int unboundedTab(int[] val, int[] wt, int w){
        int[][] dp = new int[val.length+1][w+1];
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                int curWt = j;
                int curVal = val[i-1];
                if(curWt>=wt[i-1]){
                    int incProfit = curVal+dp[i][j-wt[i-1]];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit) ;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print2D(dp);
        return dp[val.length][w];
        
    }
     public static void print2D(int[][] mat){
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int w = 7;
        System.out.println(unboundedTab(val, wt, w)); 

        
    }
}
