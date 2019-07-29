package com.dxc.videoservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author He Biao
 * @date 2018-08-29
 */
@ApiModel("振铃对象信息")
public class getRingVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("会话sid")
    private String  sid;

    @ApiModelProperty("用户手机号")
    private String mobile;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
