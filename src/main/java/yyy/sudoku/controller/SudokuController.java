package yyy.sudoku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyy.sudoku.service.SudokuSolveService;
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
public class SudokuController {
    @Autowired
    private SudokuSolveService sudokuSolveService;

    @GetMapping("index")
    public String index(Model model) {
        return INDEX;
    }

    /**
     * 跳转到测试页
     * @return
     */
    @GetMapping("test")
    public String test() {
        return TEST;
    }

    /**
     * 提交测试
     * @return
     */
    @PostMapping("test")
    public String doTest() {
        return null;
    }

    /**
     * 跳转到解题页
     * @return
     */
    @GetMapping("solve")
    public String solve() {
        return SOLVE;
    }

    /**
     * 进行解题
     * @return
     */
    @ResponseBody
    @PostMapping("solve")
    public Object doSolve(@RequestBody SudokuSolveRequest request) {
        Sudoku sudoku = new Sudoku(request.getMatrix());
        sudokuSolveService.solve(sudoku);
        return sudoku.getMatrix();
    }
}
