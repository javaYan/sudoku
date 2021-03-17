package yyy.sudoku.vo;


import lombok.Getter;

/**
 * @author yanyuyu
 * @Description
 * @Date 创建于 2021/3/16 11:38 下午
 */

@Getter
public class Response {
    private Boolean success;
    private Object data;
    private String msg;

    Response(Boolean success) {
        this.success = success;
    }
    public static Response failure(String msg) {
        Response response = new Response(false);
        response.msg = msg;
        return response;
    }

    public static Response success(Object data) {
        Response response = new Response(true);
        response.data = data;
        return response;
    }
}
