package dp3;
// given  a rod of length n inches and an array of prices that includes price of all pieces size smaller than n. Determine the maximum value obtainable by cutting up the rod into those smaller pieces and selling them. 
public class RodCutting {
    public static void print2D(int[][] mat){
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int maxProfit(int prices[], int sizes[], int rod){
        int[][] dp = new int[sizes.length+1][rod+1];
        
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                int curRod = j;
                int curSize = sizes[i-1];
                int curPrice = prices[i-1];
                if(curSize<=curRod){
                    int incProfit = curPrice + dp[i][j-curSize];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print2D(dp);
        return dp[sizes.length][rod];
    }
    public static void main(String[] args) {
        int sizes[] = {1,2,3,4,5,6,7,8};
        int prices[] = {1,5,8,9,10,17,17,20};
        int rod = 8;
        System.out.println(maxProfit(prices, sizes, rod));
        

    }
    
}
