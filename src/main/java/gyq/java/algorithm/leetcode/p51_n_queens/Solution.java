package gyq.java.algorithm.leetcode.p51_n_queens;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * N皇后
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/n-queens/
 */
class Solution {
    private List<List<String>> result = new ArrayList<>();
    private String[][] trackedPosition;

    public List<List<String>> solveNQueens(int n) {
        // board代表棋盘,row代表行的选择,column代表列的选择 
        int row = n;
        int column = n;
        String[][] board = new String[row][column];
        // 初始化选择为未选择
        trackedPosition = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                trackedPosition[i][j] = ".";
            }
        }
        backtrack(board, 0);
        return result;
    }

    /**
     * 遍历决策树入口
     *
     * @param board
     * @param currentRow 当前起始位置行
     */
    public void backtrack(String[][] board, int currentRow) {
        if (currentRow == board.length) {
            // 到达最后一行,退出递归
            // 利用当前的trackedNums拼出
            int row = trackedPosition.length;
            int column = trackedPosition[0].length;
            List<String> list = new LinkedList<>();
            for (int i = 0; i < row; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < column; j++) {
                    stringBuilder.append(trackedPosition[i][j]);
                }
                // 组织返回值,按照题目的返回格式
                list.add(stringBuilder.toString());
            }
            result.add(list);
            return;
        }
        String[] columns = board[currentRow];
        for (int j = 0; j < columns.length; j++) {
            if (!isValid(currentRow, j)) {
                // 不满足放置条件
                continue;
            }
            // 做选择,放置皇后
            trackedPosition[currentRow][j] = "Q";
            // 进入下层决策树,就是下一行的选择
            backtrack(board, currentRow + 1);
            // 退出下层决策树,取消选择
            trackedPosition[currentRow][j] = ".";
        }
    }

    /**
     * 判断当前行列是否可以放置皇后
     *
     * @param row
     * @param column
     * @return
     */
    public boolean isValid(int row, int column) {
        for (int i = 0; i < trackedPosition.length; i++) {
            String[] trackedNum = trackedPosition[i];
            for (int j = 0; j < trackedNum.length; j++) {
                if (Objects.equals(trackedNum[j], "Q")) {
                    // 已经放置了皇后
                    // 判断是否同行或同列, 即row或column相等
                    if (i == row || j == column) {
                        return false;
                    }
                    // 判断是否在斜向,即行列的差值绝对值相等
                    if (Math.abs(i - row) == Math.abs(j - column)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        System.out.println(JSON.toJSONString(lists));
    }
}