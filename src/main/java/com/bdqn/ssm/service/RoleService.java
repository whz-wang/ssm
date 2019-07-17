package com.bdqn.ssm.service;

import com.bdqn.ssm.pojo.Role;

import java.util.List;

/**
 * @ClassName: RoleService
 * @Description: 角色相关的业务
 * @Author: xyf
 * @Date 2019/7/5 13:40
 */
public interface RoleService {
    /**
     * @Description: 找到所有角色
     * @param: []
     * @return: java.util.List<com.bdqn.ssm.pojo.Role>
     * @Date: 2019/07/05 13:44
     */
    List<Role> findRoles()throws RuntimeException;
}
