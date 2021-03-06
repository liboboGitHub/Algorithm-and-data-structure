class Solution198 {

    // 动态规划
    // 状态转移方程：d[n+1] = max(d[n],d[n-1]+num)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }

        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 2] + nums[i], memo[i - 1]);
        }
        return memo[n - 1];

    }
}                                                                 