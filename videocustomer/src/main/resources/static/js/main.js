
jQuery.support.cors = true; //处理IE9 ajax 获取不到返回数据的问题

var conf = {
    serverHost : 'http://127.0.0.1:8080',
    data:{
        staffid : 11001
    },
    notBusyData : {
        cmd : 11
    },
    getThruData:{
        cmd:21
    },
    satisfactionData:{

    },
    hangUpData:{

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
    },
    
};


var page = {

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
        videoActions.setRenderWndSize();
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
        var _this = this;
        btnActions.removeBtnStyle();
        btnActions.initBtnStyle();
        $("#staffid").text(conf.data.staffid);//设置员工号
    },

      

    

    //绑定所有event事件
    bindEvent : function(){
        var _this = this;

        //点击“示忙”时
        $(document).on('click', '#busy', function(){
            clearInterval(_this.requestMS);
            btnActions.busyClicked();
        });

        //点击“示闲”时
        $(document).on('click', '#notBusy', function(){
            btnActions.notBusyClicked();
            //设置轮询
            _this.requestMS = setInterval("page.lunxun()",1000);
        });

        // //点击“接通”按钮
        $(document).on('click', '#getThru', function(){

            btnActions.getThruClicked();
            
            conf.getThruData.sid = conf.data.sid;
            conf.getThruData.error = 0;
            conf.getThruData.errormsg = "";
            conf.getThruData.mobile = conf.data.mobile;
            conf.getThruData.orderid = "";
            conf.getThruData.staffid = "11001";

            conf.satisfactionData = {
                cmd:14,
                sid:conf.data.sid,
                msg: "",
                satisfaction:0,
                no:1
            };
            
            //console.log(conf.satisfactionData);
            //console.log(conf.getThruData);

            //直接发送满意度
            $.ajax({
                type        : 'post',
                url         : _mm.getServerUrl('/videoCustomer/putMQMessage'),
                dataType    : 'json',
                data        : JSON.stringify(conf.satisfactionData)   || '',
                contentType : 'application/json',
                success    : function(res) {
                    if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                        // console.log(res);

                        conf.data.cmd = res.data.cmd;
                        conf.data.sid = res.data.sid;
                        //console.log(conf.data);

                        //enable 挂断
                    }else{
                        
                        conf.data.cmd = res.data.cmd;
                        conf.data.sid = res.data.sid;
                        //console.log(conf.data);
                    }
                },
                error   : function(err) {
                    // console.log(type);
                    // typeof param.error === 'function' && param.error(err.statusText);
                }   
            });

            //接通来电调用
            $.ajax({
                type        : 'post',
                url         : _mm.getServerUrl('/videoCustomer/putMQMessage'),
                dataType    : 'json',
                data        : JSON.stringify(conf.getThruData)   || '',
                contentType : 'application/json',
                success    : function(res) {
                    if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                        // console.log(res);
                        
                        //disable示闲

                        conf.data.cmd = res.data.cmd;
                        conf.data.sid = res.data.sid;
                        // 现在还没有数据，自己填充数据
                        conf.data.sendurl = "rtmp://3891.livepush.myqcloud.com/live/3891_user_51a0ebf0_5617?bizid=3891&txSecret=195574acd8e89d4a355a97b17c492984&txTime=5BA0740A";
                        conf.data.playurl = "rtmp://3891.liveplay.myqcloud.com/live/3891_user_51a0ebf0_5617?bizid=3891&txSecret=195574acd8e89d4a355a97b17c492984&txTime=5BA0740A";
                        //console.log(conf.data);

                        //把url赋值到activeX,并接通player和pusher
                        videoActions.doPushPlayOpen();


                    }else{
                        
                        conf.data.cmd = res.data.cmd;
                        conf.data.sid = res.data.sid;
                        //console.log(conf.data);
                    }
                },
                error   : function(err) {
                    //console.log(err.msg);
                    // typeof param.error === 'function' && param.error(err.statusText);
                }   
            });
        });

        // //点击“挂断”按钮
        $(document).on('click', '#hangUp', function(){
            
            btnActions.hangUpClicked();

            conf.hangUpData = {
                cmd : conf.data.cmd,
                sid : conf.data.sid,
                error: 0,
                errormsg: "",
                mobile:conf.data.mobile,
                staffid: 11001,
                orderid: ""
            };
            // console.log(conf.data);
            //console.log(conf.hangUpData);
            $.ajax({
                type        : 'post',
                url         : _mm.getServerUrl('/videoCustomer/putMQMessage'),
                dataType    : 'json',
                data        : JSON.stringify(conf.hangUpData)   || '',
                contentType : 'application/json',
                success    : function(res) {
                    if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                        // console.log(res);

                        conf.data.cmd = res.data.cmd;
                        conf.data.sid = res.data.sid;
                    
                        //console.log(conf.data);

                        //挂断成功，关闭摄像头,继续轮询
                        videoActions.doPushPlayClose();
                        _this.requestMS = setInterval("page.lunxun()",1000);
                    }else{
                        conf.data = res.data;
                        //console.log(conf.data);
                    }
                },
                error   : function(err) {
                    //console.log(err.msg);
                    // typeof param.error === 'function' && param.error(err.statusText);
                }   
            });
        });
    },

    //轮询请求
    lunxun : function(){
        var _this = this;
        $.ajax({
            type        : 'post',
            url         : _mm.getServerUrl('/videoCustomer/'),
            dataType    : 'json',
            data        : JSON.stringify(conf.notBusyData)   || '',
            contentType : 'application/json',
            success    : function(res) {
                if (0 === res.code && !jQuery.isEmptyObject(res.data) ) {
                    // alert(res.data.sid);
                    clearInterval(_this.requestMS);//停止轮询，并做下一步操作
                    //disable示闲
                    
                    conf.data = res.data;

                }else{
                    conf.data.sid = "b345a433889d441ab6f043217b23d104";
                    conf.data.mobile = "15611166661";
                    conf.data.calltime = "2018-09-11 10:12:53"
                    //console.log(conf.data);
                    clearInterval(_this.requestMS);

                    $("#mobile").text(conf.data.mobile);

                    // alert(res.msg);
                }
            },
            error   : function(err) {
                //console.log(err.msg);
                
                // typeof param.error === 'function' && param.error(err.statusText);
            } 
        });
    },
 
}

$(function(){
    page.init();
});


