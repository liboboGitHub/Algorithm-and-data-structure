/*
 *使用动态规划来解决0-1背包问题
 * */
public class knapsack01_2 {

    public int knapsack(int[] wight, int[] value, int Capacity) {
        if (wight == null || value == null) {
            return 0;
        }
        int n = wight.length;
        int[][] memo = new int[2][Capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Capacity + 1; j++) {
                memo[i][j] = -1;
            }

        }
        assert (wight.length == value.length);

        // 初始化子问题（选取第一个物品之后，在不同的背包容量情况下所获得的总价值）
        for (int j = 0; j <= Capacity; j++) {
            memo[0][j] = (j >= wight[0] ? value[0] : 0);
        }

        // 自底向上
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= Capacity; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];  // 第一种策略，最后一个物品不放入背包
                if (wight[i] <= j) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], value[i] + memo[(i - 1) % 2][j - wight[i]]);
                }

            }

        }
        return memo[(n - 1) % 2][Capacity];

    }
}
