package yyy.sudoku.util;

/**
 * @author yanyuyu
 * @Description
 * @Date 创建于 2021/3/18 12:52 上午
 */
public class MathUtil {
    public static boolean isGreateThanZero(Number value) {
        return value != null && value.doubleValue() > 0;
    }

    public static boolean isRange(Number value, Number start, Number end) {
        return value != null && value.doubleValue() >= start.doubleValue() && value.doubleValue() <= end.doubleValue();
    }
}
