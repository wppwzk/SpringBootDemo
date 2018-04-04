package com.example.demo.file;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.cs.ext.GBK;

import javax.servlet.ServletContext;
import java.io.*;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/4/410:18
 */

@RestController
@RequestMapping("fileReadController")
public class FileReadController {

    protected ServletContext servletContext;

    @RequestMapping("/readFile")
    public String Read() {
        StringBuilder stringBuilder=new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            File file = ResourceUtils.getFile("classpath:fileRead/newFile.txt");
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
            BufferedReader br = new BufferedReader(inputStreamReader,
                    60 * 1024 * 1024);
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                stringBuilder.append(lineTxt);
                System.out.println(lineTxt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
