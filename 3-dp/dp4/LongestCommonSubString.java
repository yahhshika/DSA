package dp4;

public class LongestCommonSubString {
    static class Info{
        int data; 
        boolean isSub; 
        Info(int data, boolean isSub){
            this.data = data;
            this.isSub = isSub;
        }
    }
    public static int lcsTab(String s1, String s2){
        Info[][] dp = new Info[s1.length()+1][s2.length()+1];
        // init: dp[0s][0s]=> Info(0, true)
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = new Info(0, true);
        }
        for(int i = 0; i<dp[0].length; i++){
            dp[0][i] = new Info(0, true);
        }

        // main tabulation:
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                char cur1 = s1.charAt(i-1);
                char cur2 = s2.charAt(j-1);
                if(cur1==cur2 && dp[i-1][j-1].isSub){
                    int data = 1+ dp[i-1][j-1].data;
                    dp[i][j] = new Info(data, true);
                } else{
                    int data = Math.max(dp[i-1][j].data, dp[i][j-1].data);
                    dp[i][j] = new Info(data, false);
                }
            }
        }
        // print2D(dp);
        return dp[s1.length()][s2.length()].data;
    }
    public static void print2D(int[][] mat){
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int lcsTab2(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int counter = 0;
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    counter = Math.max(counter, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }

        }
        print2D(dp);
        return counter;
    }
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(lcsTab(s1, s2));
        System.out.println(lcsTab2(s1, s2));
        
    }
}
