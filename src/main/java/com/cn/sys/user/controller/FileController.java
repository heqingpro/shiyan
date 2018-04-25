package com.cn.sys.user.controller;


import com.cn.sys.user.utils.XmlHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class FileController {

    @RequestMapping(value="/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam MultipartFile file, HttpServletRequest request)throws IOException{
        String path="";//"D:\\javaweb\\nginx-1.12.2\\staticResources\\static\\image";
        String xmlPath="/uploadFile.xml";
        XmlHandler xmlHandler=new XmlHandler();
        try {
            xmlHandler.loadXmlFile(this.getClass().getResource(xmlPath).getFile());
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        List list=xmlHandler.getDataList("/config/uploadFile/nginx");
        HashMap map=(HashMap) list.get(0);
        path=(String) map.get("uploadPath");

        String fileName=file.getOriginalFilename();
        File dir=new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        System.out.print("dir.exists()>>"+dir.exists());

        file.transferTo(dir);

        return "OK";
    }
}
