package org.zsl.testmybatis;
import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import com.alibaba.fastjson.JSON;  
import com.cn.sys.user.pojo.Lab; 
import com.cn.sys.user.service.LabService; 

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestLabMybatis {
    private static Logger logger = Logger.getLogger(TestStuMybatis.class);  
    @Resource  
    private LabService labService = null;  
    
    @Test  
    public void test1() {  
        Lab lab = labService.getNameByNumber("001"); 
       // int id=studentService.delectByName("张三");
        logger.info(JSON.toJSONString(lab));  
    }  

}