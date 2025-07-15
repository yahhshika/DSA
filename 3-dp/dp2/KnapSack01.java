package dp2;
public class KnapSack01{
    public static int knapsackRecu(int[] wt, int[] val, int n, int w){
        if(n == 0 || w==0){
            return 0;
        }
        else if(wt[n-1]<=w){ // valid
            int incProfit = val[n-1] + knapsackRecu(wt, val, n-1, w-wt[n-1]);
            int excProfit = knapsackRecu(wt, val, n-1, w);
            return Math.max(incProfit, excProfit);
        }
        else{ //invalid
            return knapsackRecu(wt, val, n-1, w);
        }
    }
    public static int knapsackMemo(int[] wt, int[] val, int w){
        int memo[][] = new int[val.length+1][w+1];
        for(int i = 0; i<memo.length; i++){
            for(int j = 0; j<memo[i].length; j++){
                if(i == 0){
                    memo[i][j] = 0;
                    continue;
                }
                if(j == 0){
                    memo[i][j] = 0;
                    continue;
                }
                memo[i][j] = -1;
            }
        }
        
        return knapsackMemoUtil(wt, val, w, val.length, memo);
    }
    public static int knapsackMemoUtil(int[]wt, int[] val, int w, int n, int[][] memo){
        if(n == 0 || w == 0){
            return 0;
        }
        if(memo[n][w]!=-1){
            return memo[n][w];

        }
        else if(wt[n-1]<=w){
            // incProfit = mereko dal lo aur fir bche kuche weight ko n-1 items se bhar do i.e meri profit value mai bche kuche items ko dalne k bad jo profit ayega use add krlo 
            int incProfit = val[n-1] + knapsackMemoUtil(wt, val, w-wt[n-1], n-1, memo);
            // excProfit = nth dalo hi mt n-1 items ka best combination dalo aur profit nikalo
            int excProfit = knapsackMemoUtil(wt, val, w, n-1, memo);
            memo[n][w] = Math.max(incProfit, excProfit);
            return memo[n][w];

        }else{
            memo[n][w] = knapsackMemoUtil(wt, val, w, n-1, memo);
            return memo[n][w];
        }

    }

    // i => number of items
    // maximum weight for each iteration
    // dp[i][j] ,sa 'dp[2][3]' for an array of weight{2,4,7,6} means kya mai first 2 items of weight(2,4) ko use krke 3 weight k knapsack ko bhar skti hu with some max profit? toh answe it yes mai 3 units of knapsack mai 2units dal skti hu jiska koi given profit hoga in val[] array.
    public static int knapsackTab(int[] wt, int[] val, int w){
        int[][] dp = new int[val.length+1][w+1];
        for(int i =0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j =0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                int curWt = j;
                int curVal = val[i-1];
                if(wt[i-1]<=curWt){
                    int incProfit = curVal + dp[i-1][curWt-wt[i-1]];
                    int excProfit = dp[i-1][curWt];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{
                    dp[i][j] = dp[i-1][curWt];
                }
            }
        }
        print2D(dp);
        return dp[val.length][w];
    }
    public static void print2D(int[][] mat){
        for(int i =0; i<mat.length; i++){
            for(int j = 0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int w = 7;
        int n = val.length;
        System.out.println(knapsackRecu(wt, val, n, w ));
        System.out.println(knapsackMemo(wt, val, w));
        System.out.println(knapsackTab(wt, val, w));
    }
}