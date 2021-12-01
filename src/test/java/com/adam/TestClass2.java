package com.adam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestClass2 {
    public static void main(String[] args) throws IOException {
//		// 在包下有student.json文件
//		String filePath = "rule.json";
//
//		List student = Json2ObjectUtil.Json2Object(filePath, List.class);
//		System.out.println("student=" + JSON.toJSONString(student));
//		System.out.println("i=" + i++);
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        System.out.println("i1=i2 " + (i1 == i2));
        System.out.println("i1=i2+i3 " + (i1 == i2 + i3));
        System.out.println("i1=i4 " + (i1 == i4));
        System.out.println("i4=i5 " + (i4 == i5));
        System.out.println("i4=i5+i6 " + (i4 == i5 + i6));
        System.out.println("40=i5+i6 " + (40 == i5 + i6));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        swap(list);
        System.out.println(list);
        String s = "";


    }

    private static void swap(List<Integer> list) {
        list.add(2);
    }

}
