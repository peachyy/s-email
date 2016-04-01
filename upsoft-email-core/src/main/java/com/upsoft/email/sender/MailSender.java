package com.upsoft.email.sender;

import com.upsoft.email.exception.SendEmailException;
import com.upsoft.email.transmission.Email;

import java.util.Properties;

import javax.mail.internet.AddressException;

/**
 * 发送邮件抽象
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
public interface MailSender {
    public void send(Email email) throws SendEmailException;
    public Email createEmail();

    public Email createEmail(String smtp);

    /**
     * setting smtp perperteies
     * @param properties
     */
    public void putProperties(Properties properties);

    /**
     * setting smtp by key value
     * @param key
     * @param value
     */
    public void putProperties(String key, String value);
    public Object getProperties(String key);
    public void setHost(String host);
    public void setUsername(String username);
    public void setPassword(String password);
    public void setPort(int port);
}
