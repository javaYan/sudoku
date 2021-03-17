package yyy.sudoku.controller;

import yyy.sudoku.vo.Response;

/**
 * @author yanyuyu
 * @Description
 * @Date 创建于 2021/3/16 11:37 下午
 */
public class BaseController {
    public Response success(Object object) {
        return Response.success(object);
    }

    public Response failure(String msg) {
        return Response.failure(msg);
    }
}
