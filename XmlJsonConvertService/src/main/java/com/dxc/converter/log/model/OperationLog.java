package com.dxc.converter.log.model;

import java.util.Date;

public class OperationLog {
    private String detail;
    private Integer level;
    private String operationUnit;
    private String operationType;
    private String method;
    private Long runTime;
    private Date createTime;

    
    public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getOperationUnit() {
        return operationUnit;
    }

    public void setOperationUnit(String operationUnit) {
        this.operationUnit = operationUnit;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "detail=" + detail +
                ", runTime=" + runTime +
                ", level=" + level +
                ", operationUnit='" + operationUnit + '\'' +
                ", operationType='" + operationType + '\'' +
                ", method='" + method + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
