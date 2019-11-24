import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution40 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates.length == 0 || candidates == null) {
            return lists;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        generationCombinationSum(0, candidates, target, list);
        return lists;
    }

    private void generationCombinationSum(int start, int[] candidates, int target, ArrayList<Integer> list) {
        // 递归结束的条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));

        }
        for (int i = start; i < candidates.length; i++) {  // 数组中的每一个元素都会作为根节点作为一种情况进行遍历
            if (target - candidates[i] < 0) {  // 剪枝操作
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            generationCombinationSum(i + 1, candidates, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}

/*
 * 说明：
 * 1. 要使数组中的每个元素只能使用一次，下次递归的时候，数组索引得要加一（第33行代码）；或者索引不变，使用一个布尔型的变量标记循环中的遍历过的值。
 * 2. 要使得不能出现重复的排列，首先数组必须得排序，将当前索引下的值与前一个索引下的值相同的情况进行剔除。
 *
 * */