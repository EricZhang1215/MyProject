
jQuery.support.cors = true; //处理IE9 ajax 获取不到返回数据的问题

//视频客服座席id
var agentCode = document.getElementById("agentCode").value;
//座席登录账号
var userId = document.getElementById("userId").value;
//座席所属客服机构
var csOrgnPartyId = document.getElementById("csOrgnPartyId").value;

var actid  = 0;
var status = "";//截图是否成功状态标识

var conf = {
    //阿里云生产地址：
    serverHost : 'http://47.96.246.139:80/videocustomer',
    //测试环境地址：
    //serverHost : 'http://9.1.120.116:8080/videocustomer',
    //本地测试地址
    //serverHost : 'http://127.0.0.1:8080/videoCustomer',

    data:{
        staffid : userId,
        sid : 0//本次会话ID

    },
    notBusyData : {
        cmd : 11,
        ext : csOrgnPartyId
    },
    getThruData:{
        cmd:21//受理接通电话
    },
    //满意度
    satisfactionData:{
        cmd : 22
    },
    hangUpData:{

    },
    msg:{
        id : '95D74152AA10A126EEF40CB3A3397ED5'
    },
    phoneDoneData : {
        cmd : 30
    }
};

var _mm = {
    // 获取服务器地址
    getServerUrl : function(path) {
        return conf.serverHost + path;
    },
    // 成功提示
    successTips : function(msg) {
        alert(msg || '成功');
    },
    // 错误提示
    errorTips : function(msg) {
        alert(msg || '有错误！');
    }
};

var childFuncBack = {
    datas : {
        method : ''
    }
};

//监听服务远程调用请求
window.addEventListener("message",function(obj){
    var str = obj.data;
    var json =  $.parseJSON( str );
    if(json.method == 'setAgentMessage'){
        agentCode = json.agentCode;
        userId = json.userId;
        csOrgnPartyId = json.csOrgnPartyId;
    }
    if(json.method == 'closeVideo'){
        page.closeVideo();
    }
    if(json.method == 'getActid'){
        actid = json.actid;
        page.getActid(actid);
    }
     //console.log("addEventListener_message:"+obj.origin+' '+obj.data);
});

