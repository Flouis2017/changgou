package com.flouis.changgou.gateway.system.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * JWT校验工具类
 */
public class JwtUtil {

	//有效期为
	public static final Long JWT_TTL = 3600000L; // 60 * 60 *1000 一个小时
	//设置密匙明文
	public static final String JWT_KEY = "whosyourdady";

	public static SecretKey generalKey() {
		byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}

	/**
	 * 解析token
	 */
	public static Claims parseJWT(String jwt) throws Exception {
		SecretKey secretKey = generalKey();
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
		System.out.println(claims);
		return claims;
	}

}
