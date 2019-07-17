package com.bdqn.ssm.dao;

import com.bdqn.ssm.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: ProviderDao
 * @Description: 供应商数据访问层接口
 * @Author: xyf
 * @Date 2019/7/5 10:25
 */
public interface ProviderDao {
    /**
     * @Description:
     * @param: [queryProCode, queryProName]
     * @return: int
     * @Date: 2019/07/05 10:38
     */
    Integer selectProCount(@Param("proCode") String queryProCode,@Param("proName") String queryProName);

    /**
     * @Description: 分页查询供应商信息
     * @param: [queryProName, queryProCode, currentPageNo, pageSize]
     * @return: java.util.List<com.bdqn.ssm.pojo.Provider>
     * @Date: 2019/07/05 10:52
     */
    List<Provider> selectProviderList(@Param("proName") String queryProName,
                                      @Param("proCode") String queryProCode,
                                      @Param("from") int from,
                                      @Param("pageSize")int pageSize);
}
