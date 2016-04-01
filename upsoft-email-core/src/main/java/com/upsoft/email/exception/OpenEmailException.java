package com.upsoft.email.exception;

/**
 * 读取邮件发生异常
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
public class OpenEmailException  extends  Exception {
    //必须要为异常指定编码或描述
    private OpenEmailException() {
        super();
    }

    public OpenEmailException(String message) {
        super(message);
    }

    public OpenEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenEmailException(Throwable cause) {
        super(cause);
    }

    protected OpenEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
