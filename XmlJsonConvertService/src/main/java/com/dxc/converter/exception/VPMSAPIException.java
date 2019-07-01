package com.dxc.converter.exception;

import com.dxc.converter.enums.VPMSExceptionEnum;

public class VPMSAPIException extends RuntimeException {
	private static final long serialVersionUID = 6958499248468627021L;
    private String errorCode;
    private String errorType; 
 
    public VPMSAPIException(VPMSExceptionEnum vpmExceptionEnum){
        super(vpmExceptionEnum.getErrorMsg());
        this.errorCode = vpmExceptionEnum.getErrorCode();
        this.errorType = vpmExceptionEnum.getErrorType();
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

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
 
 
}
