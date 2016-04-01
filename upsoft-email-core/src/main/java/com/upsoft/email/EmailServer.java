package com.upsoft.email;

import com.upsoft.email.exception.ReceiveEmailException;
import com.upsoft.email.exception.SendEmailException;
import com.upsoft.email.listeners.CallBack;
import com.upsoft.email.receive.MailReceiver;
import com.upsoft.email.receive.MailReceiverFace;
import com.upsoft.email.sender.MailSender;
import com.upsoft.email.sender.MailSenderFace;
import com.upsoft.email.transmission.Email;

import java.util.List;

/**
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
public abstract class EmailServer {
    //send support
    protected MailSender sender;
    //receive support
    protected MailReceiver receiver;



    /**
     * 发送一封邮件
     * @param email
     */
    public abstract void sendEmail(Email email) throws SendEmailException;

    /**
     * 发送一封邮件
     * @param email
     * @param call
     * @throws SendEmailException
     */
    public abstract void sendEmail(Email email, CallBack call) throws SendEmailException;
    /**
     * 发送多封邮件
     * @param emais
     */
    public abstract void sendEmail(List<Email> emais)throws SendEmailException;

    /**
     * 发送多封邮件
     * @param emais
     * @param call
     * @throws SendEmailException
     */
    public abstract void sendEmail(List<Email> emais, List<CallBack> call)throws SendEmailException;

    /**
     * 发送多封邮件
     * @param email
     */
    public abstract void sendEmail(Email... email)throws SendEmailException;

    /**
     * 接收邮件 目前未实现
     */
    public abstract void receiveEmail()throws ReceiveEmailException;

    /////////setting


    public MailSender getSender() {
        return sender;
    }

    public void setSender(MailSender sender) {
        this.sender = sender;
    }

    public MailReceiver getReceiver() {
        return receiver;
    }

    public void setReceiver(MailReceiver receiver) {
        this.receiver = receiver;
    }
}
