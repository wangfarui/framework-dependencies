package com.wfr.base.framework.common;

/**
 * 基础响应对象
 *
 * @author wangfarui
 * @since 2022/9/1
 */
public class BaseResponse<T> {

    private Integer code;

    private String message;

    private T data;

    private String traceId;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
