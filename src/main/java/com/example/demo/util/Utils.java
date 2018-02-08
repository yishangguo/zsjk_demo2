package com.example.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.commons.codec.binary.Hex;

public class Utils {

    //日期格式
    public static String getDate(java.util.Date date){
        if (date == null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss", Locale.CHINA);
        return format.format(date);
    }

    //MD5加密
    public static String encodeMd5(String input){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return Hex.encodeHexString(md5.digest(input.getBytes()));
    }

}
