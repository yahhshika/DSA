package dp6;
//knapsack appraoch
// you are given an array, you have to divide it's elements into two sub groups such that the difference between the sum of the elements of the array is minimum. you hsve ti return the min diff. 

// why knapsack? 
//if the difference is supposed to be min. then in both the subgroups the sum should be approaximately equal to the half of the sum of elements of the parent array. 
//so consider a knapsack that is to be filled with a maximum capacity of sum/2 weight with the given elements in the parent element. 
//if an element doesnt count in the first knapsack then the element will be present in the second. 
public class MiniPartitioning {
    public static void print2D(int[][] mat){
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int getMinDiff(int[]arr){
        int sum = 0;
        for(int i =0; i<arr.length; i++){
            sum+=arr[i];
        }
        int weight = sum/2;
        int getWeightOfSet1 = knapsackTab(arr, weight);
        int weightofSet2 = sum - getWeightOfSet1;
        int ans = Math.abs(weightofSet2-getWeightOfSet1);
        System.out.println(getWeightOfSet1);
        System.out.println(weightofSet2);
        return ans; 
    }
    public static int knapsackTab(int [] arr, int weight){
        int[][] dp = new int[arr.length+1][weight+1];
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        //tabulation:
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                if(arr[i-1]<=j){ //valid
                    int incProfit = arr[i-1] + dp[i-1][j-arr[i-1]];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print2D(dp);
        return dp[arr.length][weight];
    }

    public static void main(String[] args) {
        int arr[] = {1,6,11,15};
        System.out.println(getMinDiff(arr));

    }
}