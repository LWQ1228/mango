package com.sunao.mango.core.exception;

/**
 * MangoException 自定义异常
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/06
 */
public class MangoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误消息
     */
    private String msg;
    /**
     * 错误码
     */
    private int code = 500;

    public MangoException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MangoException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public MangoException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public MangoException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public MangoException setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public MangoException setCode(int code) {
        this.code = code;
        return this;
    }
}
