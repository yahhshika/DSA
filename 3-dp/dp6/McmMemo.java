package dp6;

public class McmMemo {
    public static int mcmMemo(int[] arr, int i, int j, int [][]dp){
        if(i == j){
            return 0;
        }
        if(dp[i-1][j-1]!=0){
            return dp[i-1][j-1];
        }
        int cost = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int ans1 = mcmMemo(arr, i, k, dp);  // arr[i-1] x arr[k]
            int ans2 = mcmMemo(arr, k+1, j, dp); // arr[k] x arr[j]
            int tempCost = ans1 + ans2 + arr[i-1]*arr[k]*arr[j];
            cost = Math.min(tempCost, cost);
        }
        return dp[i-1][j-1] = cost;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,3};
        int[][] dp = new int[arr.length-1][arr.length-1];
        //   0 1 2 3 
        // 0                (0,0) means multiplication of matrices from 0+1  to 0+1 that is from 1 to 1
        // 1 
        // 2                (2,3) means multiplication of matrices from 3 to 4
        // 3
        // answer will be stored at 0,3 they will represent the multiplication of matrices from 1 to 4. 
        // some concepts: cost to multiply mXn and nXc matrices = m*n*c
        // here arr represents the rows and cols of a matrix: 
        // [1 , 2 , 3 , 4 , 3 ]
        // [  A1, A2, A3, A4  ]
        // A1= 1 X 2, A2 = 2 X 3, A3 = 3 X 4, A4 = 4X3 
        // Aith = arr[i-1] x arr[i]
        // cost(Aith * Ajth) = arr[i-1]*arr[i]*arr[j]
        // if i multiply 1X2 and 2X3 then final will have 1X3, similarly:
        // rows X cols of a matrix formed by multiplying Ai-------An matrices (where i goes from 1 to n)= arr[i]*arr[n]; (as: ith will have arr[i-1]x arr[i] and nth will have arr[n-1]Xarr[n] dimensions);
        System.out.println(mcmMemo(arr, 1 , arr.length-1, dp));
    }
}
