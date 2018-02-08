package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Administrator on 2018/2/8.
 */
public class Token {
    private static final String charset = "utf-8";
    public String salt;
    public int id;//用户id
    public long expires;//过期时间 毫秒数
    public int type;//用户类型


    public static final long minute = 60 * 1000;
    public static final long hour = 60 * minute;
    public static final long day = hour * 24;

    public Token() {
    }

    public Token(int id, int type, long expires) {
        this.id = id;
        this.expires = System.currentTimeMillis() + expires;
        this.type = type;
    }
    //生产随机字符串
    private static String rand(int len){
        int[][] kinds = new int[][]{{10, 48}, {26, 97}, {26, 65}};
        Random random = new Random();
        random.setSeed(System.nanoTime());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int j = random.nextInt(3);
            int scope = kinds[j][0];
            int base = kinds[j][1];
            sb.append(base + random.nextInt(scope));
        }
        return sb.toString();
    }


    //生成TOKEN base64(data+hmac(data,SecretKey))
    public String genToken(String secretKey){
        salt = rand(3);
        String json = JSON.toJSONString(this);

        try {
            SecretKey secret = new SecretKeySpec(secretKey.getBytes(charset), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secret);
            byte[] hmacData = mac.doFinal(json.getBytes(charset));
            //byte[] hexB = new Hex().encode(hmacData);
            String signature = Hex.encodeHexString(hmacData);
            return Base64.encodeBase64URLSafeString((json + signature).getBytes(charset));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return "invalid token";
    }


    //验证token 签名是否一致
    public static Token decodeToken(String token, String secretKey) {
        String data = valid(token, secretKey);
        if (data == null) return null;
        return JSON.parseObject(data, Token.class);
    }

    protected static String valid(String token, String secretKey) {
        if (token == null || token.length() < 32) return null;
        byte[] datas = Base64.decodeBase64(token);
        //split request into signature and data
        if (datas.length < 64) return null;

        String data = null;
        try {
            data = new String(datas, 0, datas.length - 64, charset);
            String signature = new String(datas, datas.length - 64, 64, charset);

            //再进行一次签名匹配数据
            SecretKey secret = new SecretKeySpec(secretKey.getBytes(charset), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secret);
            byte[] hmacData = mac.doFinal(data.getBytes(charset));
            //byte[] hexB = new Hex().encode(hmacData);
            String signature2 = Hex.encodeHexString(hmacData);
            if (!Objects.equals(signature2, signature)) { //签名不匹配

                System.out.println("Token签名不相等，token无效");
                return null;
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            e.printStackTrace();
        }

        return data;
    }

}
