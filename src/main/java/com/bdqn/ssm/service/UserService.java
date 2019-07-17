package com.bdqn.ssm.service;

import com.bdqn.ssm.pojo.User;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description: 用户业务接口（让控制器引用）
 * @Author: xyf
 * @Date 2019/7/4 14:55
 */
public interface UserService {
    /**
     * @Description: 通过id查找用户信息
     * @param: [uId]
     * @return: com.bdqn.ssm.pojo.User
     * @Date: 2019/07/04 15:08
     */
    User findUserById(Integer uId)throws RuntimeException;

    /**
     * @Description: 用户登录
     * @param: [userCode, userPassword]
     * @return: boolean
     * @Date: 2019/07/04 17:24
     */
    boolean login(String userCode, String userPassword) throws RuntimeException;

    /**
     * @ Description:用户登录（更新）
     * @params:  * @param userCode
     * @param userPassword
     * @return:com.bdqn.ssm.pojo.User
     **/
    User login1(String userCode, String userPassword) throws RuntimeException;

    /**
     * @ Description:查找到所有用户
     * @params:  * @param
     * @return:java.util.List<com.bdqn.ssm.pojo.User>
     **/
    List<User> findUsers() throws RuntimeException;

    /**
     * @Description: 获取模糊查询用户的数量
     * @param: [queryUserName, queryUserRole]
     * @return: int
     * @Date: 2019/07/05 13:57
     */
    int getUserCount(String queryUserName, Integer queryUserRole)throws RuntimeException;

    /**
     * @Description: 查询
     * @param: [queryUserName, queryUserRole, currentPageNo, pageSize]
     * @return: java.util.List<com.bdqn.ssm.pojo.User>
     * @Date: 2019/07/05 14:07
     */
    List<User> getUserList(String queryUserName, Integer queryUserRole, int from, int pageSize)throws RuntimeException;;

    /**
     * @Description: 通过id获取用户信息
     * @param: [uid]
     * @return: com.bdqn.ssm.pojo.User
     * @Date: 2019/07/10 8:46
     */
    User getUserById(String uid) throws RuntimeException;

    User findUserByUserCode(String userCode)throws RuntimeException;


}


