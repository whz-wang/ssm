package com.bdqn.ssm.error;

/**
 * @ClassName: BusinessException
 * @Description:业务异常类(包装业务异常类实现)
 * @Author: xyf
 * @Date 2019/7/16 15:12
 */
public class BusinessException extends Exception implements CommonError {

    //这里的CommonError本质是CommonError的实现类EmBusinessError
    private CommonError commonError;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public BusinessException() {
    }

    public BusinessException(CommonError commonError) {
        super();//必须需要显示调用super()方法，因为这里没有写无参的构造方法
        this.commonError = commonError;
    }

    public BusinessException(CommonError commonError, String errMsg) throws BusinessException {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    /**
     * @Description:获取错误的错误代码
     * @param: []
     * @return: int
     * @Date: 2019/07/16 14:43
     */
    @Override
    public int getErrorCode() {
        return commonError.getErrorCode();
    }

    /**
     * @Description: 获取错误信息
     * @param: []
     * @return: java.lang.String
     * @Date: 2019/07/16 14:43
     */
    @Override
    public String getErrMsg() {
        return commonError.getErrMsg();
    }

    /**
     * @param errMsg
     * @Description:手动设置错误的业务信息(通过定制化的方式处理一些通用的错误类型)
     * @param: [errMsg]
     * @return: com.bdqn.ssm.error.CommonError
     * @Date: 2019/07/16 14:45
     */
    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}