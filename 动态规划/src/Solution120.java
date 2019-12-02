import java.util.ArrayList;
import java.util.List;


// 我的解法的错误之处：只能解决全是正数或者全是负数的情况，对于正负都有的情况不使用，故使用动态规划的方式来解决
class Solution120 {
    //    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle.size() == 0) {
//            return 0;
//        }
//        return ret(triangle);
//    }
//
//    private int ret(List<List<Integer>> triangle) {
//        int height = triangle.size();
//        int sum = 0;
//
//        // 当前层数
//        int current = 0;
//        // 当前元素所在列的索引位置
//        int colIndex = 0;
//
//        while (current < height) {
//            List<Integer> currentlist = new ArrayList<>();
//            currentlist = triangle.get(current);
//            colIndex = currentlist.indexOf(currentlist.get(colIndex));
//            if (colIndex + 1 < currentlist.size() && currentlist.get(colIndex) > currentlist.get(colIndex + 1)) {
//                colIndex = colIndex + 1;
//            }
//            sum = sum + currentlist.get(colIndex);
//
//            ++current;
//        }
//        return sum;
//
//    }

    // 动态规划解法，自底向上，DP
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[] ret = new int[height + 1];

        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                ret[j] = Math.min(ret[j], ret[j + 1]) + triangle.get(i).get(j);  // 最优子结构
            }
        }
        return ret[0];
    }


}