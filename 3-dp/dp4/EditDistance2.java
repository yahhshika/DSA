package dp4;
// very similar to edit distance1 but this time you have just two operations: delete and add (replace not allowed)
// logic : for two strings find lcs, the length of lcs is the length that remains unchanged in string S1(which is to be converted). 
// s1 : abcdef s2: afcge, lcs is a-c-e (length: 3) we'll have to delete the others (length of s1 - 3) and we have to add the one letters from s2 (i.e. f-g) which are absent in s1 that is (length of s2 - 3) 
// finally number of operations required: total add operations + total delete operations
// (length of s1 - lcs length) + (length of s2 - lcs length)
public class EditDistance2 {
    public static int getlcsTab(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i =1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1; 
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static int editDistTab(String s1, String s2){
        int lcsLen = getlcsTab(s1, s2); 
        int totalDel = s1.length() - lcsLen; 
        int totalAd = s2.length() - lcsLen; 
        return totalAd + totalDel; 
    }
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "afcge"; 
        System.out.println(editDistTab(s1, s2));    
    }
}