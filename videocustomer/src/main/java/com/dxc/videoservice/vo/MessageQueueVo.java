package com.dxc.videoservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author He Biao
 * @date 2018-08-27
 */
@ApiModel("请求对象")
public class MessageQueueVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("命令字")
    private int cmd;

    @ApiModelProperty("会话sid")
    private String  sid;

    @ApiModelProperty("地区机构编码")
    private String  ext;


    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
