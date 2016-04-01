package com.upsoft.email.sender.springmail;

import com.upsoft.email.EmailHost;
import com.upsoft.email.EmailServer;
import com.upsoft.email.exception.SendEmailException;
import com.upsoft.email.listeners.CallBack;
import com.upsoft.email.sender.MailSender;
import com.upsoft.email.transmission.Email;
import com.upsoft.email.transmission.SendStatus;
import com.upsoft.email.transmission.SimplEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
//@SpringBootApplication
public class test {
    private static final String specialsNoDotNoAt = "()<>,;:\\\"[]";
    private static final String specialsNoDot = specialsNoDotNoAt + "@";


        public static void main1(String[] args){
            EmailServer emailServer=new EmailHost();
            MailSender sender=new SpringMailSender();
            sender.putProperties("mail.smtp.auth","true");
            sender.putProperties("mail.transport.protocol","smtp");
          //  sender.putProperties("mail.smtp.ssl.enable","true");
            sender.putProperties("mail.smtp.timeout","25000");
            sender.setUsername("peach_mr@sina.com");
            sender.setPassword("970815940");
            sender.setHost("smtp.sina.com.cn");
         //  sender.setPort(465);
            emailServer.setSender(sender);

            List<Email> list=new ArrayList<>();
            list.add(createEmail("A"));
           // list.add(createEmail("B"));
           // list.add(createEmail("C"));
            List<CallBack> callList=new ArrayList<>();
            callList.add(new CallBack() {
                @Override
                public  boolean executeBefore(Email email1) {
                    System.out.println("我是A回调 开始发送"+email1.getSubject());
                    return false;
                }
                @Override
                public  void execute(SendStatus status, Email email, Exception e) {
                    System.out.println(email.getSubject()+"发送结果："+status);
                    if(null!=e){
                        System.out.println("exception:"+e.getMessage());
                    }
                }

            });
//            callList.add(new CallBack() {
//                @Override
//                public  boolean executeBefore(Email email) {
//                    System.out.println("我是B回调 开始发送"+email.getSubject());
//                    return true;
//                }
//
//                @Override
//                public  void execute(SendStatus status, Email email, Exception e) {
//                    System.out.println(email.getSubject()+"发送结果："+status);
//                    if(null!=e){
//                        System.out.println("exception:"+e.getMessage());
//                    }
//                }
//
//            });
//            callList.add(new CallBack() {
//                @Override
//                public  boolean executeBefore(Email email) {
//                    System.out.println("我是C回调 开始发送"+email.getSubject());
//                    return false;
//                }
//
//                @Override
//                public  void execute(SendStatus status, Email email, Exception e) {
//                    System.out.println(email.getSubject()+"发送结果："+status);
//                    if(null!=e){
//                        System.out.println("exception:"+e.getMessage());
//                    }
//                }
//
//            });
            try {
              // for(int i=0;i<5;i++){
                   //System.out.println("开始发送了"+i);
                    emailServer.sendEmail(list);

              // }

            } catch (SendEmailException e) {
                e.printStackTrace();
            }
        }
    public static Email createEmail(String tag){
        Email email=new SimplEmail();
        email.setContent("<h1>你好 </h1>"+tag);
        email.setSubject("请你明天来重庆"+tag);
        email.addReceiveUser("970815940@qq.com");
       // email.addCcUser("taoxss@foxmail.com");
      //  email.addbccUser("hixstao@gmail.com");
      //  email.addFiles("C:\\settings.jar");
        return email;
    }
}
