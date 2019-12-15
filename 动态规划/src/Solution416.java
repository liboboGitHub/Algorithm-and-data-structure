/*
 * 使用记忆化搜素实现
 *
 * */
class Solution416 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

        }
        if (sum % 2 != 0) {
            return false;
        }
        int[][] memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < sum / 2 + 1; j++) {
                memo[i][j] = -1;
            }

        }
        return tryCanPartition(nums, nums.length - 1, sum / 2, memo);

    }

    private boolean tryCanPartition(int[] nums, int index, int capacity, int[][] memo) {
        if (capacity == 0) {
            return true;
        }
        if (capacity < 0 || index < 0) {
            return false;
        }
        if (memo[index][capacity] != -1) {
            return memo[index][capacity] == 1;
        }
        memo[index][capacity] = (tryCanPartition(nums, index - 1, capacity, memo) ||
                tryCanPartition(nums, index - 1, capacity - nums[index], memo)) ? 1 : 0;

        return memo[index][capacity] == 1;

    }
}