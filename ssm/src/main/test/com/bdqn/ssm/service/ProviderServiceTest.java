package com.bdqn.ssm.service;

import com.bdqn.ssm.pojo.Provider;
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
public class ProviderServiceTest {


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
    public void getproviderCount() throws Exception {
        ProviderService providerService= (ProviderService) context.getBean("providerService");
        Integer providerCount=providerService.getproviderCount(null,null);
        logger.info("供应商数量——"+providerCount);
    }

    @Test
    public void getProviderList() throws Exception {
        ProviderService providerService= (ProviderService) context.getBean("providerService");
        List<Provider> providerList=providerService.getProviderList("北",null,0,3);
        for (Provider pro:
             providerList) {
            logger.info(pro.getProCode()+"——"+pro.getProName()+"——"+pro.getId());
        }
    }

}