package com.dxc.videoservice.vo;

/**
 * @author He Biao
 * @date 2018-09-26
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("获取历史视频对象")
public class historyVideoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("sid")
    private String sid;

    @ApiModelProperty("视频文件路径")
    private String filePath;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
