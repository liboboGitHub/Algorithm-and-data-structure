import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution90 {
    // 子集2
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        // 不能包含重复的组合,所以在这里必须排序
        Arrays.sort(nums);

        generationsubsetsWithDup(nums, list, 0);  // 注意一点：如果传一个参数来保证不再重复，就不用布尔型的数组来保存访问过的值
        return lists;

    }

    private void generationsubsetsWithDup(int[] nums, List<Integer> list, int start) {
        // 递归结束条件
        if (list.size() <= nums.length) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { // 剔除相同的数作为节点的情况（i>start为了防止越界）
                continue;  // 进行下一次循环
            }
            list.add(nums[i]);
            generationsubsetsWithDup(nums, list, start + 1);
            // 回溯
            list.remove(list.size() - 1);
        }

    }
}