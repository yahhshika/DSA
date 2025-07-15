package dp6;

public class McmTab {
    public static void print2D(int[][] mat){
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int mcmTAb(int[] arr){
        int[][] dp = new int[arr.length][arr.length];
        // 0th row and 0th col will be of no use. 
        // initialization: cols with i==j will have 0. as we are multiplying the same matrices. there's no cost. 
        for(int i = 1; i<dp.length; i++){
            dp[i][i] = 0;
        }
        // int i = 1;
        // int counter = 1;
        // while(i+counter<dp.length){
        //     int j = i+counter;
        //     // main work:  dp[i][j] = dp [i][i+counter]
        //     int cost = Integer.MAX_VALUE;
        //     for(int k = i; k<j; k++){
        //         int ans1 = dp[i][k];
        //         int ans2 = dp[k+1][j];
        //         int localcost = ans1+ans2+ arr[i-1]*arr[k]*arr[j];
        //         cost = Math.min(cost, localcost); 
        //     }
        //     dp[i][j] = cost;


        //     //loop:
        //     if(j==dp[0].length-1){
        //         i = 1;
        //         counter++;
        //         continue;
        //     }
        //     i++;   
        // }

        // len represents the length of the sub-chain of matrices we're trying to multiply — i.e., the number of matrices involved in the current subproblem.
        for (int len = 2; len < arr.length; len++) { // len is the chain length
            for (int i = 1; i <= arr.length - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        print2D(dp);

        return dp[1][dp[0].length-1];

        
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        System.out.println(mcmTAb(arr));
    }
}
