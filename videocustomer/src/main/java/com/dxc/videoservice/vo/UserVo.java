package com.dxc.videoservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author He Biao
 * @date 2018-08-27
 */
@ApiModel("用户信息")
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("appId号")
    private String appId;

    @ApiModelProperty("电话号码")
    private String phoneNumber;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
