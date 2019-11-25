import java.util.ArrayList;
import java.util.List;

class Solution78 {
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        generationSubsets(nums, list, 0);
        return lists;
    }

    private void generationSubsets(int[] nums, List<Integer> list, int start) {
        if (list.size() <= nums.length) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {


            System.out.println(lists);
            list.add(nums[i]);
            generationSubsets(nums, list, i + 1);
            list.remove(list.size() - 1);  // 回溯
            System.out.println(lists);
        }
    }

    public static void main(String[] args) {
        Solution78 test = new Solution78();
        int[] nums = {1, 2, 3};
        test.subsets(nums);
    }

}