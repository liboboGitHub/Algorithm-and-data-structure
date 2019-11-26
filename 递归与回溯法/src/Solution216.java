import java.util.ArrayList;
import java.util.List;

class Solution216 {
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n == 0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();

        generationCombinationSum3(k, n, list, 1);
        return lists;

    }

    private void generationCombinationSum3(int k, int n, List<Integer> list, int start) {
        if (list.size() == k && n == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            generationCombinationSum3(k, n - i, list, i + 1);

            // 回溯
            list.remove(list.size() - 1);

        }
    }

}