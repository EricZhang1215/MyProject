package com.dxc.videoservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author He Biao
 * @date 2018-08-29
 */
@ApiModel("受理视频信息")
public class putMQVo implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("命令字")
    private int cmd;

    @ApiModelProperty("会话id")
    private String sid;

    @ApiModelProperty("状态码")
    private int error;

    @ApiModelProperty("信息")
    private String errormsg;

    @ApiModelProperty("理赔坐席的id")
    private String staffid;

    @ApiModelProperty("报案单号")
    private String orderid;

    @ApiModelProperty("理赔坐席手机号")
    private String mobile;

    //-============文字消息使用字段===========
    @ApiModelProperty("文字内容")
    private String msg;

    @ApiModelProperty("是否满意度：0 ：是，1：否")
    private int satisfaction;

    @ApiModelProperty("会话序号")
    private int no;

//    @ApiModelProperty("处理进展 1:受理成功 2:审批通过 3:审批拒绝")
//    private int state;

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

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
