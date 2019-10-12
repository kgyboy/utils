package com.kgyboy.utils;

/**
 * @ClassName dd
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2019/10/12
 **/

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Random;

public class AESSecurityUtil {
    public static final String ALGORITHM = "AES";
    public static final String Charsets = "utf-8";

    public AESSecurityUtil() {
    }

    public static String encrypt(String data, String key) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        byte[] encryptValue = cipher.doFinal(data.getBytes("utf-8"));
        Base64 base64 = new Base64();
        byte[] encodeValue = base64.encode(encryptValue);
        return new String(encodeValue, "utf-8");
    }

    public static String decrypt(String data, String key) throws GeneralSecurityException, UnsupportedEncodingException {
        Base64 base64 = new Base64();
        byte[] decodeValue = base64.decode(data.getBytes("utf-8"));
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        byte[] decryptValue = cipher.doFinal(decodeValue);
        return new String(decryptValue, "utf-8");
    }

    public static void main(String[] args) throws Exception {
        String data = "百望股份-让天下没有难开的发票1,百望股份-让天下没有难开的发票,百望股份-让天下没有难开的发票,百望股份-让天下没有难开的发票,百望股份-让天下没有难开的发票";
        String key = "BWCSDK2017090688";
        String text = encrypt(data, key);
        System.out.println(text);
        System.out.println(decrypt(text, key));
    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }
}

