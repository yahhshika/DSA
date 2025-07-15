package dp2;

public class TargetSum {
    public static void print2D(boolean[][] mat){
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean targetSumTab(int val[], int target){
        boolean[][] dp = new boolean[val.length+1][target+1];
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = true;
                            
        }
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                int curTar = j;
                int curWt = val[i-1];
                if(curTar>=curWt){
                    
                    dp[i][curTar]= dp[i-1][curTar-curWt] || dp[i-1][curTar];

                }else{
                    dp[i][curTar] = dp[i-1][curTar];
                }
            }
        }
        print2D(dp);
        
        return dp[val.length][target];
    }
    public static void main(String[] args) {
        int val[] ={4,2,7,1,3};
        int target = 10;
        System.out.println(targetSumTab(val, target)); 
        
    }
}
