package com.llynx.cmn.crypt;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 *  NMS에서 dummy 사용자 로그인을 위해 요청한 URL에 대해 복호화 처리 class
 * @Class Name : AES256Cipher.java
 * @Description : AES256Cipher Class
 * @author USER
 * @since 2020-10-08
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-10-08  USER         최초생성
 *
 *</pre>
 */
public class AES256Cipher {
	private static volatile AES256Cipher INSTANCE;

	final static String SecretKey = "UTSYCROS256";
	static SecretKey SecureKey;
	static IvParameterSpec IVParameter;

	public static AES256Cipher getIntance() throws Exception {
		if (null == INSTANCE) {
			synchronized(AES256Cipher.class) {
				if (null == INSTANCE) {
					INSTANCE = new AES256Cipher();
				}
			}
		}

		return INSTANCE;
	}

	private AES256Cipher() throws Exception {
		byte[] encryptKey;
		byte[] iv;
		byte[] tempKey = MessageDigest.getInstance("SHA-256").digest(SecretKey.getBytes("UTF-8"));

		encryptKey = Arrays.copyOf(tempKey, 32);
		iv = Arrays.copyOf(tempKey, 16);

		SecureKey = new SecretKeySpec(encryptKey, "AES");
		IVParameter = new IvParameterSpec(iv);

		INSTANCE = this;
	}

	public String encode(String plainText) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, SecureKey, IVParameter);

		byte[] encryptedData = cipher.doFinal(plainText.getBytes("UTF-8"));

		return new String(Base64.encodeBase64(encryptedData));
	}

	public String decode(String encryptedText) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		cipher.init(Cipher.DECRYPT_MODE, SecureKey, IVParameter);

		byte[] data = Base64.decodeBase64(encryptedText.getBytes("UTF-8"));

		return new String(cipher.doFinal(data), "UTF-8");
	}
}
