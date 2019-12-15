/*
 * 使用动态规划实现
 *
 * */
public class Solution416DP {
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

        boolean[] memo = new boolean[sum / 2 + 1];
        memo[0] = true;
//        for (int i = 0; i < sum / 2 + 1; i++) {
//            memo[i] = (nums[0] == i);
//        }

        int c = sum / 2;
        for (int i = 1; i < nums.length; i++) {
            for (int j = c; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }

        }
        return memo[c];


    }


}
