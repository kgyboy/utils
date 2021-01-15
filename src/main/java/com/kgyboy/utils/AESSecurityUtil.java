package com.kgyboy.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Random;

/**
 * @ClassName AESSecurityUtil
 * @Description //TODO
 * @Author yangsibiao
 * @Date 2019/10/12
 */
public class AESSecurityUtil {
    public static final String ALGORITHM = "AES";
    public static final String CHARSET = "utf-8";

    public AESSecurityUtil() {
    }

    public static String encrypt(String data, String key) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHARSET), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(1, secretKeySpec);
        byte[] encryptValue = cipher.doFinal(data.getBytes(CHARSET));
        Base64 base64 = new Base64();
        byte[] encodeValue = base64.encode(encryptValue);
        return new String(encodeValue, CHARSET);
    }

    public static String decrypt(String data, String key) throws GeneralSecurityException, UnsupportedEncodingException {
        Base64 base64 = new Base64();
        byte[] decodeValue = base64.decode(data.getBytes(CHARSET));
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHARSET), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(2, secretKeySpec);
        byte[] decryptValue = cipher.doFinal(decodeValue);
        return new String(decryptValue, CHARSET);
    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; ++i) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String data = "百望股份-让天下没有难开的发票1,百望股份-让天下没有难开的发票,百望股份-让天下没有难开的发票,百望股份-让天下没有难开的发票,百望股份-让天下没有难开的发票";
        String key = "BWCSDK2017090688";
        String text = encrypt(data, key);
        System.out.println(text);
        System.out.println(decrypt(text, key));
    }
}

