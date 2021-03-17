package yyy.sudoku.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yanyuyu
 * @Description
 * @Date 创建于 2021/3/8 10:22 下午
 */
@Getter
@Setter
public class SudokuSolveRequest {
    private Cell[][] matrix;
}
