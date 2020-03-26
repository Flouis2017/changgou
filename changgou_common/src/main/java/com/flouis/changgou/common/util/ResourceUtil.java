package com.flouis.changgou.common.util;

import java.util.ResourceBundle;

public class ResourceUtil {

	private static ResourceBundle bundle = null;

	public static String getProperty(String key){
		if (bundle == null){
			bundle = ResourceBundle.getBundle("config.dev");
		}
		return bundle.getString(key);
	}

}
