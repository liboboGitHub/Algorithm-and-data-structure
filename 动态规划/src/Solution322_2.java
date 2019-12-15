import java.util.Arrays;

public class Solution322_2 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }

        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);  // 填充数组
        dp[0] = 0;  // 初始状态
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }


        return dp[amount] > amount ? -1 : dp[amount];

    }
}
