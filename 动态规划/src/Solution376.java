public class Solution376 {
    public int wiggleMaxLength(int[] nums) {

        /*
         *    动态规划解法
         *    分析：
         *    最终的问题可以由子问题来解决，每一步取最优解，最后的结果则是最优解，所以选取动态规划解法
         *    每一次的选择有两种状态：当前数和前一个数作差结果是正数或者是负数，分别判断，用二维数组的
         *    第二维来表示最后两个数作差的状态，1：表示正数，0：表示负数。
         *
         * */

        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        // 第一维表示当前第几个数时当前摆动数列的最大长度，这个过程是动态变化的
        int dp[][] = new int[nums.length + 1][2];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] - nums[i - 1] > 0) {
                dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] + 1);
            } else if (nums[i] - nums[i - 1] < 0) {
                dp[i + 1][0] = Math.max(dp[i][1] + 1, dp[i][0]);
            } else {
                dp[i + 1][1] = dp[i][1];
                dp[i + 1][0] = dp[i][0];
            }
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]) + 1;
    }


    // 直接深入问题本质，数列不是连续的
    public int wiggleMaxLength2(int[] nums) {

        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                up = down + 1;
            } else if (nums[i] - nums[i - 1] < 0) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }


}
