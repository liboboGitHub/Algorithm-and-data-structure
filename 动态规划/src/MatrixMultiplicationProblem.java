/**
 * 矩阵连乘问题
 * 解决：动态规划
 */

public class MatrixMultiplicationProblem {

    /**
     * array[i][j] 表示Ai...Aj的最佳计算次序所对应的相乘次数 即存放各子问题的最优值,即存放了各子问题的最优决策
     * s[i][j]=k 表示Ai...Aj这(j-i+1)个矩阵中最优加括号方法为(Ai...Ak)(Ak+1...Aj)
     * p[i]表示Ai的行数，p[i+1]表示Ai的列数
     */

    private int array[][];
    private int p[];
    private int s[][];

    public MatrixMultiplicationProblem() {
        array = new int[6][6];
        p = new int[]{5, 3, 4, 7, 2, 3, 6};
        s = new int[6][6];
    }


    public void MatrixChain() {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i][i] = 0;   // 单个矩阵相乘初始化为0
        }


        for (int r = 2; r <= n; r++) {              // 不同规模的子问题
            for (int i = 0; i < n - r; i++) {       // 分割的那个矩阵的开始位置
                int j = i + r - 1;                  // 分割的那个矩阵的结束位置
                array[i][j] = array[i + 1][j] + p[i] * p[i + 1] * p[j + 1];
                s[i][j] = i; // 将每次分割后得到的次数进行记录
                for (int k = i + 1; k < j; k++) {
                    int t = array[i][k] + array[k + 1][j] + p[i] * p[k + 1] * p[j];
                    if (t < array[i][j]) {
                        array[i][j] = t;
                        s[i][j] = k;
                    }
                }

            }

        }

    }

}

