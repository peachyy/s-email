package com.upsoft.email.transmission;

import java.util.List;

/**
 * 一封邮件的抽象
 * @author xsTao
 * @date 2016/1/27.
 * @see
 * @since 1.0
 */
public interface Email {
    /**
     * 获取邮件主题
     * @return
     */
    public String getSubject() ;

    /**
     * 设置邮件主题
     * @param subject
     */
    public void setSubject(String subject);

    /**
     * 获取邮件内容
     * @return
     */
    public String getContent();

    /**
     * 设置邮件内容
     * @param content
     */
    public void setContent(String content);

    /**
     * 获取发件人
     * @return
     */
    public List<String> getReceiveUser();
    public void addReceiveUser(String toemail);

    /**
     * 设置发件人
     * @param receiveUser
     */
    public void setReceiveUser(List<String> receiveUser);

    /**
     * 获取文件列表名称
     * @return
     */
    public List<String> getFilenames();
    public void addFilenames(String filename);

    /**
     * 设置文件列表名称
     * @param filenames
     */
    public void setFilenames(List<String> filenames);

    /**
     * 获取抄送用户
     * @return
     */
    public List<String> getCcUser();
    public void addCcUser(String user);
    /**
     * 设置抄送用户
     * @param ccUser
     */
    public void setCcUser(List<String> ccUser);

    /**
     * 获取密送用户
     * @return
     */
    public List<String> getBccUser();
    public void addbccUser(String bccUser);

    /**
     * 设置密送用户
     * @param bccUser
     */
    public void setBccUser(List<String> bccUser);

    /**
     * 获取列表 与文件列表对应
     * @return
     */
    public List<String> getFiles();
    public void addFiles(String file);
    /**
     * 设置文件列表
     * @param files
     */
    public void setFiles(List<String> files);

    /**
     * 获取附加业务数据
     * @return
     */
    public Object getDataPlus();

    /**
     * 设置附加业务数据
     * @param dataPlus
     */
    public void setDataPlus(Object dataPlus);
}
