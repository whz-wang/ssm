package com.bdqn.ssm.error;

public enum EmBusinessError implements CommonError{

    UNKNOWN_ERROR(10002,"未知错误"),

    UNFINDUSER_ERROR(200001,"未找到用户信息");
    ;
    private int errCode;
    private String errMsg;

   EmBusinessError(int errCode,String errMsg){
       this.errCode=errCode;
       this.errMsg=errMsg;
   }

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
       this.errMsg=errMsg;
       return this;
    }
}
