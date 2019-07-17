package com.bdqn.ssm.service.impl;

import com.bdqn.ssm.dao.UserDao;
import com.bdqn.ssm.pojo.User;
import com.bdqn.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: : 用户业务接口（让控制器引用）实现类
 * @Author: xyf
 * @Date 2019/7/4 14:56
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    /**
     * @param uId
     * @Description: 通过id查找用户信息
     * @param: [uId]
     * @return: com.bdqn.ssm.pojo.User
     * @Date: 2019/07/04 15:08
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findUserById(Integer uId) throws RuntimeException{

        return userDao.selectUserById(uId);
    }

    /**
     * @param userCode
     * @param userPassword
     * @Description: 用户登录
     * @param: [userCode, userPassword]
     * @return: boolean
     * @Date: 2019/07/04 17:24
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public boolean login(String userCode, String userPassword) {
        boolean flag = false;
        if (userDao.selectUser(userCode,userPassword)!=null){
            flag = true;
        }
        return flag;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User login1(String userCode, String userPassword) throws RuntimeException {
        return userDao.selectUser(userCode,userPassword);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findUsers() throws RuntimeException {
        return userDao.selectUsers();
    }

    /**
     * @param queryUserName
     * @param queryUserRole
     * @Description: 获取模糊查询用户的数量
     * @param: [queryUserName, queryUserRole]
     * @return: int
     * @Date: 2019/07/05 13:57
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int getUserCount(String queryUserName, Integer queryUserRole) throws RuntimeException {
        return userDao.selectUserCount(queryUserName,queryUserRole);
    }

    /**
     * @param queryUserName
     * @param queryUserRole
     * @param from
     * @param pageSize
     * @Description: 查询
     * @param: [queryUserName, queryUserRole, currentPageNo, pageSize]
     * @return: java.util.List<com.bdqn.ssm.pojo.User>
     * @Date: 2019/07/05 14:07
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> getUserList(String queryUserName, Integer queryUserRole, int from, int pageSize) throws RuntimeException {
        List<User> userList = null;
        userList = userDao.getUserList(queryUserName,queryUserRole,from,pageSize);
        return userList;
    }

    /**
     * @param uid
     * @Description: 通过id获取用户信息
     * @param: [uid]
     * @return: com.bdqn.ssm.pojo.User
     * @Date: 2019/07/10 8:46
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User getUserById(String uid) throws RuntimeException {
        return userDao.selectUserById(Integer.valueOf(uid));
    }

    /**
     * @param userCode
     * @Description: 通过用户编码查询到用户信息
     * @param: [userCode]
     * @return: com.bdqn.ssm.pojo.User
     * @Date: 2019/07/11 10:07
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findUserByUserCode(String userCode) throws RuntimeException {
        return userDao.selectUserByUCode(userCode);
    }

    /**
     * @param user
     * @Description: 添加用户
     * @param: [user]
     * @return: boolean
     * @Date: 2019/07/11 11:41
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public boolean addUser(User user) throws RuntimeException {
        boolean flag = false;
        if (userDao.insertUser(user)==1){
            flag = true;
        }
        return  flag;
    }

    /**
     * @param userId
     * @Description:删除用户
     * @param: [userId]
     * @return: java.lang.Integer
     * @Date: 2019/07/12 10:06
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public Integer delUser(Integer userId) throws RuntimeException {
        return userDao.deleteUser(userId);
    }

    /**
     * @param user
     * @Description: 修改用户
     * @param: [user]
     * @return: java.lang.Integer
     * @Date: 2019/07/12 11:42
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public Integer modifyUser(User user) throws RuntimeException {
        return userDao.updateUser(user);
    }
}
