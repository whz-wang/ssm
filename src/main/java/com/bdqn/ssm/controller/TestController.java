package com.bdqn.ssm.controller;

import com.bdqn.ssm.error.CommonReturnType;
import com.bdqn.ssm.pojo.Admin;
import com.bdqn.ssm.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/baseType")
    @ResponseBody
    public Object baseType(@RequestParam("userAge") int age){
        return "age:"+age;
    }

    @RequestMapping("/packageType")
    @ResponseBody
    public Object baseType(Iterable age){
        return CommonReturnType.create("age:"+age);
    }

    @RequestMapping("/array")
    @ResponseBody
    public Object array(String[] game){
        StringBuilder stringBuilder =new StringBuilder();
        for (String item:
                game){
            stringBuilder.append(game).append("--");
        }
        return CommonReturnType.create("game的长度："+game.length+"--内容:"+stringBuilder);
    }

    @RequestMapping("/object")
    @ResponseBody
    public Object object(Admin admin){
        return CommonReturnType.create(admin.toString());
    }

    @RequestMapping("/object")
    @ResponseBody
    public Object object(Admin admin, Student student){
        return CommonReturnType.create(admin.toString()+"--"+student.toString());
    }

    @InitBinder("admin")
    public void  initAdmin(WebDataBinder binder){
        binder.setFieldDefaultPrefix("admin.");
    }

    @InitBinder("student")
    public void  initStudent(WebDataBinder binder){
        binder.setFieldDefaultPrefix("student.");
    }
}
