package dp3;
// WHY 2 POINTER APPRAOCH FAILS IN LCS: 

// str1 = "abc"
// str2 = "bac"
// The LCS is "ac", but a two-pointer approach would:

import java.util.Arrays;

// Compare 'a' and 'b' → not equal

// Move pointer

// Miss valid subsequences like 'ac'

// So you’d miss better matches if you're just advancing linearly.

// LONGEST COMMON SUBSEQUENCE:

public class LCS {
    public static int lcsTab(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                char cur1 = s1.charAt(i - 1);
                char cur2 = s2.charAt(j - 1);
                if (cur1 == cur2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
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

    public static int lcsRecur(String s1, String s2, int n1, int n2) {
        if (n1 <= 0 || n2 <= 0) {
            return 0;
        }
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return 1 + lcsRecur(s1, s2, n1 - 1, n2 - 1);
        } else {
            return Math.max(lcsRecur(s1, s2, n1 - 1, n2), lcsRecur(s1, s2, n1, n2 - 1));
        }
    }

    public static int lcsMemo(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // or any value you want
        }
       int result =  lcsMemoUtil(s1, s2, s1.length(), s2.length(), dp);
       print2D(dp);
       return result;

    }

    public static int lcsMemoUtil(String s1, String s2, int n1, int n2, int[][] dp){
        if(n1<=0 || n2<=0){
            return 0;
        }
        if(dp[n1][n2]!=-1){
            return dp[n1][n2];
        }
        if(s1.charAt(n1-1)==s2.charAt(n2-1)){
            dp[n1][n2] = 1+ lcsMemoUtil(s1, s2, n1-1, n2-1, dp);
            return dp[n1][n2];
        }
        else{
            dp[n1][n2] = Math.max(lcsMemoUtil(s1, s2, n1-1, n2, dp), lcsMemoUtil(s1, s2, n1, n2-1, dp));
            return dp[n1][n2]; 
        }
    }

    public static void main(String[] args) {
        String s1 = "ace";
        String s2 = "abcde";
        // String s1 = "abc";
        // String s2 = "bac";
        System.out.println(lcsTab(s1, s2));
        System.out.println(lcsRecur(s1, s2, s1.length(), s2.length()));
        System.out.println(lcsMemo(s1, s2));

    }
}
