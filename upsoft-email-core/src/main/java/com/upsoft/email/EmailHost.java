package com.upsoft.email;

import com.upsoft.email.exception.ReceiveEmailException;
import com.upsoft.email.exception.SendEmailException;
import com.upsoft.email.listeners.CallBack;
import com.upsoft.email.sender.MailSender;
import com.upsoft.email.transmission.Email;
import com.upsoft.email.transmission.SendStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
public class EmailHost extends   EmailServer {

    public static int THREAD_POOL_SIZE=5;

    private static ExecutorService theadPool= Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    @Override
    public void sendEmail(Email email) throws SendEmailException {
        sendEmail(email,null);
    }

    @Override
    public void sendEmail(Email email, CallBack call) throws SendEmailException {
          MailSender converSender=super.sender;
          //final Email email=email1;
          //final CallBack call=call1;
          theadPool.execute(new Runnable() {
               @Override
               public void run() {
                       try {
                           //if use call before
                           if (null != call && call.executeBefore(email)) {
                               System.out.println("过滤了" + email.getSubject());
                               return;
                           }
                           //send
                           converSender.send(email);
                           //if use call after
                           if (null != call)
                               call.execute(SendStatus.success, email, null);
                       } catch (Exception e) {
                           e.printStackTrace();
                           if (null != call)
                               call.execute(SendStatus.fail, email, e);
                       }
               }
           });

    }

    @Override
    public void sendEmail(List<Email> emais) throws SendEmailException {
        sendEmail(emais,null);
    }

    @Override
    public void sendEmail(List<Email> emais, List<CallBack> call) throws SendEmailException {
        if(call!=null && emais.size() != call.size())
            throw new SendEmailException("邮件列表于回调不匹配 参数错误");
        for(int i=0,len=emais.size();i<len;i++){
            sendEmail(emais.get(i),call!=null ? call.get(i) :null);
        }
    }

    @Override
    public void sendEmail(Email... email) throws SendEmailException {
        List<Email> l=new ArrayList<>();
        for(int i=0;i<email.length;i++){
            l.add(email[i]);
        }
        sendEmail(l);
    }

    @Override
    public void receiveEmail() throws ReceiveEmailException {
        throw new ReceiveEmailException("接收邮件当前尚未实现!");
    }
}
