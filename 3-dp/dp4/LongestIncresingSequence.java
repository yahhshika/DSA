package dp4;

import java.util.Arrays;
import java.util.HashSet;

// given an array find a sequence from in it, may or may not continuous but is increasing (ascending), return the length of it.
// array: {50,3,10,7,40,80} will have answer: 4; bcz:3,10,40,80 and 3,7,40,80 are two longest subsequences. 
public class LongestIncresingSequence {
    public static int longestInc(int[]a){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<a.length; i++){
            set.add(a[i]);
        }
        int[] sorted = new int[set.size()];
        int count = 0;
        for(Integer k : set){
            sorted[count] = k;
            count++;
        }

        int[][] dp = new int[a.length+1][sorted.length+1];
        Arrays.sort(sorted);
        // for(int i =0; i<sorted.length; i++){
        //     System.out.print(sorted[i]+" ");
        // }
        System.out.println();
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                if(a[i-1]==sorted[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        print2D(dp);
        return dp[a.length][sorted.length];
    }
    public static int longestInc1D(int[]arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i<dp.length; i++){
            for(int j = 0; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 1;
        for(int i = 0; i<dp.length; i++){
            System.out.print(dp[i]+" ");
            max = Math.max(dp[i],max);
        }
        System.out.println();
        return max;
    }

    public static void print2D(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] a = {50,3,10,7,40,80};
        System.out.println(longestInc(a));
        System.out.println(longestInc1D(a));
        
    }
    
}
