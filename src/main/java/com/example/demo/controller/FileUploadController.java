package com.example.demo.controller;


import ch.qos.logback.core.util.FileUtil;
import com.example.demo.entity.Result;
import com.example.demo.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 *
 *文件上传操作
 *创建文件/保存文件的时候使用绝对路径，写入数据库的时候用相对路径
 *
 * */

@MultipartConfig
@Controller
public class FileUploadController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public boolean upload(@RequestParam("file") MultipartFile file) throws IOException, ServletException {
        //获取文件类型（可以判断如果不是图片，禁止上传）
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名：" + fileName);
        System.out.println("文件类型：" + contentType);
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为："+suffixName);
//        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
//        System.out.println("filePath-->"+filePath);
//        String filePath = "E:\\ZSJK\\demo2\\src\\main\\resources\\static\\upload\\";

        //文件存储在工程resources/static/upload路径下
        String filePath = ".\\src\\main\\resources\\static\\upload\\";
        try {
            uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        Result result = new Result();
        result.setFlag(3);
        return true;
//        Part part = request.getPart("file");
//        if (part == null){
//            System.out.println("part = null");
//            System.out.println("缺少图片");
//            return;
//        }
//        //Paths NIO  MSIE fix.
//        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
//        System.out.println("file name: "+fileName);
//        InputStream fileContent = part.getInputStream();
//        File dir = new File(Config.TMP_FILE_DIR);
//        if (!dir.exists()){
//            dir.mkdirs();
//        }
//        String prefix = null;
//        String extend = ".jpg";
//        String savedFileName = prefix+"_"+System.currentTimeMillis()+extend;
//        File tempFile = new File(dir,savedFileName);
//        System.out.println(tempFile.getAbsolutePath());
//        Files.copy(fileContent,tempFile.toPath());
//        System.out.println(tempFile.getAbsolutePath());
//        String src = Config.TMP_FILE_SRC+savedFileName;
//
//        System.out.println("success~");


//        if (file.isEmpty()){
//            try {
//                BufferedOutputStream outputStream = new BufferedOutputStream(
//                        new FileOutputStream(new File(file.getOriginalFilename()))
//                );
//                outputStream.write(file.getBytes());
//                outputStream.flush();
//                outputStream.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
