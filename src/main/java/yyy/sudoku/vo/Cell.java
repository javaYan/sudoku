package yyy.sudoku.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yanyuyu
 * @Description
 * @Date 创建于 2021/3/18 1:27 上午
 */
@Getter
@Setter
public class Cell {
    private Integer value;
    /**
     * 是否是固定值
     */
    private Boolean fixed;

    public Cell(Integer value, Boolean fixed) {
        this.value = value;
        this.fixed = fixed;
    }

    public Cell(Boolean fixed) {
        this.fixed = fixed;
    }
}
