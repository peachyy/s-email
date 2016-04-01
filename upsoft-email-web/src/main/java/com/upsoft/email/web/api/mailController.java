package com.upsoft.email.web.api;

import com.upsoft.email.EmailServer;
import com.upsoft.email.exception.SendEmailException;
import com.upsoft.email.transmission.Email;
import com.upsoft.email.transmission.SimplEmail;
import com.upsoft.email.web.support.Result;
import com.upsoft.email.web.support.StringUtil2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsTao
 * @date 2016/2/2.
 * @see
 * @since 1.0
 */
@RestController()
@RequestMapping("/mail")
public class mailController {


    @Autowired
    private EmailServer svr;

    @RequestMapping(value = "/send")
    public Result sendMail(String to,String cc,String bcc,String subject,String content){
        Result rst=null;
        try {
            Email email=new SimplEmail();
            if(null==to){
                throw new IllegalArgumentException("收件人不能为空");
            }
            if(!StringUtil2.isValidateEmail(to))
                throw new IllegalArgumentException("收件人["+to+"]格式验证错误");
            email.addReceiveUser(to);
            if(null!=bcc){
               if(!StringUtil2.isValidateEmail(bcc))
                    throw new IllegalArgumentException("密送人["+bcc+"]格式验证错误");
               email.addbccUser(bcc);
            }

            if(null!=cc){
                if(!StringUtil2.isValidateEmail(cc))
                    throw new IllegalArgumentException("抄送人["+cc+"]格式验证错误");
                email.addCcUser(cc);
            }
            if(null==subject)
                throw new IllegalArgumentException("邮件标题不能为空");
            email.setSubject(subject);
            email.setContent(content);
            svr.sendEmail(email);
            rst=new Result(true,"操作成功");
        } catch (Exception e) {
         //   e.printStackTrace();
            rst=new Result(false,"操作失败"+e.getMessage());
        }
        return rst;
    }

}
