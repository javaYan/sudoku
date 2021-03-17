package yyy.sudoku.vo;


import lombok.Getter;
import lombok.Setter;
import yyy.sudoku.util.MathUtil;

/**
 * @author yanyuyu
 * @Description
 * @Date 创建于 2021/3/4 11:09 下午
 */
@Getter
@Setter
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

    public Sudoku(Integer[][] array) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (MathUtil.isGreateThanZero(array[row][column])) {
                    matrix[row][column] = new Cell(array[row][column], true);
                    if (minUnfixedRow == -1) {
                        minUnfixedRow = row;
                        minUnfixedColumn = column;
                    }
                } else {
                    matrix[row][column] = new Cell(false);
                }
            }
        }
    }

    public Sudoku(Cell[][] cells) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (MathUtil.isGreateThanZero(cells[row][column].getValue())) {
                    cells[row][column].setFixed(true);
                    if (minUnfixedRow == -1) {
                        minUnfixedRow = row;
                        minUnfixedColumn = column;
                    }
                } else {
                    cells[row][column].setFixed(false);
                }
            }
        }
        matrix = cells;
    }

    public Integer getCellValue(int row, int column) {
        return matrix[row][column].getValue();
    }

    public void setCellValue(int row, int column, Integer value) {
        matrix[row][column] = new Cell(value, false);
    }

    public int getMinUnfixedRow() {
        return minUnfixedRow;
    }

    public int getMinUnfixedColumn() {
        return minUnfixedColumn;
    }

    /**
     * 是否是不可更改的元素
     *
     * @return
     */
    public boolean isFixedCell(int row, int column) {
        return Boolean.TRUE.equals(matrix[row][column].getFixed());
    }

    public Cell[][] getMatrix() {
        return matrix;
    }


}
