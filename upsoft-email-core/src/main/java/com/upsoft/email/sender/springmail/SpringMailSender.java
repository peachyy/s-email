package com.upsoft.email.sender.springmail;

import com.upsoft.email.exception.SendEmailException;
import com.upsoft.email.sender.MailSenderFace;
import com.upsoft.email.transmission.Email;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * 使用spring-context-support.jar提供支持发送邮件
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
public class SpringMailSender extends JavaMailSenderImpl
        implements MailSenderFace {
    public SpringMailSender(){
    }
    @Override
    public Email createEmail() {

        return null;
    }

    @Override
    public Email createEmail(String smtp) {
        return null;
    }

    @Override
    public void putProperties(Properties properties) {
        super.getJavaMailProperties().putAll(properties);
    }

    @Override
    public void putProperties(String key, String value) {
        super.getJavaMailProperties().put(key,value);
    }

    @Override
    public Object getProperties(String key) {
        return super.getJavaMailProperties().getProperty(key);
    }

    @Override
    public  void send(Email email) throws SendEmailException {
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(super.createMimeMessage(),
                        true,getDefaultEncoding()==null ? "UTF-8" :getDefaultEncoding());
            //发件人
            messageHelper.setFrom(super.getUsername());
            //邮件标题
            messageHelper.setSubject(email.getSubject());
            //邮件内容
            messageHelper.setText(email.getContent(),true);
            //收件人
            messageHelper.setTo(email.getReceiveUser().toArray(new String[]{}));
            //抄送
            messageHelper.setCc(email.getCcUser().toArray(new String[]{}));
            //密送
            messageHelper.setBcc(email.getBccUser().toArray(new String[]{}));
            //附件
           List<String> paths= email.getFiles();
           List<String> filenames= email.getFilenames();
            if(filenames.size()>0 && paths.size()!=filenames.size())
                throw new SendEmailException("附件列表与附件名称不匹配 filenames:"+filenames.size() +
                        ",files:"+paths.size());
            //添加附件
           for (int i=0,len=paths.size();i<len;i++){
               //文件
               File f=new File(paths.get(i));
               String fileName=null;
               if(filenames.size()==0)
                   fileName=f.getName();
               else
                   fileName =filenames.get(i);
               //添加到附件列表
               messageHelper.addAttachment(fileName,f);
           }
            //invoke
            super.send(messageHelper.getMimeMessage());
        } catch (Exception e) {
            throw new SendEmailException(e.getMessage(),e);
        }
    }


    //help

    private String getMailProperty(String key){
        Object val=super.getJavaMailProperties().get(key);
       return  null==val ? null :val.toString();
    }
}
