package com.adam;

import com.adam.config.Json2ObjectUtil;
import com.adam.config.Rule;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

public class TestClass2 {
	public static void main(String[] args) throws IOException {
		// 在包下有student.json文件
		String filePath = "rule.json";

		List student = Json2ObjectUtil.Json2Object(filePath, List.class);
		System.out.println("student=" + JSON.toJSONString(student));
	}





}
 