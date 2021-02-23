package com.adam.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSON;

public class Json2ObjectUtil {

	public static <T> T Json2Object(String jsonFilePath, Class<T> cls) throws IOException {
		// 读取json文件
		ClassPathResource resource = new ClassPathResource(jsonFilePath);
		// 获取文件流
		InputStream inputStream = resource.getInputStream();
		if (null == inputStream) {
			return null;
		}
		String jsontext = IOUtils.toString(inputStream, "utf8");
		// 转为实体类
		T object = JSON.parseObject(jsontext, cls);
		return object;
	}

	public static String Json2Map(String jsonFilePath) throws IOException {
		// 读取json文件
		ClassPathResource resource = new ClassPathResource(jsonFilePath);
		// 获取文件流
		InputStream inputStream = resource.getInputStream();
		if (null == inputStream) {
			return null;
		}
		// 转为实体类
		return IOUtils.toString(inputStream, "utf8");
	}


	public static <T> List<T> Json2List(String jsonFilePath, Class<T> cls) throws IOException {
		ClassPathResource resource = new ClassPathResource(jsonFilePath);
		// 获取文件流
		InputStream inputStream = resource.getInputStream();
		if (null == inputStream) {
			return null;
		}
		String jsontext = IOUtils.toString(inputStream, "utf8");
		List<T> objectList = JSON.parseArray(jsontext, cls);
		return objectList;
	}
}