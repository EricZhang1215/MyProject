package com.dxc.videoservice.dto;

/**
 *  理赔结单对象
 *
 * @author He Biao
 * @date 2018-09-27
 */
public class restult {

    //理赔单号
    private String orderid;

    //单号类型
    private String type;

    //处理进展 1：受理成功 2：审核通过 3:审核拒绝
    private int state;

    //处理进展描述
    private String desc;

    //进度说明
    private String process;

    //车牌号
    private String carnumber;

    //报案人
    private String reporter;

    //出险时间
    private String casetime;

    //出险详情
    private String detail;

    //受理时间
    private String accepttime;

    //审核时间
    private String checktime;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getCasetime() {
        return casetime;
    }

    public void setCasetime(String casetime) {
        this.casetime = casetime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(String accepttime) {
        this.accepttime = accepttime;
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }
}
