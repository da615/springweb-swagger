package com.adam;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

public class MyTest {
    public static void main(String[] args) {
        MyTest obj = new MyTest();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("src/main/resources/rules/region/sieId/t1.xls");
        obj.readExcel(file);

        Map map = new ConcurrentHashMap();
        List list = new CopyOnWriteArrayList();
        Queue queue = new ConcurrentLinkedDeque();
        Map map1 = new ConcurrentSkipListMap();
//        Executor executor = new ThreadPoolExecutor();


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
                for (int i = 0; i < sheet.getRows(); i++) {
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
