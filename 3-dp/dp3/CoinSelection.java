package dp3;
// this is a variation of unbounded knapsack 
public class CoinSelection { //try it with 1D array
    public static int coinTab(int[] coin, int value){
        int[][] dp = new int[coin.length+1][value+1];
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                int curVal = j;
                int curcoin = coin[i-1];
                if(curcoin<=curVal){
                    int incCoin = dp[i][j-curcoin];
                    int excCoin = dp[i-1][j];
                    dp[i][j] = incCoin+excCoin;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print2D(dp);
        return dp[coin.length][value];

    }
    public static void print2D(int[][] mat){
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        // int coin[] = {2,5,3,6};
        // int val = 10;
        int coin[] = {1,2,3};
        int val = 4;
        System.out.println(coinTab(coin, val));

    }
    
}
