package com.adam;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesTest {
    public static void main(String[] args) {
//        ClassPathResource resource = new ClassPathResource("D:\\application.properties");
        // 获取文件流
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
//            inputStream = resource.getInputStream();
            File file = new File("D:\\application.properties");
            System.out.println(file.getParent());
            inputStream = new FileInputStream(file);
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
}
