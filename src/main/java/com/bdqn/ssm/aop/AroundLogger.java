package com.bdqn.ssm.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * @Description: 环绕增强类
 * @param:
 * @return:
 * @Date: 2019/06/28 9:10
 */
//通过@Aspect来定义切面
@Aspect
public class AroundLogger {

    private static final Logger log = Logger.getLogger(AroundLogger.class);

//    通过注解定义切点组件(业务层所有的方法)
    @Pointcut(value = "execution(* com.bdqn.ssm.service..*(..))")
    public void pointCut(){}
    /**
     * @Description: 环绕增强
     * @param: [jp]
     * @return: java.lang.Object
     * @Date: 2019/06/28 9:22
     */
    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable{
        //前置增强
        log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
                + " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
        try {
            //后置带返回值增强
            Object result = jp.proceed();
            log.info("调用 " + jp.getTarget() + " 的 "
                    + jp.getSignature().getName() + " 方法。方法返回值：" + result);
            return  result;
        } catch (Throwable e) {
            e.printStackTrace();
//            异常增强
            log.error(jp.getSignature().getName() + " 方法发生异常：" + e);
            throw e;
        }finally {
            //最终增强
            log.info(jp.getSignature().getName() + " 方法结束执行。");
        }
    }
}
