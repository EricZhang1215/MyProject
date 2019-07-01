package com.dxc.converter.enums;

public enum VPMSExceptionEnum {
	
    SYSTEM_ERROR("V000","系统错误","error"),
    VPMS_EXCEPTION("V001","VPMS业务处理异常","error"),
    VPMS_PREMIUM_EXCEPTION("V002","VPMS保费计算异常","error"),
    VPMS_RISKAMOUNT_EXCEPTION("V002","VPMS风险保额计算异常","error"),
    VPMS_CASHVALUE_EXCEPTION("V003","VPMS现金价值计算异常","error"),
    INNER_CONN_EXCEPTION("V002","系统错误","error"),
    UNKNOWN_EXCEPTION("V009","未知异常","warn");
 
    private String errorCode;
    private String errorMsg;
    private String errorType;
 
 
    VPMSExceptionEnum(String errorCode, String errorMsg, String errorType) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorType = errorType;
    }
 
    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }
 
    /**
     * Setter method for property <tt>errorCode</tt>.
     *
     * @param errorCode value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
 
    /**
     * Getter method for property <tt>errorMsg</tt>.
     *
     * @return property value of errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }
 
    /**
     * Setter method for property <tt>errorMsg</tt>.
     *
     * @param errorMsg value to be assigned to property errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
 
    /**
     * Getter method for property <tt>errorType</tt>.
     *
     * @return property value of errorType
     */
    public String getErrorType() {
        return errorType;
    }
 
    /**
     * Setter method for property <tt>errorType</tt>.
     *
     * @param errorType value to be assigned to property errorType
     */
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}
