package yyy.sudoku.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import yyy.sudoku.service.SudokuSolveService;
import yyy.sudoku.util.MathUtil;
import yyy.sudoku.vo.Cell;
import yyy.sudoku.vo.Sudoku;

import java.util.Arrays;

/**
 * @author yanyuyu
 * @Description 数据解题： 回溯法
 * @Date 创建于 2021/3/4 11:05 下午
 */
@Slf4j
@Service
public class SudokuSolveServiceImpl implements SudokuSolveService {
    // 最大边界
    private static int MAX_INDEX = 8;
    // 最小边界
    private static int MIN_INDEX = 0;
    // 最小边界
    private static int THREE = 3;
    // 单元格最大值
    private static int MAX_VALUE = 9;
    // 单元格最小值
    private static int MIN_VALUE = 1;
    // 单元格初始值（即未填充数值）
    private static int INIT_VALUE = 0;

    @Override
    public void solve(Sudoku sudoku) {
        beforeSolve(sudoku);

        int row = MIN_INDEX;
        int column = MIN_INDEX;
        Integer value = MIN_VALUE;
        // 行越界 说明数独问题解决
        while (row <= MAX_INDEX) {
            // 如果是固定单元，则跳过
            if (sudoku.isFixedCell(row, column)) {
                row = column == MAX_INDEX ? ++row : row;
                column = column == MAX_INDEX ? MIN_INDEX : ++column;
                value = MIN_VALUE;
                continue;
            }

            // 值可接受
            if (acceptValue(sudoku, row, column, value)) {
                sudoku.setCellValue(row, column, value);
                row = column == MAX_INDEX ? ++row : row;
                column = column == MAX_INDEX ? MIN_INDEX : ++column;
                value = MIN_VALUE;
                continue;
            }

            // 值不可接受，则对值进行+1
            if (value < MAX_VALUE) {
                value++;
                continue;
            } else {
                // 最大值也不可接受，那就初始化当前单元
                sudoku.setCellValue(row, column, INIT_VALUE);
            }

            // 值不可接受且值已经是最大值，则对上一个单元进行回退
            while (true) {
                // 如果回退至行索引异常，则说明此题无解
                if (row < MIN_INDEX) {
                    throw new IllegalArgumentException("No Answer For This Problem !");
                }
                row = column == MIN_INDEX ? --row : row;
                column = column == MIN_INDEX ? MAX_INDEX : --column;
                if (sudoku.isFixedCell(row, column)) {
                    continue;
                }
                Integer preValue = sudoku.getCellValue(row, column);
                // 如果上一个单元的值是最大值 清空上一单元值，继续回退
                if (preValue == MAX_VALUE) {
                    sudoku.setCellValue(row, column, INIT_VALUE);
                    continue;
                }
                // 如果非最大值，则进行+1 前进
                value = preValue + 1;

                break;
            }
        }

        afterSolve(sudoku);
    }

    /**
     * 计算前
     *
     * @param sudoku
     */
    private void beforeSolve(Sudoku sudoku) {
        // 如果没有需要填写的单元，则认为题目异常
        if (sudoku.getMinUnfixedColumn() == -1 || sudoku.getMinUnfixedRow() == -1) {
            throw new IllegalArgumentException("No Need To Solve For This Problem !");
        }
        // 如果题目无解或冲突，则认为异常
        for (int row = MIN_INDEX; row <= MAX_INDEX; row ++) {
            for (int column = MIN_INDEX; column <= MAX_INDEX; column ++) {
                if (sudoku.isFixedCell(row, column) && (!MathUtil.isRange(sudoku.getCellValue(row, column), MIN_VALUE, MAX_VALUE) || !acceptValue(sudoku, row, column, sudoku.getCellValue(row, column)))) {
                    throw new IllegalArgumentException("No Answer For This Problem !");
                }
            }
        }
        log.info("\nSudoku solve before :\n{}", getSudokuMatrixString(sudoku));
    }

    // 计算后
    private void afterSolve(Sudoku sudoku) {
        log.info("\nSudoku solve after :\n{}", getSudokuMatrixString(sudoku));
    }

    /**
     * 校验是否可接收此值
     *
     * @param sudoku
     * @param row
     * @param column
     * @param value
     * @return
     */
    private boolean acceptValue(Sudoku sudoku, int row, int column, Integer value) {
        // 校验同行同列
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            // 校验同行是否有相同数
            if (column != i && sudoku.getCellValue(row, i) == value) {
                return false;
            }
            // 校验同列是否有相同数
            if (row != i && sudoku.getCellValue(i, column) == value) {
                return false;
            }
        }

        // 校验九宫格
        int startRow = row / THREE * THREE;
        int startColumn = column / THREE * THREE;
        for (int i = startRow; i < startRow + THREE; i++) {
            for (int j = startColumn; j < startColumn + THREE; j++) {
                if (sudoku.getCellValue(i, j) == value && (i != row || j != column)) {
                    return false;
                }
            }
        }
        return true;
    }

    private String getSudokuMatrixString(Sudoku sudoku) {
        Cell[][] cells = sudoku.getMatrix();
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(cells).forEach( cell -> {
            stringBuilder.append("[");
            Arrays.stream(cell).forEach( c -> {
                stringBuilder.append(c.getValue() == null ? " " : c.getValue()).append(",");
            });
            stringBuilder.deleteCharAt(stringBuilder.length()-1).append("]\n");
        });
        return stringBuilder.toString();
    }
}
