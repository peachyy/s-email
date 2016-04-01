package com.upsoft.email.autoconfigure;

import com.upsoft.email.EmailHost;
import com.upsoft.email.EmailServer;
import com.upsoft.email.receive.MailReceiver;
import com.upsoft.email.sender.MailSender;
import com.upsoft.email.sender.springmail.SpringMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Map;
import java.util.Properties;

/**
 * @author xsTao
 * @date 2016/1/28.
 * @see
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(UpsoftEmailServerProperties.class)
@ConditionalOnClass(EmailServer.class)
public class UpsoftEmailServerAutoConfiguration {
        @Autowired
        private UpsoftEmailServerProperties emailProperties;
        @Autowired
        private MailSender mailSender;
        @Autowired
        private MailReceiver mailReceiver;


        @Bean
        public EmailServer EmailServer(){
            EmailServer svr=new EmailHost();
            svr.setSender(mailSender);
            svr.setReceiver(mailReceiver);
            return svr;
        }
        @Bean
        @ConditionalOnClass(JavaMailSenderImpl.class)
        public MailSender createSpringMail(){
            SpringMailSender sender=new SpringMailSender();
            if (this.emailProperties.getDefaultEncoding() != null) {
                sender.setDefaultEncoding(this.emailProperties.getDefaultEncoding().name());
            }
            sender.setHost(this.emailProperties.getHost());
            sender.setPassword(this.emailProperties.getPassword());
            sender.setPort(this.emailProperties.getPort());
            sender.setProtocol(this.emailProperties.getProtocol());
            sender.setUsername(this.emailProperties.getUsername());
            if (!this.emailProperties.getProperties().isEmpty()) {
                sender.setJavaMailProperties(asProperties(this.emailProperties.getProperties()));
            }
            return sender;
        }
        @Bean
        public MailReceiver createReceiver(){
            return null;
        }


    ///util
    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        for (String str : source.keySet() ) {
          //  properties.putAll(source);
            properties.put("mail.".concat(str),source.get(str));
        }

        return properties;
    }
}
