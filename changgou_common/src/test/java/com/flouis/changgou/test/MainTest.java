package com.flouis.changgou.test;

import com.flouis.changgou.common.util.ResourceUtil;
import org.junit.Test;

public class MainTest {

	@Test
	public void test(){
		System.out.println(Thread.currentThread().getName());
		String key = "localSaveDirPath";
		String value = ResourceUtil.getProperty(key);
		System.out.println(value);
	}

}
