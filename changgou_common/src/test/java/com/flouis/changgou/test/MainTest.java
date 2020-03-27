package com.flouis.changgou.test;

import com.flouis.changgou.common.util.IdWorker;
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

	@Test
	public void testIdWorker(){
		IdWorker idWorker = new IdWorker(0,0);

		for(int i=0;i<1;i++){
			long nextId = idWorker.nextId();
			System.out.println(nextId);
		}
	}

}
