package com.bdqn.ssm.service.impl;

import com.bdqn.ssm.dao.RoleDao;
import com.bdqn.ssm.pojo.Role;
import com.bdqn.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: RoleServiceImpl
 * @Description: 角色相关的业务的实现类
 * @Author: xyf
 * @Date 2019/7/5 13:40
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;
    /**
     * @Description: 找到所有角色
     * @param: []
     * @return: java.util.List<com.bdqn.ssm.pojo.Role>
     * @Date: 2019/07/05 13:44
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Role> findRoles() throws RuntimeException {
        return roleDao.selectRoles();
    }
}
