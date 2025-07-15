package dp5;

public class WildCardMatching {
    public static boolean isPatternMatched(String s, String pattern){
        boolean[][] dp = new boolean[s.length()+1][pattern.length()+1];
        // initialization:
        // initialize the first col:
        for(int i = 0; i<dp.length; i++){
            if(i==0){
                dp[i][0] = true;
                continue;
            }
            dp[i][0] = false;
        }
        // initialize the first row:
        for(int j = 1; j<dp[0].length; j++){
            if(pattern.charAt(j-1)=='*'){
                dp[0][j] =dp[0][j-1];
            }
        }

        // tabulation:
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                if(s.charAt(i-1)==pattern.charAt(j-1) || pattern.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pattern.charAt(j-1)=='*'){
                    boolean matchWithEmptyString = dp[i][j-1];
                    boolean matchWithCurrentChar = dp[i-1][j];
                    dp[i][j] = matchWithCurrentChar || matchWithEmptyString;
                    continue;
                }else{
                    dp[i][j] = false;
                }
                
            }
        }
        print2D(dp);
        return dp[s.length()][pattern.length()];

    } 
    public static void print2D(boolean[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String s = "cabef";
        String pattern = "?ab*";
        System.out.println(isPatternMatched(s, pattern));
        
    }
}
