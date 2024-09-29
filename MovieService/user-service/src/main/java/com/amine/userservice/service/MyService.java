package com.amine.userservice.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class MyService {
    
	private static final String ALGORITHM = "AES";
    private static final String KEY = "my-secret-key-123";
    private static final String SALT = "my-salt-123";

    public String encrypt(String value) throws Exception {
        byte[] salt = SALT.getBytes(StandardCharsets.UTF_8);
        KeySpec keySpec = new PBEKeySpec(KEY.toCharArray(), salt, 65536, 128);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] keyBytes = secretKeyFactory.generateSecret(keySpec).getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String value) throws Exception {
        byte[] salt = SALT.getBytes(StandardCharsets.UTF_8);
        KeySpec keySpec = new PBEKeySpec(KEY.toCharArray(), salt, 65536, 128);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] keyBytes = secretKeyFactory.generateSecret(keySpec).getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decodedValue = Base64.getDecoder().decode(value);
        byte[] decryptedBytes = cipher.doFinal(decodedValue);
        return new String(decryptedBytes);
    }
}