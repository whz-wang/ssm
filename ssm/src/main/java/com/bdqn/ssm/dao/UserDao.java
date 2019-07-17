package com.bdqn.ssm.dao;

import com.bdqn.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: UserDao
 * @Description: 用户数据访问层接口
 * @Author: xyf
 * @Date 2019/7/4 14:58
 */
@Repository
public interface UserDao {

    /**
     * @Description: 通过id在数据库中查找到User信息
     * @param: [uId]
     * @return: com.bdqn.ssm.pojo.User
     * @Date: 2019/07/04 15:12
     */
    User selectUserById(@Param("uId") Integer uId);

    /**
     * @Description:通过userCode和userPassword查找到用户
     * @param: [userCode, userPassword]
     * @return: com.bdqn.ssm.pojo.User
     * @Date: 2019/07/04 17:27
     */
    User selectUser(@Param("userCode")String userCode,@Param("pwd") String userPassword);

    /**
     * @ Description:
     * @params:  * @param
     * @return:java.util.List<com.bdqn.ssm.pojo.User>
     **/
    List<User> selectUsers();

    /**
     * @Description: 得到到通过角色和用户名查询的用户数量
     * @param: [queryUserName, queryUserRole]
     * @return: int
     * @Date: 2019/07/05 13:59
     */
    int selectUserCount(@Param("uName") String queryUserName,@Param("uRole") Integer queryUserRole);

    /**
     * @Description: 获取模糊查询用户信息的分页信息
     * @param: [queryUserName, queryUserRole, from, pageSize]
     * @return: java.util.List<com.bdqn.ssm.pojo.User>
     * @Date: 2019/07/05 14:33
     */
    List<User> getUserList(@Param("uName")String queryUserName,
                           @Param("uRole") Integer queryUserRole,
                           @Param("from") int from,
                           @Param("pageSize") int pageSize);

    /**
     * @Description:获取用户信息通过用户编码
     * @param: [userCode]
     * @return: com.bdqn.ssm.pojo.User
     * @Date: 2019/07/11 10:08
     */
    User selectUserByUCode(@Param("userCode")String userCode);

    /**
     * @Description: 数据库中新增用户
     * @param: [user]
     * @return: java.lang.Integer
     * @Date: 2019/07/11 11:44
     */
    Integer insertUser(User user);

    /**
     * @Description:数据库中删除用户
     * @param: [userId]
     * @return: java.lang.Integer
     * @Date: 2019/07/12 10:07
     */
    Integer deleteUser(@Param("userId") Integer userId);

    /**
     * @Description: 数据库中修改用户信息
     * @param: [user]
     * @return: java.lang.Integer
     * @Date: 2019/07/12 11:45
     */
    Integer updateUser(User user);
}
