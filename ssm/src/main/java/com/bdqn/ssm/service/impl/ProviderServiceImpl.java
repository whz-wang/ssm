package com.bdqn.ssm.service.impl;

import com.bdqn.ssm.dao.ProviderDao;
import com.bdqn.ssm.pojo.Provider;
import com.bdqn.ssm.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProviderServiceImpl
 * @Description: 供应商业务接口实现类
 * @Author: xyf
 * @Date 2019/7/5 10:24
 */
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderDao providerDao;
    /**
     * @param queryProCode
     * @param queryProName
     * @Description: 查询供应商数量
     * @param: [queryProCode, queryProName]
     * @return: int
     * @Date: 2019/07/05 10:36
     */
    @Override
    public int getproviderCount(String queryProCode, String queryProName) throws RuntimeException {
        return providerDao.selectProCount(queryProCode,queryProName);
    }

    /**
     * @param queryProName
     * @param queryProCode
     * @param from
     * @param pageSize
     * @Description: 查询到供应商信息
     * @param: [queryProName, queryProCode, currentPageNo, pageSize]
     * @return: java.util.List<com.bdqn.ssm.pojo.Provider>
     * @Date: 2019/07/05 10:49
     */
    @Override
    public List<Provider> getProviderList(String queryProName, String queryProCode, int from, int pageSize) throws RuntimeException {
        List<Provider> providerList = null;
        providerList = providerDao.selectProviderList( queryProName,queryProCode,from,pageSize);
        return providerList;
    }
}
