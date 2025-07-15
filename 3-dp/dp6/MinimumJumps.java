package dp6;

public class MinimumJumps {
    public static int jumps(int arr[]){
        int[] dp = new int[arr.length];
        dp[dp.length-1] = 0;
        for(int i = dp.length-2; i>=0; i--){
            System.out.println("i: "+i);
            int jumps = Integer.MAX_VALUE;
            for(int j = 1; j<=arr[i] && j<=dp.length-1-i; j++){
                System.out.print("j: "+j);
                System.out.print(" dp[i+j]: "+dp[i+j]);

                jumps = Math.min(jumps, 1+dp[i+j]);
                System.out.println("jumps: "+jumps);
            }
            dp[i] = jumps;
            System.out.println("====");
        }
        System.out.println("-----------");
        for(int i = 0; i<dp.length; i++){
            System.out.println(dp[i]+" ");
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,1,4};
        //we have to reach from 0th to (n-1)th, moves at ith = arr[i],eg from 0th you can either go to 3 or 1.  
        System.out.println(jumps(arr)); 
        
    }
}
