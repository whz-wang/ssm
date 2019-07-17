package com.bdqn.ssm.controller;

import com.bdqn.ssm.pojo.Role;
import com.bdqn.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: RoleController
 * @Description: 角色控制器
 * @Author: xyf
 * @Date 2019/7/10 10:49
 */
@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/roleList")
    public Object getRolesName(){
        return roleService.findRoles();
    }
}
