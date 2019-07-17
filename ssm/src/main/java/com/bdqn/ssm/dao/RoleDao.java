package com.bdqn.ssm.dao;

import com.bdqn.ssm.pojo.Role;

import java.util.List;

/**
 * @ClassName: RoleDao
 * @Description: 角色数据访问层接口
 * @Author: xyf
 * @Date 2019/7/5 13:41
 */
public interface RoleDao {
    /**
     * @Description:查询到所有角色信息
     * @param: []
     * @return: java.util.List<com.bdqn.ssm.pojo.Role>
     * @Date: 2019/07/05 13:49
     */
    List<Role> selectRoles();
}
