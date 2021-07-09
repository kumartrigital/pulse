/**
 * 
 */
package com.gss.pulseworkflow.oauth.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

/**
 * @author SAURABH
 *
 */
@Component
public class PulseEncryption {

    private SecretKeySpec buildSecretKey(String secretKey) {
        try {
            byte[] key = secretKey.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            return new SecretKeySpec(key, "AES");
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("Invalid secret key", e);
        }
    }

    public String encrypt(String strToEncrypt, String secret) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, buildSecretKey(secret));
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("Unable encrypt message", e);
        }
    }

    public String decrypt(String strToDecrypt, String secret) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, buildSecretKey(secret));
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt.getBytes("UTF-8"))));
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("Unable decrypt message", e);
        }

    }

}
