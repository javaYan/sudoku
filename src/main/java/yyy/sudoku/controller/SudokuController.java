package yyy.sudoku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyy.sudoku.service.SudokuSolveService;
import yyy.sudoku.vo.Response;
import yyy.sudoku.vo.Sudoku;
import yyy.sudoku.vo.SudokuSolveRequest;

import static yyy.sudoku.constant.ViewConstant.INDEX;
import static yyy.sudoku.constant.ViewConstant.SOLVE;
import static yyy.sudoku.constant.ViewConstant.TEST;

/**
 * @author yanyuyu
 * @Description
 * @Date 创建于 2021/3/7 12:13 上午
 */
@Controller
@RequestMapping("sudoku")
public class SudokuController extends BaseController{
    @Autowired
    private SudokuSolveService sudokuSolveService;

    @GetMapping({"index", "indexPage"})
    public String indexPage() {
        return INDEX;
    }

    /**
     * 跳转到测试页
     * @return
     */
    @GetMapping("testPage")
    public String testPage() {
        return TEST;
    }

    /**
     * 跳转到解题页
     * @return
     */
    @GetMapping("solvePage")
    public String solvePage() {
        return SOLVE;
    }


    /**
     * 提交测试
     * @return
     */
    @PostMapping("doTest")
    public Response doTest() {
        return null;
    }



    /**
     * 初始化 返回空数独
     * @return
     */
    @ResponseBody
    @GetMapping("initSolve")
    public Response initSolve() {
        int[][] matrix = new int[9][9];
        Sudoku sudoku = new Sudoku(matrix);
        return success(sudoku.getMatrix());
    }

    /**
     * 进行解题
     * @return
     */
    @ResponseBody
    @PostMapping("doSolve")
    public Response doSolve(@RequestBody SudokuSolveRequest request) {
        Sudoku sudoku = new Sudoku(request.getMatrix());
        sudokuSolveService.solve(sudoku);
        return success(sudoku.getMatrix());
    }
}
