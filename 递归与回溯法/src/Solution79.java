class Solution79 {
    /*
     * --------------> Y
     * |
     * |
     * |
     * |
     * |
     * |
     * \/
     * X
     *
     * */
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 二位平面向四个方向移动的标志
    private int m, n;  // 二位数组的行和列
    private boolean[][] isVisited; // 保存这个位置的字母是否被访问过

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            // throw new IllegalArgumentException("数组为空！");
            return false;
        }
        m = board.length;               // 行的大小
        n = board[0].length;            // 列的大小
        isVisited = new boolean[m][n];  // 初始化都为false
        for (int i = 0; i < m; i++) {   // 这里的循环作用是：从二维数组的的每一个位置作为初始化的搜索起点
            for (int j = 0; j < n; j++) {
                if (generation(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 该字母确保在这个二维平面内
    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // 递归回溯函数
    private boolean generation(char[][] board, String word, int startx, int starty, int index) {
        if (index == word.length() - 1) {
            return board[startx][starty] == word.charAt(index); // 小技巧1
        }

        if (board[startx][starty] == word.charAt(index)) {
            isVisited[startx][starty] = true;
            // 从四个方向探索下一个位置的字母能否个字符创相应的下一个的字母相匹配 （小技巧2）
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];   // 这里可以很好地理解贪吃蛇的运动轨迹，就是这样运动起来的
                int newy = starty + d[i][1];
                if (isArea(newx, newy) && !isVisited[newx][newy] && generation(board, word, newx, newy, index + 1)) {
                    return true;
                }
            }
            isVisited[startx][starty] = false; // 回溯 （要正确理解回溯问题，必须先画出一个递归树，理解其中实现的轨迹

        }
        return false;
    }
}


