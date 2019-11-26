import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution52 {
    // n皇后问题，使用递归回溯法解决
    // 辅助变量
    private boolean[] col;  // 这一列这个元素是否被标记过
    private boolean[] dia1; // 第一个对角线
    private boolean[] dia2; // 第二个对角线
    List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        List<Integer> list = new LinkedList<Integer>();
        putQueen(n, list, 0);
        return lists.size();

    }

    private void putQueen(int n, List<Integer> list, int index) {
        if (index == n) {
            lists.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 尝试将第index行的皇后放在第i列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) { // 表示这个位置可以放一个皇后
                list.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, list, index + 1);

                // 回溯
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                list.remove(list.size() - 1);
            }
        }
        return;
    }
}