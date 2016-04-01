package com.upsoft.email.listeners;

import com.upsoft.email.EmailHost;
import com.upsoft.email.transmission.Email;
import com.upsoft.email.transmission.SendStatus;

/**
 * 邮件发送操作完成后的回调
 * @author xsTao
 * @date 2016/1/28.
 * @see
 * @since 1.0
 */
public interface CallBack {
    /**
     * 发送之前   如果返回false 则不在发送了
     * @param email
     * @return
     */
    public boolean executeBefore(Email email);

    /***
     * 发送之后
     * @param status
     * @param email
     * @param e
     */
    public void execute(SendStatus status, Email email, Exception e);
}
