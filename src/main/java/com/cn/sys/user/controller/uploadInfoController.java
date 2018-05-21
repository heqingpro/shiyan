package com.cn.sys.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value="/upload")
public class uploadInfoController {
    @RequestMapping(value ="/result")
    @ResponseBody
    public String uploadResult(@RequestBody Map<String,String> map){
        int id=Integer.parseInt(map.get("id"));
        String name=map.get("name");
        String labId=map.get("labId");
        String picture=map.get("picture");
        String labResult=map.get("result");
        return "success";
    }
}
