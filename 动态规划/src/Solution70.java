class Solution70 {
    public int climbStairs(int n) {

        return res(n);
    }


    // 解法1：普通递归解法
    private int res1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return res1(n - 1) + res1(n - 2);

    }

    // 解法2：记忆化递归解法
    private int res2(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] == -1) {
            memo[n] = res2(n - 1, memo) + res2(n - 2, memo);
        }
        return memo[n];

    }

    // 解法3：动态规划法
    private int res(int n) {
        int[] m = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        m[1] = 1;
        m[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            m[i] = m[i - 1] + m[i - 2];
        }
        return m[n];
    }
}