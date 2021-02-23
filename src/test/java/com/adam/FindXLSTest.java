package com.adam;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindXLSTest {

    public void find(String path,String reg){
        Pattern pat=Pattern.compile(reg);
        File file=new File(path);
        File[] arr=file.listFiles();
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

    public static void main(String[] args) throws IOException{
        new FindXLSTest().find("E:\\hsbc", "\\S+\\.xls");

    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public void readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 1; i < sheet.getRows(); i++) {
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        System.out.println("--------------"+cellinfo);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
