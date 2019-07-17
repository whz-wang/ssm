package com.bdqn.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.ssm.error.BusinessException;
import com.bdqn.ssm.error.CommonReturnType;
import com.bdqn.ssm.error.EmBusinessError;
import com.bdqn.ssm.pojo.Role;
import com.bdqn.ssm.pojo.User;
import com.bdqn.ssm.service.RoleService;
import com.bdqn.ssm.service.UserService;
import com.bdqn.ssm.utils.Constants;
import com.bdqn.ssm.utils.PageSupport;
import com.mysql.jdbc.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: 用户控制器
 * @Author: xyf
 * @Date 2019/7/4 14:50
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    /**
     * @Description: 跳转到登录页面
     * @param: []
     * @return: java.lang.String
     * @Date: 2019/07/04 17:06
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * @ Description: 跳转到用户列表页（未优化前的页面）
     * @params: * @param
     * @return:java.lang.String
     **/
    @RequestMapping(value = "/userList1")
    public String userList1() {
        return "user/userList1";
    }

    /**
     * @ Description:跳转到用户列表页(优化后)
     * @params: * @param
     * @return:java.lang.String
     **/
    @RequestMapping(value = "/userlist")
    public String userList(Model model) throws Exception {
//        List<User> userList = userService.findUsers();
        List<User> userList = userService.getUserList(null, null, 0, 5);
        List<Role> roleList = roleService.findRoles();
        model.addAttribute("userList", userList);
        model.addAttribute("roleList", roleList);
        return "user/userList";
    }

    /**
     * @Description: 跳转到添加用户界面
     * @param: []
     * @return: java.lang.String
     * @Date: 2019/07/05 12:25
     */
    @RequestMapping(value = "/useradd")
    public String useradd() {
        return "user/useradd";
    }

    /**
     * @Description: 获取所有用户信息
     * @param: []
     * @return: java.util.List<com.bdqn.ssm.pojo.User>
     * @Date: 2019/07/05 12:34
     */
    @ResponseBody
//    @RequestMapping(value = "/getUserListJson",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @RequestMapping(value = "/getUserListJson", method = RequestMethod.POST)
    public Object getUserListJson() {
        return JSON.toJSONString(userService.findUsers());
    }

    @RequestMapping(value = "/main")
    public String main(HttpSession session) {
//        安全验证
        if (session.getAttribute(Constants.USER_SESSION) == null) {
            return "redirect:/user/login";
        }
        return "frame";
    }

    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute(Constants.USER_SESSION);
        return "redirect:/user/login";
    }

    @ResponseBody
    @RequestMapping(value = "findUserByUserCode",method = RequestMethod.POST)
    public Object findUserByUserCode(@RequestParam("userCode") String userCode) {


        HashMap<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNullOrEmpty(userCode)) {
            map.put("userCode", "exist");
        } else {
            User user = userService.findUserByUserCode(userCode);

            if (user != null) {
                map.put("userCode", "exist");
            } else {
                map.put("userCode","noExist");
            }
        }
        return map;
