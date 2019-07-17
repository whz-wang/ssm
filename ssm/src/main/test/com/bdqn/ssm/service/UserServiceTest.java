package com.bdqn.ssm.service;

import com.bdqn.ssm.pojo.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class UserServiceTest {


    private Logger logger = Logger.getLogger(this.getClass());
    ApplicationContext context = null;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUserById() throws Exception {
    }

    @Test
    public void login() throws Exception {
    }

    @Test
    public void login1() throws Exception {
    }

    @Test
    public void findUsers() throws Exception {
    }

    @Test
    public void getUserCount() throws Exception {
        UserService userService= (UserService) context.getBean("userService");
        Integer count=userService.getUserCount(null,1);
        logger.info(count);
    }

    @Test
    public void getUserList() throws Exception {
        UserService userService= (UserService) context.getBean("userService");
        List<User> userList = null;
        userList= userService.getUserList(null,null,0,5);
        for (User user:
             userList) {
            logger.info(user.getId()+"——"+user.getUserName()+"——"+user.getRole().getRoleName());
        }
    }

    @Test
    public void modifyUser() throws Exception {
        UserService userService= (UserService) context.getBean("userService");
        User user = new User();
        user.setId(25);
        user.setUserName("杨过儿");
        user.setUserCode("2");
        Integer result=userService.modifyUser(user);
        logger.info(result);
    }

}