package com.bdqn.ssm.controller;

import com.bdqn.ssm.pojo.Provider;
import com.bdqn.ssm.service.ProviderService;
import com.bdqn.ssm.utils.Constants;
import com.bdqn.ssm.utils.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName: ProviderController
 * @Description: 供应商控制器
 * @Author: xyf
 * @Date 2019/7/5 10:25
 */
@Controller
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping(value = "/providerList")
    public String userList(Model model) {
        List<Provider> providerList = providerService.getProviderList(null, null, 1, 5);
        model.addAttribute("providerList", providerList);
        return "provider/providerList";
    }


    @RequestMapping(value = "/getProviderList", method = RequestMethod.POST)
    public String getProviderList(Model model,
                                  @RequestParam(value = "queryProCode", required = false) String queryProCode,
                                  @RequestParam(value = "queryProName", required = false) String queryProName,
                                  @RequestParam(value = "pageIndex", required = false) String pageIndex) {
        List<Provider> providerList = null;
        //设置页面容量
        int pageSize = Constants.PAGESIZE;
        //当前页码
        int currentPageNo = Constants.CURRENTPAGENO;

        if (queryProCode == null) {
            queryProCode = "";
        }
        if (queryProName == null) {
            queryProName = "";
        }
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
            } catch (NumberFormatException e) {
                return "redirect:/common/error";
            }
        }

        //总数量（表）
        int totalCount = providerService.getproviderCount(queryProCode, queryProName);
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
        providerList = providerService.getProviderList(queryProName, queryProCode, from, pageSize);
        model.addAttribute("providerList", providerList);
        model.addAttribute("queryProCode", queryProCode);
        model.addAttribute("queryProName", queryProName);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "provider/providerList";
    }
}
