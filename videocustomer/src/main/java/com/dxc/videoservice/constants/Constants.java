package com.dxc.videoservice.constants;

/**
 * @author He Biao
 * @date 2018-08-23
 */
public class Constants {
    //返回状态
    public static final int RESULT_TYPE_SUCCESS = 0;
    public static final int RESULT_TYPE_FAILURE = 1;
    //返回信息message
    public static final String RESULT_MSG_SUCCESS = "success";
    public static final String RESULT_MSG_FAILURE = "failure";
    public static final String RESULT_MSG_NO_RANGE = "无数据权限";
    public static final String HOUSE_AUDIT_NO_USER = "未分配审核人";

    //cmd 状态
    //呼叫理赔座席
    public static final int MQ_CMD_CALL_AGENT  = 11;
    //受理理赔
    public static final int MQ_CMD_ACCEPT = 21;
    //发送视频消息
    public static final int MQ_CMD_SEND_VIDEO = 12;


}
