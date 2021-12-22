/**
 * Description :
 * <p>
 *     题目: 岛屿数量
 * 问题:
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * 思路
 * 双重循环遍历二位数组, 如果有为1的值, 则将这个值赋值为1, 岛屿数加一, 递归遍历这个值的上下左右
 *
 * @author : xiongzq
 * @date : 2021-12-22
 */
public class GridNum {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int gridNum = 0;

        int line = grid.length;
        int row = grid[0].length;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    gridNum++;
                    markGrid(grid, i, j);
                }
            }
        }

        return gridNum;
    }

    private void markGrid(char[][] grid, int i, int j) {
        int line = grid.length - 1;
        int row = grid[0].length - 1;
        // 上
        char top = grid[Math.max(0, i - 1)][j];
        if (top == '1') {
            grid[i - 1][j] = '0';
            markGrid(grid, i - 1, j);
        }

        // 下
        char end = grid[Math.min(i + 1, line)][j];
        if (end == '1') {
            grid[i + 1][j] = '0';
            markGrid(grid, i + 1, j);
        }

        // 左
        char left = grid[i][Math.max(0, j - 1)];
        if (left == '1') {
            grid[i][j - 1] = '0';
            markGrid(grid, i, j - 1);
        }

        // 右
        char right = grid[i][Math.min(j + 1, row)];
        if (right == '1') {
            grid[i][j + 1] = '0';
            markGrid(grid, i, j + 1);
        }
    }
}
