class Solution64 {

    // 动态规划解法
    // 递推式：dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
    // 说明：自底向上，从右下角向左上角选择最优的解，一直向左上角移动(当然也可以从左上角从右下角
    public int minPathSum(int[][] grid) {
        // 辅助数组
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j != 0) {  // 这样保证两个元素是相邻的
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (i != 0 && j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (i != 0 && j != 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }

            }

        }

        return dp[grid.length - 1][grid[0].length - 1];

    }
}