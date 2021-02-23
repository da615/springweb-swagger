package com.adam.controller;

import com.adam.config.JsonCache;
import com.adam.config.RuleProperties;
import io.swagger.annotations.Api;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

@Api(tags = "用户管理")
@RestController
@EnableConfigurationProperties({RuleProperties.class})
public class TestController {

    @Value("${rule.security.file}")
    private String ruleSecurityPath;
    @Value("${rule.facility.file}")
    private String ruleFacilityFile;

    @Autowired
    RuleProperties ruleProperties;

    @Autowired
    JsonCache jsonCache;

    @RequestMapping("/findValue")
    public String findValue(@RequestParam("s") String s){
        String path = "";
        if (s.equalsIgnoreCase("Security")){
            path = ruleSecurityPath;
        }
        if (s.equalsIgnoreCase("Facility")){
           path = ruleFacilityFile;
        }
        return path;
    }

    @RequestMapping("/json")
    public Map<String, Object> json(){
        Map<String, Object> map = JsonCache.jsonMap.get("rule");
        Object fileName = map.get("fileName");

        System.out.println("rule json fileName:" + fileName);
        System.out.println("rule json map:" + map);
        return map;
    }


    @RequestMapping("/t2")
    public String t2(){
        String facilityPath = ruleProperties.getPath();
        System.out.println(facilityPath);
        return "OK t2";
    }


    @RequestMapping("/t")
    public String t(){
        String[] fileName = ruleFacilityFile.split(",");
        for (String file:fileName){
            String path = ruleSecurityPath + File.separator + file + ".xls";
            System.out.println("path======>"+path);
            try {
                InputStream is = new FileInputStream(path);
                Workbook workbook = Workbook.getWorkbook(is);
                Sheet sheet = workbook.getSheet(0);
                for (int i = 0; i < sheet.getRows(); i++) {
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String s = sheet.getCell(j,i).getContents();
                        System.out.println(sheet.getCell(j,0).getContents()+"=>>"+s);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return "OK";
    }


    @RequestMapping("/t3")
    public String t3(@RequestParam("name") String name){
        try {
            // 打开文件
            WritableWorkbook book = Workbook.createWorkbook(new File(
                    "com/adam/t1.xls"));
            // 生成名为“sheet1”的工作表，参数0表示这是第一页
            WritableSheet sheet = book.createSheet("sheet1", 0);
            // 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string
            Label label = new Label(0, 0, "string");
            // 将定义好的单元格添加到工作表中
            sheet.addCell(label);
            // 生成一个保存数字的单元格,单元格位置是第二列，第一行，单元格的内容为1234.5
            Number number = new Number(1, 0, 1234.5);
            sheet.addCell(number);
            // 生成一个保存日期的单元格，单元格位置是第三列，第一行，单元格的内容为当前日期
            DateTime dtime = new DateTime(2, 0, new Date());
            sheet.addCell(dtime);
            // 写入数据并关闭文件
            book.write();
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return "OK";
    }

}
