package com.gricultural.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义响应模型
 */
public class Result implements Serializable {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    private static final Integer okcode=1000;
    private static final Integer errorcode=500;


    // 响应中的数据
    private Object data;

    public static Result build(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }
    public static Result error( String msg) {
        return new Result(500, msg, null);
    }
    public static Result ok( Object data , String msg) {
        return new Result(1000, msg, data);
    }

    public static Result ok(String msg) {
        return new Result(msg);
    }
   /* public static Result ok(Object data,Integer code,String msg) {
        return new Result(data);
    }*/
    public static Result error(Object data,Integer code,String msg) {
        return new Result(data);
    }
/*    public static Result ok() {
        return new Result(null);
    }*/

    public Result() {

    }

    public static Result build(Integer code, String msg) {
        return new Result(code, msg, null);
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Object data) {
        this.code = okcode;
        this.msg = "OK";
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer Code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为EgoResult对象
     *
     * @param jsonData json数据
     * @param clazz EgoResult中的object类型
     * @return
     */
    public static Result formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, Result.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static Result format(String json) {
        try {
            return MAPPER.readValue(json, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static Result formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将字符串转换为对象，不包含Result内容
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static Result formatObjectToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            Object obj= null;
            if (jsonNode.isArray() && jsonNode.size() > 0) {
                obj = MAPPER.readValue(jsonNode.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(null,null, obj);
        } catch (Exception e) {
            return null;
        }
    }

}
