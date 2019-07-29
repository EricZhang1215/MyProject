

var btnActions = {

    initBtnStyle :function(){
        $("#getThru").addClass("disableBtn").attr("disabled","true");
        $("#hangUp").addClass("disableBtn").attr("disabled","true");
        $("#satisfaction").addClass("disableBtn").attr("disabled","true");
        $("#startSnapshot").addClass("disableBtn").attr("disabled","true");
        $("#busy").addClass("disableBtn").attr("disabled","true");
        $("#notBusy").addClass("enableBtn");

        /*$("#getThru").addClass("enableBtn");
        $("#hangUp").addClass("enableBtn");
        $("#satisfaction").addClass("enableBtn");
        $("#busy").addClass("enableBtn");
        $("#notBusy").addClass("enableBtn");*/

    },
    removeBtnStyle : function(){
        $("#getThru").removeClass("disableBtn enableBtn").removeAttr("disabled");
        $("#hangUp").removeClass("disableBtn enableBtn").removeAttr("disabled");
        $("#satisfaction").removeClass("disableBtn enableBtn").removeAttr("disabled");
        $("#startSnapshot").removeClass("disableBtn enableBtn").removeAttr("disabled");
        $("#busy").removeClass("disableBtn enableBtn").removeAttr("disabled");
        $("#notBusy").removeClass("disableBtn enableBtn").removeAttr("disabled");
    },

    //来电后的样式
    notBusyClicked : function(){
        var _this = this;
        _this.removeBtnStyle();
        $("#getThru").addClass("enableBtn");
        $("#hangUp").addClass("disableBtn").attr("disabled","true");
        $("#satisfaction").addClass("disableBtn").attr("disabled","true");
        $("#startSnapshot").addClass("disableBtn").attr("disabled","true");
        $("#busy").addClass("enableBtn");
        $("#notBusy").addClass("disableBtn").attr("disabled","true");
    },

    //点击示闲按钮
    notBusy : function () {
        var _this = this;
        _this.removeBtnStyle();
        $("#getThru").addClass("disableBtn").attr("disabled","true");
        $("#hangUp").addClass("disableBtn").attr("disabled","true");
        $("#satisfaction").addClass("disableBtn").attr("disabled","true");
        $("#startSnapshot").addClass("disableBtn").attr("disabled","true");
        $("#busy").addClass("enableBtn");
        $("#notBusy").addClass("disableBtn").attr("disabled","true");
    }
    ,

    getThruClicked : function(){
        var _this = this;
        _this.removeBtnStyle();
        $("#getThru").addClass("disableBtn").attr("disabled","true");
        $("#hangUp").addClass("enableBtn");
        $("#satisfaction").addClass("enableBtn");
        $("#startSnapshot").addClass("enableBtn");
        $("#busy").addClass("disableBtn").attr("disabled","true");
        $("#notBusy").addClass("disableBtn").attr("disabled","true");
    },

    hangUpClicked : function(){
        var _this = this;
        _this.removeBtnStyle();
        $("#getThru").removeClass("enableBtn").addClass("disableBtn").attr("disabled","true");
        $("#hangUp").removeClass("enableBtn").addClass("disableBtn").attr("disabled","true");
        $("#busy").removeClass("disableBtn").addClass("enableBtn").removeAttr("disabled");
        $("#notBusy").removeClass("enableBtn").addClass("disableBtn").attr("disabled","true");
    },

    ringPlay : function (){
        var obj=document.getElementById("ring");
        obj.play();
    },

    ringStop : function () {
        var obj=document.getElementById("ring");
        obj.stop();
    },

    busyClicked : function(){
        var _this = this;
        _this.removeBtnStyle();
        $("#getThru").addClass("disableBtn").attr("disabled","true");
        $("#hangUp").addClass("disableBtn").attr("disabled","true");
        $("#satisfaction").addClass("disableBtn").attr("disabled","true");
        $("#startSnapshot").addClass("disableBtn").attr("disabled","true");
        $("#busy").addClass("disableBtn").attr("disabled","true");
        $("#notBusy").addClass("enableBtn");
    },

    satisfactionClicked : function(){
        $("#satisfaction").removeClass("enableBtn").addClass("disableBtn").attr("disabled","true");
    }

};

var sessionActions = {
    initSDK : function(){
        session.initSDK("C:\\Program Files\\exe\\CS.exe");
    },
    createSession : function(pushUrl, playUrl) {
        var _this = this;
        if (pushUrl == "" || sessionActions.isRtmpUrl(pushUrl) == false) {
            alert("请输入正确拉流url");
            return;
        }
        if (playUrl == "" || sessionActions.isRtmpUrl(playUrl) == false) {
            alert("请输入正确拉流url");
            return;
        }
        session.setSessionTitle("视频窗口");
        // session.setSessionListener(funcSessionListener, objid++);
        session.createSession(pushUrl, playUrl);
    },
    isRtmpUrl : function(strUrl) {
        var temp = 'rtmp';
        return strUrl.indexOf(temp) >= 0;
    },

    destroySession : function () {
        session.destroySession();
        // session.setSessionListener(null, 0);
        // alert("destroySession");
    },

    uninitSDK : function(){
        session.destroySession();
        // session.uninitSDK();
    }

};