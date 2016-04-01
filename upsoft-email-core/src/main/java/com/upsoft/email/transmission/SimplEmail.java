package com.upsoft.email.transmission;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
public class SimplEmail implements  Email {

    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容 正文
     */
    private String content;
    /**
     * 收件人
     */
    private List<String> receiveUser=new ArrayList<>();
    /**
     * 抄送
     */
    private List<String> ccUser=new ArrayList<>();
    /**
     * 秘密抄送
     */
    private List<String> bccUser=new ArrayList<>();
    /**
     * 附件名称列表
     */
    private List<String> filenames=new ArrayList<>();
    /**
     * 附件列表 和 附件名称列表一一对应的
     */
    private List<String> files=new ArrayList<>();
    /**
     * 附加属性 不会对邮件内容和参数进行影响  目前只是为了在异步中得到这个附件值
     */
    private Object dataPlus;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        if(content==null)this.content="";
        this.content = content;
    }
    public List<String> getReceiveUser() {
        return receiveUser;
    }

    @Override
    public void addReceiveUser(String toemail) {
        this.receiveUser.add(toemail);
    }

    public void setReceiveUser(List<String> receiveUser) {
        this.receiveUser = receiveUser;
    }
    public List<String> getFilenames() {
        return filenames;
    }

    @Override
    public void addFilenames(String filename) {
        this.filenames.add(filename);
    }

    public void setFilenames(List<String> filenames) {
        this.filenames = filenames;
    }
    public List<String> getCcUser() {
        return ccUser;
    }

    @Override
    public void addCcUser(String user) {
        this.ccUser.add(user);
    }

    public void setCcUser(List<String> ccUser) {
        this.ccUser = ccUser;
    }
    public List<String> getBccUser() {
        return bccUser;
    }

    @Override
    public void addbccUser(String bccUser) {
        this.bccUser.add(bccUser);
    }

    public void setBccUser(List<String> bccUser) {
        this.bccUser = bccUser;
    }
    public List<String> getFiles() {
        return files;
    }

    @Override
    public void addFiles(String file) {
        this.files.add(file);
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
    public Object getDataPlus() {
        return dataPlus;
    }
    public void setDataPlus(Object dataPlus) {
        this.dataPlus = dataPlus;
    }
}
