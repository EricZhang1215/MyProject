package com.dxc.videoservice.dto;

import java.util.List;

/**
 *
 * 查询历史视频信息对象
 *
 * @author He Biao
 * @date 2018-09-25
 */
public class historyVideoDto {

    //会话id
    private String sid;

    //命令字
    private int cmd;

    //视频对象
    private List<videos> videos;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public List<com.dxc.videoservice.dto.videos> getVideos() {
        return videos;
    }

    public void setVideos(List<com.dxc.videoservice.dto.videos> videos) {
        this.videos = videos;
    }
}