var page = {

    test123 : function (tt){
        childFuncBack.datas.method = 'toCcCallMessage';

        window.parent.postMessage(JSON.stringify(childFuncBack.data) || '','*');
    },

    test : function (sid, mobile) {
        page.toCcCallMessage(sid,mobile);
    },

    //获取呼叫中心actId;
    getActid : function( actids){
      actid = actids;
    },

    //sid 视频唯一会话id ,mobile:呼入号码 , 接通时间
    //赋值给父页面
    toCcCallMessage : function(sid, mobile, callTime){
        childFuncBack.datas.method = 'toCcCallMessage';
        childFuncBack.datas.sid = sid;
        childFuncBack.datas.mobile = mobile;
        childFuncBack.datas.callTime = callTime;
        window.parent.postMessage(JSON.stringify(childFuncBack.datas) || '', '*');
    },

    //初始化满意度信息
    satisfactionMessage : function (sid){
        childFuncBack.datas.method = 'satisfactionMessage';
        childFuncBack.datas.sid = sid;
        window.parent.postMessage(JSON.stringify(childFuncBack.datas) || '', '*');
    },

    //获取客户来电时挂断事件
    phoneDone : function (){
        var _this = this;
        conf.phoneDoneData.sid = conf.data.sid;
        $.ajax({
            type        : 'post',
            url         : _mm.getServerUrl('/videoCustomer/getRedisMS'),
            dataType    : 'json',
            data        : JSON.stringify(conf.phoneDoneData)   || '',
            contentType : 'application/json',
            async       : false,
            success    : function(res) {
                //console.log("===phoneDone返回值："+JSON.stringify(res.data)+'====phoneDone入参值:'+JSON.stringify(conf.phoneDoneData));
                if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                    conf.data = res.data;
                    conf.data.sid = res.data.sid;
                    //1表示客户已经挂断改视频
                    if(res.data.status == '1'){
                        //设置示闲样式
                        btnActions.notBusy();
                        //停止振铃
                        btnActions.ringStop();
                        //停止本次轮询
                        clearInterval(_this.requestDone);
                        //enable 挂断
                        page.hangUpFun();
                    }
                    // console.log(JSON.stringify(conf.data)   || '');
                }
            },
            error   : function(err) {
                // console.log(err.msg);
            }

        });
    },


    //设置初始值
    init : function(){
        var _this = this;
        _this.onLoad();  
        _this.bindEvent();
    },
    onLoad : function(){
        var _this = this;
        _this.doCheckIE();
        _this.initBtnStatus();
    },
    doCheckIE : function() {
        var bIE = false;
        if (!!window.ActiveXObject || "ActiveXObject" in window)
            bIE = true;
        else if (window.navigator.userAgent.indexOf("MSIE") >= 1)
            bIE = true;
        else
            bIE = false;
        if (bIE == false)
        {
            document.getElementById('CheckIEStatus').style.display = 'block';
        }
    },
    initBtnStatus : function(){
        btnActions.removeBtnStyle();
        btnActions.initBtnStyle();
        $("#staffid").text(conf.data.staffid);//设置员工号
    },

    //clpcc关闭视频图表是强制示忙
    closeVideo : function(){
        var _this = this;
        clearInterval(_this.requestMS);
        btnActions.busyClicked();
        sessionActions.uninitSDK();
    },

    //挂断
    hangUpFun :function () {
        var _this = this;
        //关闭video session
        sessionActions.destroySession();
        btnActions.hangUpClicked();
        conf.hangUpData.state=1;
        conf.hangUpData.reporter = conf.data.mobile;
        conf.hangUpData = {
            cmd : 25,
            msg : JSON.stringify(conf.hangUpData)   || '',
            sid : conf.data.sid
        };
        $.ajax({
            type        : 'post',
            url         : _mm.getServerUrl('/videoCustomer/putMQMessage'),
            dataType    : 'json',
            data        : JSON.stringify(conf.hangUpData)   || '',
            contentType : 'application/json',
            success    : function(res) {
                if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                    //conf.data.cmd = res.data.cmd;
                    //conf.data.sid = res.data.sid;
                     //console.log("点击挂断成功：conf.data==="+JSON.stringify(conf.data)   || '');
                    //挂断成功,继续轮询
                    $("#mobile").text("");
                    //停止本次轮询
                    clearInterval(_this.requestDone);
                    //_this.requestMS = setInterval("page.lunxun()",1000);
                    btnActions.busyClicked();
                }else{
                    conf.data = res.data;
                     //console.log("点击挂断失败："+JSON.stringify(conf.data)   || '');
                }
            },
            error   : function(err) {
                // console.log(err.msg);
            }
        });
    },

    getSnapshot :function(){
        //conf.snapshotData = conf.data.sid;
        conf.msg.id = 'FB11FDEBF98E9473D5EF45F67FDADC0A' // 此处为applicaiton.yml中配置的snapshotCode
        conf.msg.sid = conf.data.sid;
        conf.msg.empCode = userId;
        conf.msg.agentCode = agentCode;
        conf.msg.actId = actid;
        conf.snapshotData = {
            cmd: 13,
            sid: conf.data.sid,
            msg: JSON.stringify(conf.msg) || '',
            no:1
        };
        $.ajax({
            type        : 'post',
            url         : _mm.getServerUrl('/videoCustomer/getRedisMS'),
            dataType    : 'json',
            data        : JSON.stringify(conf.snapshotData)   || '',
            contentType : 'application/json',
            success    : function(res) {
                //console.log("===截图返回值："+JSON.stringify(res.data)+'====截图入参值:'+JSON.stringify(conf.snapshotData));
                if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                    //console.log("===截图成功返回值："+JSON.stringify(res.data));
                    status = 'true';
                    //conf.data.cmd = res.data.cmd;
                    //conf.data.sid = res.data.sid;
                    conf.data.fileurl = res.data.fileurl;
                    window.open(conf.data.fileurl);
                }else{
                    status = 'false';
                }
            },
            error   : function(err) {
                status = 'false';
            }
        });
        return status;
    },


    //绑定所有event事件
    bindEvent : function(){
        var _this = this;

        //点击“示忙”时
        $(document).on('click', '#busy', function(){
            clearInterval(_this.requestMS);
            btnActions.busyClicked();
            sessionActions.uninitSDK();
            btnActions.ringStop();
        });

        //点击“示闲”时
        $(document).on('click', '#notBusy', function(){
            btnActions.notBusy();
            sessionActions.initSDK("C:\\Program Files\\exe\\CS.exe");
            //console.log("示闲事件被触发");
            //设置轮询
            _this.requestMS = setInterval("page.lunxun()",3000);
        });

        //点击“满意度”时
        $(document).on('click', '#satisfaction', function(){
            btnActions.hangUpClicked();
            conf.satisfactionData = conf.data.sid;
            conf.msg.id = '95D74152AA10A126EEF40CB3A3397ED5'
            conf.msg.sid = conf.data.sid;
            conf.msg.empCode = userId;
            conf.msg.agentCode = agentCode;
            conf.msg.actId = actid;
            conf.satisfactionData = {
                cmd : 22,
                sid: conf.data.sid,
                msg:  JSON.stringify(conf.msg) ||'',
                satisfaction:0,
                no:1
            };
            $.ajax({
                type        : 'post',
                url         : _mm.getServerUrl('/videoCustomer/putMQMessage'),
                dataType    : 'json',
                data        : JSON.stringify(conf.satisfactionData)   || '',
                contentType : 'application/json',
                success    : function(res) {
                    //console.log("===满意度返回返回值："+JSON.stringify(res.data)+'====满意度返回入参值:'+JSON.stringify(conf.satisfactionData));
                    if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                        //初始化满意度信息
                        page.satisfactionMessage(conf.data.sid);
                        //console.log("发送满意度成功："+JSON.stringify(res.data)   || '');
                        page.hangUpFun();
                        clearInterval(_this.requestDone);
                    }else{
                        //conf.data.cmd = res.data.cmd;
                        //conf.data.sid = res.data.sid;
                         //console.log("发送满意度失败："+JSON.stringify(res.data)   || '');
                    }
                },
                error   : function(err) {
                    // console.log(type);
                }
            });
        });

        //点击“开始截图”时
        $(document).on('click', '#startSnapshot', function(){
            conf.snapshotData = conf.data.sid;
            conf.msg.id = 'FB11FDEBF98E9473D5EF45F67FDADC0A' // 此处为applicaiton.yml中配置的snapshotCode
            conf.msg.sid = conf.data.sid;
            conf.msg.empCode = userId;
            conf.msg.agentCode = agentCode;
            conf.msg.actId = actid;
            conf.snapshotData = {
                cmd : 22,
                sid: conf.data.sid,
                msg:  JSON.stringify(conf.msg) ||'',
                no:1
            };
            $.ajax({
                type        : 'post',
                url         : _mm.getServerUrl('/videoCustomer/putMQMessage'),
                dataType    : 'json',
                data        : JSON.stringify(conf.snapshotData)   || '',
                contentType : 'application/json',
                success    : function(res) {
                    $("#startSnapshot").addClass("disableBtn").attr("disabled","true");
                    var i = 0;
                    _this.requestMS_ = setInterval(function() {
                        ++i;
                        if(i===6){clearInterval(_this.requestMS_);$("#startSnapshot").addClass("enableBtn").removeAttr("disabled");}
                        status = page.getSnapshot();
                        if(status == "true"){
                            clearInterval(_this.requestMS_);
                            $("#startSnapshot").addClass("enableBtn").removeAttr("disabled");
                        }
                    },3000);
                },
                error   : function(err) {
                    //console.log("点击截图后请求putMQMessage报错:" + err.msg );
                }
            });
        });

        // //点击“接通”按钮
        $(document).on('click', '#getThru', function(){
            conf.getThruData.sid = conf.data.sid;
            conf.getThruData.error = 0;
            conf.getThruData.errormsg = "";
            conf.getThruData.mobile = agentCode;
            conf.getThruData.orderid = conf.data.sid;//报案单号暂存sid
            conf.getThruData.staffid = userId;
            //console.log("发送接通参数："+JSON.stringify(conf.getThruData)   || '');
            $.ajax({
                type        : 'post',
                url         : _mm.getServerUrl('/videoCustomer/putMQMessage'),
                dataType    : 'json',
                data        : JSON.stringify(conf.getThruData)   || '',
                contentType : 'application/json',
                success    : function(res) {
                    if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                        //console.log("接通成功返回："+JSON.stringify(conf.data)   || '');
                        btnActions.getThruClicked();//接通成功之后再设置按钮
                        //conf.data.cmd = res.data.cmd;
                        //conf.data.sid = res.data.sid;
                        // 现在还没有数据，自己填充数据
                        conf.data.sendurl = res.data.sendurl;
                        conf.data.playurl = res.data.playurl;
                        //把url赋值到videoSession,并接通video
                        sessionActions.createSession(conf.data.sendurl,conf.data.playurl);
                        btnActions.ringStop();
                    }else{
                        //停止本次轮询
                        clearInterval(_this.requestDone);
                        //console.log("接通返回失败：");
                        btnActions.hangUpClicked();
                        btnActions.ringStop();
                        _this.requestMS = setInterval("page.lunxun()",1000);
                    }
                },
                error   : function(err) {
                    //console.log("接通失败:"+err.msg);
                }
            });
        });



        // //点击“挂断”按钮
        $(document).on('click', '#hangUp', function(){
            //关闭video session
            sessionActions.destroySession();
            btnActions.hangUpClicked();
            conf.hangUpData.state=1;
            conf.hangUpData.reporter = conf.data.mobile;
            conf.hangUpData = {
                cmd : 25,
                msg : JSON.stringify(conf.hangUpData)   || '',
                sid : conf.data.sid
            };
            $.ajax({
                type        : 'post',
                url         : _mm.getServerUrl('/videoCustomer/putMQMessage'),
                dataType    : 'json',
                data        : JSON.stringify(conf.hangUpData)   || '',
                contentType : 'application/json',
                success    : function(res) {
                    if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                         //console.log("点击挂断成功："+JSON.stringify(conf.data)   || '');
                        conf.data.cmd = 0;
                        conf.data.sid = 0;
                        //挂断成功,继续轮询
                        $("#mobile").text("");
                        //btnActions.stop();
                        //_this.requestMS = setInterval("page.lunxun()",1000);
                        clearInterval(_this.requestMS);
                        btnActions.busyClicked();
                        sessionActions.uninitSDK();
                        //btnActions.ringStop();
                    }else{
                        //conf.data = res.data;
                        //console.log("点击挂断失败："+JSON.stringify(res.data)   || '');
                    }
                },
                error : function(err) {
                   // console.log("挂断时间发送请求失败："+err.msg);
                }
            });
        });
    },

    //轮询请求
    lunxun : function(){
        var _this = this;
        $.ajax({
            type        : 'post',
            url         : _mm.getServerUrl('/videoCustomer/getRedisMS'),
            dataType    : 'json',
            data        : JSON.stringify(conf.notBusyData)   || '',
            contentType : 'application/json',
            async       : false,
            success    : function(res) {
                //console.log("lunxun_mothed返回值："+JSON.stringify(res.data));
                if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                    //conf.data = res.data;
                    //console.log("lunxun_mothed返回值----1----res.data.sid："+conf.data.sid);
                    conf.data.sid = res.data.sid;//console.log("lunxun_mothed返回值----2----conf.data.sid："+conf.data.sid);
                    $("#sid").text(conf.data.sid);//设置员工号
                    conf.data.mobile = res.data.mobile;
                    conf.data.callTime = res.data.callTime;
                    clearInterval(_this.requestMS);
                    btnActions.notBusyClicked();//接通之后,样式
                    $("#mobile").text(conf.data.mobile);
                    btnActions.ringPlay();
                    page.toCcCallMessage(res.data.sid, conf.data.mobile, res.data.callTime);
                    //设置轮询
                    _this.requestDone = setInterval("page.phoneDone()",1000);
                }else{
                    conf.data.sid = 0;
                }
            },
            error   : function(err) {
                //console.log("lunxun:"+err.msg);
            } 
        });
    }
 
}

$(function(){
    page.init();
});


