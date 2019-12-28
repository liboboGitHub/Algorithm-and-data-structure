

// 使用记忆化搜素的方式解决最长公共子序列
public class Solution1143_2 {
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text2 == null) {
            return 0;
        }
        return generation(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    private int generation(String text1, String text2, int m, int n) {

        if (m < 0 || n < 0) {
            return 0;
        }

        int res = 0;
        int[][] memo = new int[m + 1][n + 1];
        if (memo[m][n] != 0) {
            return memo[m][n];
        }

        if (text1.charAt(m) == text2.charAt(n)) {
            res = generation(text1, text2, m - 1, n - 1) + 1;
            memo[m][n] = res;
        } else {
            return Math.max(generation(text1, text2, m - 1, n), generation(text1, text2, m, n - 1));
        }

        return memo[m][n];

    }
}
