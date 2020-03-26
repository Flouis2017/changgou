package com.flouis.changgou.gateway.system.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class MainTest {

	@Test
	public void testBcypt(){
		String originalPwd = "123456";
		for (int i = 0; i < 3; i++){
			String salt = BCrypt.gensalt();
//			String salt = "19951210";
			System.out.println("salt:" + salt);
			String saltyPwd = BCrypt.hashpw(originalPwd, salt);
			System.out.println(saltyPwd);
			boolean flag = BCrypt.checkpw(originalPwd, saltyPwd);
			System.out.println(flag ? "校验成功\n" : "校验失败\n");
		}
	}

	@Test
	public void test(){
		String str = "$2a$10$xswfl4j4zGaNNL3eS9atxuOR0Qa8CRr3u6fvN38wsBW0QWgfJIMYe";
		System.out.println(str.length());
	}

}
