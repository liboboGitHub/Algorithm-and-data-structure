
/*
 * 0-1背包问题的递归解法（含记忆化搜索）
 * */

public class knapsack01 {
    public int knapsack(int[] wight, int[] value, int Capacity) {

        if (wight == null) {
            return 0;
        }
        int n = wight.length;
        int[][] memo = new int[n][Capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Capacity + 1; j++) {
                memo[i][j] = -1;
            }

        }

        return bestValue(wight, value, memo, Capacity, n - 1);

    }

    private int bestValue(int[] wight, int[] value, int[][] memo, int capacity, int index) {
        // 终止条件
        if (index < 0 || capacity <= 0) {
            return 0;
        }

        if (memo[index][capacity] != -1) {
            return memo[index][capacity];
        }

        int res = bestValue(wight, value, memo, capacity, index - 1);   // 这是一种状态，跟下面的状态没有关系，注意理解，这里很容易理解错误
        if (capacity >= wight[index]) {
            res = Math.max(res, (value[index] + bestValue(wight, value, memo, capacity - wight[index - 1], index - 1)));
        }

        memo[index][capacity] = res;

        return res;
    }

}
