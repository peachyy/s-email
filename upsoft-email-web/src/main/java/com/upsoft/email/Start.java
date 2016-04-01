package com.upsoft.email;

import com.upsoft.email.exception.SendEmailException;
import com.upsoft.email.listeners.CallBack;
import com.upsoft.email.transmission.Email;
import com.upsoft.email.transmission.SendStatus;
import com.upsoft.email.transmission.SimplEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
@SpringBootApplication
public class Start implements CommandLineRunner{
    private static final String specialsNoDotNoAt = "()<>,;:\\\"[]";
    private static final String specialsNoDot = specialsNoDotNoAt + "@";
    @Autowired
    private EmailServer svr;
    public static void main(String[] args){
        SpringApplication.run(Start.class, args);

        System.out.println("启动成功");
    }
        public static void main1(EmailServer emailServer){

            List<Email> list=new ArrayList<>();
            list.add(createEmail("A"));
            list.add(createEmail("B"));
            list.add(createEmail("C"));
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
            callList.add(new CallBack() {
                @Override
                public  boolean executeBefore(Email email) {
                    System.out.println("我是B回调 开始发送"+email.getSubject());
                    return true;
                }

                @Override
                public  void execute(SendStatus status, Email email, Exception e) {
                    System.out.println(email.getSubject()+"发送结果："+status);
                    if(null!=e){
                        System.out.println("exception:"+e.getMessage());
                    }
                }

            });
            callList.add(new CallBack() {
                @Override
                public  boolean executeBefore(Email email) {
                    System.out.println("我是C回调 开始发送"+email.getSubject());
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
            try {
               for(int i=0;i<5;i++){
                   System.out.println("开始发送了"+i);
                    emailServer.sendEmail(list, callList);

               }

            } catch (SendEmailException e) {
                e.printStackTrace();
            }
        }
    public static Email createEmail(String tag){
        Email email=new SimplEmail();
        email.setContent("<h1>你好 </h1>"+tag);
        email.setSubject("请你明天来重庆"+tag);
        email.addReceiveUser("9708159401@qq.com");
       // email.addCcUser("taoxss@foxmail.com");
       // email.addbccUser("hixstao@gmail.com");
      //ss  email.addFiles("C:\\settings.jar");
        return email;
    }

    @Override
    public void run(String... strings){
        try{
            /*
            Email email=  createEmail("ffsdafds");
            svr.sendEmail(email, new CallBack() {
                @Override
                public boolean executeBefore(Email email) {
                    return false;
                }

                @Override
                public void execute(SendStatus status, Email email, Exception e) {
                    System.out.println(status.toString()+"{}"+email.getSubject());
                    if(null!=e)
                        System.out.println(e.getMessage());
                }
            });
            */
           // test.main1(svr);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
