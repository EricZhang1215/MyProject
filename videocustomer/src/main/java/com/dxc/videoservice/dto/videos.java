package com.dxc.videoservice.dto;

/**
 *
 * 视频对象
 *
 * @author He Biao
 * @date 2018-09-25
 */
public class videos {

    //视频文件名称
    private  String name;

    //下载视频的url
    private  String url;

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
