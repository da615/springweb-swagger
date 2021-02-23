package com.adam;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StTest {
    public void find(String path,String reg){
        Pattern pat=Pattern.compile(reg);
        File file=new File(path);
        File[] arr= {file};
        for (File value : arr) {
            //判断是否是文件夹，如果是的话，再调用一下find方法
            /*if (value.isDirectory()) {
                find(value.getAbsolutePath(), reg);
            }*/
            Matcher mat = pat.matcher(value.getAbsolutePath());
            //根据正则表达式，寻找匹配的文件
            if (mat.matches()) {
                //这个getAbsolutePath()方法返回一个String的文件绝对路径
//                System.out.println("路径"+value.getAbsolutePath());
                System.out.println("路径"+value.getName());

                //readExcel(value);
                System.out.println("---------------------");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Map<String ,String> map = new HashMap<>();
        map.put("a","1");
        boolean a = map.containsKey("b");
        if (!a){
            map.put("b","2");
        }
        System.out.println(map);

    }
}
