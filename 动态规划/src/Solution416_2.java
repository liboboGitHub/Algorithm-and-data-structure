import java.util.Arrays;

/*
 * 使用递归实现
 *
 * */
public class Solution416_2 {

    // 辅助操作--翻转数组
    private void reverse(int[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }

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

        sum = sum / 2;
        Arrays.sort(nums);
        reverse(nums);

        return trycanPartition(nums, sum, 0);


    }

    private boolean trycanPartition(int[] nums, int sum, int index) {
        if (index >= nums.length || nums[index] > sum) {
            return false;
        }
        if (nums[index] == sum) {
            return true;
        }

        // 每次都有选和不选两种情况
        return  trycanPartition(nums, sum - nums[index], index + 1) || trycanPartition(nums, sum, index + 1);

    }


}
