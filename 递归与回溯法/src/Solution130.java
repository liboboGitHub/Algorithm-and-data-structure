class Solution130 {
    private int[][] d = {{-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}};
    private int m, n;
    private boolean[][] isVisted;

    // 判断是否是边缘
    private boolean isEdge(int i, int j) {
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
            return true;
        }
        return false;
    }

    // 使用的方法：深度优先搜索（DFS），递归
    public void solve(char[][] board) {
        if (board.length == 0 || board == null) {
            return;
        }
        // 初始化
        m = board.length;       // 行的大小
        n = board[0].length;    // 列的大小
        isVisted = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘开始
                if (isEdge(i, j) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }

            }

        }

        // 转换回来
        generation(board);

    }

    private void generation(char[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !isVisted[i][j]) {
                    board[i][j] = 'X'; // 将内部的“O”替换为“X”
                }
            }
        }
    }

    // 递归函数
    private void dfs(char[][] board, int i, int j) {
        // 递归结束的条件
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' || isVisted[i][j]) {
            return;
        }
        isVisted[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newx = i + d[k][0];
            int newy = j + d[k][1];
            dfs(board, newx, newy);
        }

    }
}

