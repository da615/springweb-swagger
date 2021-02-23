package com.adam.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author ASUS
 */
@Component
public class JsonCache {
    public static Map<String, Map<String, Object>> jsonMap = new HashMap<>();
    public static Map<String, String> proMap = new HashMap<>();

    @PostConstruct
    public void init() {
        System.out.println("系统启动中。。。加载codeMap");
        try {
            String path = "rule.json";
            String s = Json2ObjectUtil.Json2Map(path);
            jsonMap = JSON.parseObject(s, new TypeReference<Map<String, Map<String, Object>>>() {
            });
            System.out.println("jsonMap:" + jsonMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("系统启动中。。。加载Properties");
        String path = "D:\\application.properties";
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            inputStream = new FileInputStream("D:\\application.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Object p : properties.keySet()) {
            proMap.put((String)p,properties.getProperty((String)p));
        }
        System.out.println("proMap:" + proMap);

    }

    @PreDestroy
    public void destroy() {
        System.out.println("系统运行结束");
    }
}