package cn.mrxccc.shiro.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mrxccc
 * @create 2021/1/19
 */
public class ResponseDto extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResponseDto() {
        put("code", 0);
        put("msg", "操作成功");
    }

    public static ResponseDto error() {
        return error(1, "操作失败");
    }

    public static ResponseDto error(String msg) {
        return error(500, msg);
    }

    public static ResponseDto error(int code, String msg) {
        ResponseDto ResponseDto = new ResponseDto();
        ResponseDto.put("code", code);
        ResponseDto.put("msg", msg);
        return ResponseDto;
    }

    public static ResponseDto ok(String msg) {
        ResponseDto ResponseDto = new ResponseDto();
        ResponseDto.put("msg", msg);
        return ResponseDto;
    }

    public static ResponseDto ok(Map<String, Object> map) {
        ResponseDto ResponseDto = new ResponseDto();
        ResponseDto.putAll(map);
        return ResponseDto;
    }

    public static ResponseDto ok() {
        return new ResponseDto();
    }

    @Override
    public ResponseDto put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
