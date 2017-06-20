package com.skyer.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * 配置文件读取工具类
 * 
 * @author SKYER
 */
public class PropertyUtil {

	/**
	 * 读取配置文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static List<String> readProperties(String fileName) {
		List<String> list = new ArrayList<String>();
		Properties properties = new Properties();
		try {
			properties.load(PropertyUtil.class.getClassLoader().getResourceAsStream(fileName));
			Iterator<Object> it = properties.keySet().iterator();
			while (it.hasNext())
				list.add((String) it.next());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list.size() > 0 ? list : null;
	}

}
