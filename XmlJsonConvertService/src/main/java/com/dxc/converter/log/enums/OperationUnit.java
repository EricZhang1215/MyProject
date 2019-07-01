package com.dxc.converter.log.enums;

public enum OperationUnit {
	/**
	 *  被操作的单元
	 */
	UNKNOWN("unknown"), 
	SOAPAPI("soap"), 
	RESTAPI("rest"), 
	REDIS("redis"),
	COMPONENT("component"),
	CORE_RESTAPI("core_restapi");

	private String value;

	OperationUnit(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
