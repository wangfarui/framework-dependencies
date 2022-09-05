package com.wfr.base.framework.common;

/**
 * 基础异常
 * <p>后期基于此异常类做上下文
 *
 * @author wangfarui
 * @since 2022/9/2
 */
public class BaseException extends RuntimeException {

    private int code = CommonExceptionCode.SERVER_ERROR.getCode();

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
    }

    public BaseException(ExceptionCode exceptionCode, Throwable cause) {
        super(exceptionCode.getMessage(), cause);
        this.code = exceptionCode.getCode();
    }

}
