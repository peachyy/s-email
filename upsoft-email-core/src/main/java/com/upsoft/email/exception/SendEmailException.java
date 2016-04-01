package com.upsoft.email.exception;

/**
 * 发送邮件出现异常
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
public class SendEmailException extends  Exception {
    //必须要为异常指定编码或描述
    private SendEmailException() {
        super();
    }

    public SendEmailException(String message) {
        super(message);
    }

    public SendEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public SendEmailException(Throwable cause) {
        super(cause);
    }

    protected SendEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
