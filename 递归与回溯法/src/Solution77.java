import java.util.ArrayList;
import java.util.List;

class Solution77 {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        generationCombine(n, k, 1, list);
        return lists;

    }

    private void generationCombine(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= i + 1 - (k - list.size()); i++) { // 剪枝
            list.add(i);
            generationCombine(n, k, i + 1, list);
            // 回溯
            list.remove(list.size() - 1);
        }
    }
} 