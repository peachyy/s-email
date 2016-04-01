package com.upsoft.email.exception;

/**
 * 接收邮件发生异常
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
public class ReceiveEmailException extends  Exception {
    //必须要为异常指定编码或描述
    private ReceiveEmailException() {
        super();
    }

    public ReceiveEmailException(String message) {
        super(message);
    }

    public ReceiveEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReceiveEmailException(Throwable cause) {
        super(cause);
    }

    protected ReceiveEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
