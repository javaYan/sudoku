package yyy.sudoku.vo;


import lombok.Getter;
import lombok.Setter;

/**
 * @author yanyuyu
 * @Description
 * @Date 创建于 2021/3/4 11:09 下午
 */
public class Sudoku {
    private Cell[][] matrix = new Cell[9][9];

    /**
     * 第一个非固定单元- 行
     */
    private int minUnfixedRow = -1;

    /**
     * 第一个非固定单元- 列
     */
    private int minUnfixedColumn = -1;

    public Sudoku(int[][] array) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (array[row][column] > 0) {
                    matrix[row][column] = new Cell(array[row][column], true);
                    if (minUnfixedRow == -1) {
                        minUnfixedRow = row;
                        minUnfixedColumn = column;
                    }
                } else {
                    matrix[row][column] = new Cell(array[row][column], false);
                }
            }
        }
    }

    public int getCellValue(int row, int column) {
        return matrix[row][column].value;
    }

    public void setCellValue(int row, int column, int value) {
        matrix[row][column] = new Cell(value, false);
    }

    public void setCellValue(int row, int column, int value, boolean fixed) {
        matrix[row][column] = new Cell(value, fixed);
    }

    public int getMinUnfixedRow() {
        return minUnfixedRow;
    }

    public void setMinUnfixedRow(int minUnfixedRow) {
        this.minUnfixedRow = minUnfixedRow;
    }

    public int getMinUnfixedColumn() {
        return minUnfixedColumn;
    }

    public void setMinUnfixedColumn(int minUnfixedColumn) {
        this.minUnfixedColumn = minUnfixedColumn;
    }

    /**
     * 是否是不可更改的元素
     *
     * @return
     */
    public boolean isFixedCell(int row, int column) {
        return matrix[row][column].fixed;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    @Getter
    @Setter
    public class Cell {
        private int value;
        /**
         * 是否是固定值
         */
        private boolean fixed;

        public Cell(int value, boolean fixed) {
            this.value = value;
            this.fixed = fixed;
        }
    }
}
