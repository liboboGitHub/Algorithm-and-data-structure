import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution39 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 || candidates == null) {
            return lists;
        }
        ArrayList<Integer> list = new ArrayList<>();
        generationCombinationSum(0, candidates, target, list);
        return lists;
    }

    private void generationCombinationSum(int start, int[] candidates, int target, List<Integer> list) {

        // 递归结束的条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        }

        // 递归深入
        for (int i = start; i < candidates.length; i++) {

            // 因为每个数字可以被重复使用，所以这里不加入判断条件
            list.add(candidates[i]);
            generationCombinationSum(i, candidates, target - candidates[i], list);
            // 回溯处理
            list.remove(list.size() - 1);

        }

    }
}