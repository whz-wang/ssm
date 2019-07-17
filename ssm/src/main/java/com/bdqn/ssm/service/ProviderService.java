package com.bdqn.ssm.service;

import com.bdqn.ssm.pojo.Provider;

import java.util.List;

/**
 * @ClassName: ProviderService
 * @Description: 供应商业务接口
 * @Author: xyf
 * @Date 2019/7/5 10:24
 */
public interface ProviderService {

    /**
     * @Description: 查询供应商数量
     * @param: [queryProCode, queryProName]
     * @return: int
     * @Date: 2019/07/05 10:36
     */
    int getproviderCount(String queryProCode, String queryProName) throws RuntimeException;

    /**
     * @Description: 查询到供应商信息
     * @param: [queryProName, queryProCode, currentPageNo, pageSize]
     * @return: java.util.List<com.bdqn.ssm.pojo.Provider>
     * @Date: 2019/07/05 10:49
     */
    List<Provider> getProviderList(String queryProName, String queryProCode, int from, int pageSize) throws RuntimeException;
}
