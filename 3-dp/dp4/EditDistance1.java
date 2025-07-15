package dp4;
// you're given two strings s1 and s2, and three edit operations: delete add and replace. you have to these operations on S1 to convert it to s2. return min number of operations required. 
public class EditDistance1 {
    public static int editDistTab(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        //initialization
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j<dp[0].length; j++){
            dp[0][j] = j;
        }
        print2D(dp);
        System.out.println("=====");
        // tabulation :
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }

                else{
                    // if i perform add:
                    int add = dp[i][j-1]+1;
                    int delete = dp[i-1][j]+1;
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j] =Math.min(replace, Math.min(add, delete));

                }
            }
        }
        print2D(dp);
        return dp[s1.length()][s2.length()];
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
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(editDistTab(s1, s2));
    }
}
