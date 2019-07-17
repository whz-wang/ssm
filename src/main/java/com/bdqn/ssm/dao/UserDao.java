package com.bdqn.ssm.dao;

import com.bdqn.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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



    User selectUserByUCode(@RequestParam("userCode") String userCode);
}
