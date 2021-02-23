package com.adam;

import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("application.properties");
        // 获取文件流
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            inputStream = resource.getInputStream();
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        for (Object p: properties.keySet()){
            System.out.println(p + "：" + properties.getProperty((String) p));

        }

    }

    static String checkNum(int i){
        System.out.println(i + "***");
        if (i == 3){
            return "3++";
        }
        return "oo " + i;
    }
}