//        return JSON.toJSON(userCode);
    }

    @ResponseBody
    @RequestMapping(value = "findUserByUserCode",method = RequestMethod.GET)
    public Object findUserByUserCode1(@RequestParam("userCode") String userCode) throws BusinessException {

            User user = userService.findUserByUserCode(userCode);
            if (user==null){
                throw new BusinessException(EmBusinessError.UNFINDUSER_ERROR);
            }

        return CommonReturnType.create(JSON.toJSON(user));
//        return JSON.toJSON(userCode);
    }
    /**
     * @Description: 处理  http://localhost:8080/ms/user/findUserById/uId 请求
     * @param: [uId, model]
     * @return: java.lang.String
     * @Date: 2019/07/04 15:07
     */
    @RequestMapping(value = "/findUserById/{uId}", method = RequestMethod.GET)
    public String findUserById(@PathVariable(value = "uId", required = false) Integer uId, Model model) throws RuntimeException {
        //调取相应Model 业务逻辑数据
        User user = userService.findUserById(uId);
        if (user == null) {
            throw new RuntimeException("无法查询到用户信息！");
        }
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/findUsers", method = RequestMethod.POST)
    public String findUsers(Model model) {
        //调取相应Model 业务逻辑数据
        List<User> userList = userService.findUsers();
        model.addAttribute("userList", userList);
        return "user/userList1";
    }


    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(@RequestParam("userCode") String userCode, @RequestParam("userPassword") String userPassword, Model model) {
        if (userService.login(userCode, userPassword)) {//登录成功
            model.addAttribute("userCode", userCode);
            return "user";
        } else {//登录失败
            return "login";
        }
    }

    /**
     * @param userPassword
     * @param request
     * @param session
     * @ Description: 处理用户登录
     * @params: * @param userCode
     * @return:java.lang.String
     **/
    @RequestMapping(value = "/doLogin1", method = RequestMethod.POST)
    public String doLogin1(@RequestParam("userCode") String userCode,
                           @RequestParam("userPassword") String userPassword,
                           HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User user = userService.login1(userCode, userPassword);
        if (user != null) {//登录成功
            //放入session
            session.setAttribute(Constants.USER_SESSION, user);
            //页面跳转（frame.jsp）重定向到main.html
            return "redirect:/user/main";
//            return "forward:/user/main";
//            request.getRequestDispatcher("").forward(request,response);
//            response.sendRedirect("jsp/frame.jsp");
        } else {//登录失败'
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "用户名或密码不正确");
            return "forward:/user/login";
        }
    }

    @RequestMapping(value = "/doLogin2", method = RequestMethod.POST)
    public String doLogin2(@RequestParam("userCode") String userCode,
                           @RequestParam("userPassword") String userPassword,
                           HttpServletRequest request, HttpSession session) {
        User user = userService.login1(userCode, userPassword);
        if (user == null) {//登录失败
            throw new RuntimeException("用户名或者密码不正确！");
        }
        return "redirect:/user/main";
    }

//    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @RequestMapping(value = "/getUserList")
    public String getUserList(Model model,
                              @RequestParam(value = "queryname", required = false) String queryUserName,
                              @RequestParam(value = "queryUserRole", required = false) String queryUserRole,
                              @RequestParam(value = "pageIndex", required = false) String pageIndex) throws RuntimeException {
        Integer _queryUserRole = 0;
        List<User> userList = null;
        //设置页面容量
        int pageSize = Constants.PAGESIZE;
        //当前页码
        int currentPageNo = 1;
        if (queryUserName == null) {
            queryUserName = "";
        }
        if (queryUserRole != null && !queryUserRole.equals("")) {
            _queryUserRole = Integer.parseInt(queryUserRole);
        }
        if (pageIndex != null) {
            currentPageNo = Integer.valueOf(pageIndex);
        }
        //总数量（表）
        int totalCount = userService.getUserCount(queryUserName, _queryUserRole);
        //总页数
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        int from = (currentPageNo - 1) * pageSize;
        userList = userService.getUserList(queryUserName, _queryUserRole, from, pageSize);
        model.addAttribute("userList", userList);
        List<Role> roleList = null;
        roleList = roleService.findRoles();
        model.addAttribute("roleList", roleList);
        model.addAttribute("queryUserName", queryUserName);
        model.addAttribute("queryUserRole", queryUserRole);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "user/userList";
    }

    @RequestMapping(value="/usermodify.html",method=RequestMethod.GET)
    public String modifyHtml(@RequestParam String uid,Model model){
        logger.debug("getUserById uid===================== "+uid);
        User user = userService.getUserById(uid);
        model.addAttribute(user);
        return "user/usermodify";
    }

    /**
     * @ Description: 处理局部异常(测试)
     * @params:  * @param e
     * @param request
     * @return:java.lang.String
     **/
   /* @ExceptionHandler(value = {RuntimeException.class})
    public String handlerException(RuntimeException e, HttpServletRequest request){
        request.setAttribute("e",e);
        return "common/error";
    }*/


}
