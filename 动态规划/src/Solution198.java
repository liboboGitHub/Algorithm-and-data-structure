class Solution198 {

    // 1.记忆化搜索
//    public int rob(int[] nums) {
//        int size = nums.length;
//        int[] memo = new int[size];
//        for (int i = 0; i < size; i++) {
//            memo[i] = -1;
//        }
//
//        return tryRob(nums, 0, memo);
//
//    }
//
//
//    private int tryRob(int[] nums, int index, int[] memo) {
//        if (index >= nums.length) {
//            return 0;
//        }
//        if (memo[index] != -1) {
//            return memo[index];
//        }
//        int res = 0;
//        for (int i = index; i < nums.length; i++) {
//            res = Math.max(res, nums[i] + tryRob(nums, i + 2, memo));
//        memo[index] = res;
//
//        return res;
//
//    }

    // 2.动态规划
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }

        memo[n - 1] = nums[n - 1];  // 初始状态
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max((j + 2 < n ? memo[j + 2] : 0) + nums[j], memo[i]);  // 保持当前状态下肯定是最优的
            }

        }
        return memo[0];

    }
}                                                                 