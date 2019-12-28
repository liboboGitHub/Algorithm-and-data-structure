class Solution1143 {

    // 动态规划解决最长公共之序列
    public int longestCommonSubsequence(String text1, String text2) {

        // 字符串处理成字符数组
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[t1.length + 1][t2.length + 1];
        for (int i = 1; i < t1.length + 1; i++) {
            for (int j = 1; j < t2.length + 1; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }

        }
        return dp[t1.length][t2.length];

    }
    /*
    *
    * 状态转移方程
    * dp[i][j] = dp[i-1][j-1] + 1
    * 或者：dp[i][j] = Max(dp[i][j-1],dp[j-1][i])
    *
    * */
}