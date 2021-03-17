package yyy.sudoku.service;

import yyy.sudoku.service.impl.SudokuSolveServiceImpl;
import yyy.sudoku.vo.Sudoku;

/**
 * @author yanyuyu
 * @Description
 * @Date 创建于 2021/3/5 12:55 上午
 */
public class SudokuSolveServiceTest {
    public static void main(String args[]) {
        Integer[][] array = {

                /**
                {0, 4, 6, 9, 0, 3, 0, 0, 0},
                {0, 0, 3, 0, 5, 0, 0, 6, 0},
                {9, 0, 0, 0, 0, 2, 0, 0, 3},
                {0, 0, 5, 0, 0, 6, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 7, 8, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 5, 0},
                {0, 8, 1, 3, 0, 0, 0, 0, 7},
                {0, 0, 0, 8, 0, 0, 1, 0, 4}};
                */

         {0, 8, 0, 6, 0, 0, 0, 9, 0},
         {0, 9, 0, 0, 0, 0, 7, 0, 5},
         {0, 0, 0, 3, 1, 0, 0, 6, 0},
         {0, 0, 0, 0, 7, 2, 0, 0, 4},
         {8, 0, 0, 5, 0, 0, 0, 2, 0},
         {0, 1, 2, 0, 6, 0, 8, 0, 0},
         {0, 4, 0, 0, 3, 0, 0, 0, 9},
         {0, 6, 0, 9, 0, 4, 0, 7, 0},
         {1, 5, 0, 0, 0, 0, 0, 0, 3}};
        /**
         {3, 9, 8, 2, 1, 6, 4, 7, 5},
         {4, 6, 7, 5, 9, 3, 8, 1, 2},
         {5, 1, 2, 7, 0, 8, 0, 3, 9},
         {1, 4, 0, 3, 5, 9, 2, 8, 9},
         {7, 8, 5, 0, 6, 2, 0, 9, 1},
         {9, 2, 3, 0, 8, 7, 5, 6, 4},
         {6, 3, 4, 0, 2, 1, 7, 0, 8},
         {2, 7, 1, 8, 0, 5, 9, 0, 6},
         {8, 5, 9, 6, 7, 0, 1, 2, 3}};
         */
        Sudoku sudoku = new Sudoku(array);
        SudokuSolveService sudokuSolveService = new SudokuSolveServiceImpl();
        long startTime = System.currentTimeMillis();
        sudokuSolveService.solve(sudoku);
        System.out.println(String.format("solve proble cost time: %d ms, result: ", System.currentTimeMillis() - startTime));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku.getCellValue(i, j) + (j == 8 ? "\n" : " "));
            }
        }
    }
}
