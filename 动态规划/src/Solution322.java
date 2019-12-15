import org.omg.PortableInterceptor.INACTIVE;

/*
 *
 *记忆化化搜索
 *
 * */
class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount == 0) {
            return -1;
        }
        return coinChanges(coins, new int[amount], amount);

    }

    private int coinChanges(int[] coins, int[] memo, int amount) {
        if (amount < 0) {
            return -1;

        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;   // 初始化最小值
        for (int coin : coins) {
            int res = coinChanges(coins, memo, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];


    }
}