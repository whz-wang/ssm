package com.bdqn.ssm.controller;

import com.bdqn.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("roleList")
    public Object getRoleName(){
        return roleService.findRoles();
    }
}
