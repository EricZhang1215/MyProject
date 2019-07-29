package com.dxc.videoservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author He Biao
 * @date 2018-09-25
 */
@ApiModel("视频对象")
public class videosVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("视频文件名")
    public String name;

    @ApiModelProperty("下载视频的url")
    public String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
