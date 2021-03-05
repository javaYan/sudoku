package service;

import vo.Sudoku;

/**
 * @author yanyuyu
 * @Description 数独解题service
 * @Date 创建于 2021/3/4 11:03 下午
 */
public interface SudokuSolveService {
    void solve(Sudoku sudoku);
}
