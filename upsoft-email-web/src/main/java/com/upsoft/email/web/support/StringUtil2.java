package com.upsoft.email.web.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xsTao
 * @date 2016/2/2.
 * @see
 * @since 1.0
 */
public class StringUtil2 {
    private static String  patternString ="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private static Pattern pattern = Pattern.compile(patternString);
    public static boolean isValidateEmail(String email){
        Matcher mat = pattern.matcher(email);
        if (!mat.find())
            return false;
        return true;
    }
//    public static  void main(String[] args){
//        System.out.println(isValidateEmail("fasdf"));
//    }
}
