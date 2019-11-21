import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution46 {
    private List<List<Integer>> ret;
    private boolean used[];

    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<List<Integer>>(); // 装结果
        used = new boolean[nums.length]; // 表示某个数字是否已经被使用
        if (nums == null || nums.length == 0) {
            return ret;
        }
        LinkedList<Integer> p = new LinkedList<>(); // 表示某一种排列
        generationpermute(nums, 0, p);
        return ret;
    }

    private void generationpermute(int[] nums, int index, LinkedList<Integer> p) {
        if (index == nums.length) {
            ret.add((List<Integer>) p.clone());
            return; // 1.小返回，返回的是一个排列
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.addLast(nums[i]);
                generationpermute(nums, index + 1, p);
                p.removeLast();
                used[i] = false;
            }

        }
        return;
    }
}