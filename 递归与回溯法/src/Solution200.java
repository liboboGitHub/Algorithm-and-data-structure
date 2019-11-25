class Solution200 {
    // 辅助量
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 二位平面向四个方向移动的标志
    private int m, n;  // 二位数组的行和列
    private boolean[][] isVisited; // 保存这个位置的字母是否被访问过

    // 这个方法是必要的，因为在移动的过程中可能让索引为负值或者大于数组的界限
    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {  // 为了避免重复，在这里进行限制
                    floodfill(i, j, grid);
                    ret++;
                }
            }

        }
        return ret;

    }

    private void floodfill(int startx, int starty, char[][] grid) {
        isVisited[startx][starty] = true;
        for (int k = 0; k < 4; k++) {
            int newx = startx + d[k][0];
            int newy = starty + d[k][1];
            if (isArea(newx, newy) && !isVisited[newx][newy] && grid[newx][newy] == '1') {  // 注意书写顺序
                floodfill(newx, newy, grid);
            }
        }
        return;
    }
}