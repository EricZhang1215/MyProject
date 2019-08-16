package com.dxc.videoservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dxc.videoservice.constants.Constants;
import com.dxc.videoservice.dto.historyVideoDto;
import com.dxc.videoservice.dto.restult;
import com.dxc.videoservice.service.ApiVideoCustomerService;
import com.dxc.videoservice.utils.AESEncryptUtil;
import com.dxc.videoservice.utils.ControlFileUtil;
import com.dxc.videoservice.utils.HttpClientUtil;
import com.dxc.videoservice.utils.HttpsUtils;
import com.dxc.videoservice.vo.MessageQueueVo;
import com.dxc.videoservice.vo.putMQVo;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 视频客服接口服务实现类
 *
 * @author He Biao
 * @date 2018-08-27
 */
@Component
public class ApiVideoCustomerServiceImpl implements ApiVideoCustomerService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ApiVideoCustomerServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //AES加密密文
    @Value("${AESCode}")
    private String AESCode;

    //带有AppId的链接地址
    @Value("${getAppIdUrl}")
    private String getAppIdUrl;

    //不带AppId的链接地址
    @Value("${notAppIdUrl}")
    private String notAppIdUrl;

    //获取MQ消息地址
    @Value("${mqUrl}")
    private String getMqUrl;

    //发送MQ消息地址
    @Value("${putMqUrl}")
    private String putMqUrl;

    //接通视频加载时长设置
    @Value("${reidsTimeOut}")
    private String reidsTimeOut;

    //接通视频轮询次数设置
    @Value("${forCount}")
    private String forCount;

    //视频加载每次循等待时长
    @Value("${sleepTime}")
    private String sleepTime;

    //满意度约定秘钥
    @Value("${satisfactionCode}")
    private String satisfactionCode;

    @Value("${snapshotCode}")
    private String snapshotCode;

    //指定windows系统文件下载目录
    @Value("${winFilePath}")
    private String winFilePath;

    //指定linux系统下载目录
    @Value("${linuxFilepath}")
    private String linuxFilepath;


    @Override
    public Map<String,String> getSessionId(String appId, String phoneNumber) {
        String urlPath = "";
        String encryped = "";
        String sessionObject = "";
        Map<String, String> retMap = new HashMap<String, String>();
        /**
         * 加密报案用户的手机号得到
         * 的密文 byte[]，再将密文
         * byte[]进行 hex 编码；算法请
         * 使用
         * "AES/ECB/PKCS5Padding"
         */
        try {
            //处理加密信息
            AESEncryptUtil aesEncryptUtil = new AESEncryptUtil();
            encryped = aesEncryptUtil.encryption(phoneNumber , AESCode);
            //自动判断是否使用配置的appid
            if(StringUtils.isNotEmpty(appId)){
                urlPath = notAppIdUrl + appId + "/getSession";
            }else{
                urlPath = getAppIdUrl;
            }
            LOGGER.info("wssPath:{}",urlPath);
            LOGGER.info("encryped:{}",encryped);
            //组装post对象数据
            Map<String,String> map = new HashMap<String,String>();
            map.put("encryped",encryped);
            //创建链接
            HttpClientUtil hcu =  HttpClientUtil.getInstance();
            sessionObject = hcu.sendHttpPost(urlPath, map);
            LOGGER.info("返回MQ消息:{}",sessionObject);
            //获取返回JSON对象
            if(StringUtils.isNotBlank(sessionObject)){
                JSONObject retJson = JSON.parseObject(sessionObject);
                int error = retJson.getInteger("error");
                //返回状态成功
                if(error == 0){
                    retMap.put("error",retJson.getString("error"));
                    retMap.put("session",retJson.getString("session"));
                    retMap.put("message",retJson.getString("message"));
                }else{
                    retMap.put("error",retJson.getString("error"));
                    retMap.put("session",retJson.getString("session"));
                    retMap.put("message",retJson.getString("message"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("获取sessionId异常",e);
        }
        return retMap;
    }

    @Override
    public Map<String,String> getMQMessage() {
        String ret = "";
        Map<String, String> retMap = new HashMap<String, String>();
        try {
            //创建链接 访问getMQ
//            HttpClientUtil hcu =  HttpClientUtil.getInstance();
//            String rstStr = hcu.sendHttpsGet(getMqUrl);
            String sign = getSign();
            Map<String, Object> params = new HashMap<>();
            params.put("sign",sign );
            LOGGER.info("====getMQMessage：sign="+sign);
            JSONObject retJson = HttpsUtils.doGet(getMqUrl,params);
            LOGGER.info("====getMQMessage：start");
            //判断接口返回信息
            if(retJson != null){
                LOGGER.info("查询getMQ返回：{}",retJson.toJSONString());
//                JSONObject retJson = JSON.parseObject(rstStr);
                int cmd = Integer.valueOf(retJson.getString("cmd")) ;
                //赋值创建时间
                retJson.put("crateTime", sdf.format(new Date()));
                if(cmd == 11){
                    //判断呼叫理赔座席放入队列
//                    LOGGER.info("----------------getMQ_Return_Data：{}",retJson.toJSONString());
//                    LOGGER.info("----------------getMQ_Return_Data_ext：{}",retJson.getString("ext"));
                    //振铃事件
//                    redisTemplate.opsForList().leftPush("ring_agent:cmd_type_11:ext:"+retJson.getString("ext"), retJson.toString());
//                    LOGGER.info("=======getMQMessage==========write_redis_List_Message==========ring_agent:cmd_type_11:sid:"+retJson.getString("sid")+":ext:"+retJson.getString("ext"));
                    redisTemplate.opsForList().leftPush("ring_agent:cmd_type_11", retJson.toString());
                    LOGGER.info("写redis队列振铃消息ring_agent:cmd_type_11：{}",retJson.getString("sid"));
                    //记录一个string类型数据
                    stringRedisTemplate.opsForValue().set("cmd_type_"+retJson.getString("cmd")+":"+retJson.getString("sid"), retJson.toString(), Long.valueOf(reidsTimeOut),TimeUnit.SECONDS);
                }else{
                    stringRedisTemplate.opsForValue().set("cmd_type_"+retJson.getString("cmd")+":"+retJson.getString("sid"), retJson.toString(), Long.valueOf(reidsTimeOut),TimeUnit.SECONDS);
                    LOGGER.info("===getMQMessage============write_redis_Message cmd_type_"+retJson.getString("cmd")+":"+retJson.getString("sid")+":{==}",retJson.getString("fileurl"));
                }
                //返回消息
                retMap.put("sid",retJson.getString("sid"));
                retMap.put("cmd",retJson.getString("cmd"));
            }
            LOGGER.info("====getMQMessage：end");
        } catch (Exception e) {
            LOGGER.error("获取队列消息异常：",e);
        }
        return retMap;
    }

    /**
     * 鉴权处理方式
     * @return
     * @throws ParseException
     * @throws DecoderException
     */
    public String getSign() throws ParseException, DecoderException {
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long startDate = sf.parse("1970-01-01 08:00:00").getTime();
//        String formatDateSrt = sf.format(new Date());
//        long newDate = sf.parse(formatDateSrt).getTime();
//        long interval = ( newDate - startDate)/1000;
        long interval = new Date().getTime()/1000;
        AESEncryptUtil aesEncryptUtil = new AESEncryptUtil();
        return aesEncryptUtil.encryption(String.valueOf(interval) , AESCode);
    }

    @Override
    public Map<String, String> putMQMessage(putMQVo mqVo) {
        Map<String, String> retMap = new HashMap<String, String>();
        try {
            JSONObject json = new JSONObject();
            json.put("cmd",mqVo.getCmd());
            json.put("sid",mqVo.getSid());
            //判断是否受理理赔
            if(mqVo.getCmd() == 21){
                json.put("errormsg",mqVo.getErrormsg());
                json.put("error", mqVo.getError());
                json.put("mobile",mqVo.getMobile());
                json.put("orderid",mqVo.getOrderid());
                json.put("staffid", mqVo.getStaffid());
            }
            //结单信息判断
            if(mqVo.getCmd() == 25){
                restult res = new restult();
                JSONObject js = JSONObject.parseObject(mqVo.getMsg());
                res.setOrderid(mqVo.getSid());
                res.setState(js.getInteger("state"));
                res.setReporter(js.getString("reporter"));
                json.put("result",res);
            }
            //发送文字消息
           if(mqVo.getCmd() == 22){ LOGGER.info("=====================发送消息:cmd=22,start");
                //目前22用于处理满意度信息
               json.put("msg",mqVo.getMsg());
               json.put("no",1);
            }
            retMap.put("sid",mqVo.getSid());
            retMap.put("cmd",String.valueOf(mqVo.getCmd()));
            LOGGER.info("===============================send message :{}",json.toJSONString());
            String rstStr = sendMQ(mqVo, retMap, json);
            //如果是受理理赔则查询视频信息
            if(mqVo.getCmd() == 21){
                 getVideoUrl(mqVo, retMap);
            }
            //restStr 为空表示调用成功
            if("".equals(rstStr)){
                LOGGER.info("=====================sendMQ_SUCCESS：{code="+retMap.get("code")+"}");
            }else{
                LOGGER.info("=====================sendMQ_FAILL!：{}",rstStr);
            }
        } catch (Exception e) {
            LOGGER.error("发腾讯平台MQ队列送消息异常：",e);
        }
        return retMap;
    }

    /**
     * 发送消息给MQ队列
     * @param mqVo
     * @param retMap
     * @param json
     * @return
     */
    private String sendMQ(putMQVo mqVo, Map<String, String> retMap, JSONObject json) {
        String rstStr = "";
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("mq",json.toString());
            String sign = getSign();
            map.put("sign",sign);
            //创建链接 访问getMQ
            HttpClientUtil hcu =  HttpClientUtil.getInstance();
            rstStr = hcu.sendHttpPost(putMqUrl,map);
        } catch (Exception e) {
            LOGGER.error("发送消息给MQ队列信息异常：{}",e.getMessage());
        }
        return rstStr;
    }

    /**
     * 获取视频资源信息
     * @param mqVo
     * @param retMap
     */
    private void getVideoUrl(putMQVo mqVo, Map<String, String> retMap) {
        //受理理赔后将调用发起视频接口
        for(int i = 0 ;i <= Long.valueOf(forCount) ; i++ ){
            try {
                Thread.sleep(Long.valueOf(sleepTime));
                MessageQueueVo getRedis = new MessageQueueVo();
                //获取视频信息
                getRedis.setCmd(12);
                getRedis.setSid(mqVo.getSid());
                //retMap.put("cmd","12");
                Map<String, String> redisMS = getRedisMS(getRedis);
                if(redisMS.get("sendurl") != null && redisMS.get("playurl") != null){
                    LOGGER.info("获取到视频信息");
                    //如果返回信息为空，则重新调用尝试调用接口
                    retMap.putAll(redisMS);
                    //保存接通时间
                    String callTime = setHsitroyVIdeoCallTime(mqVo.getSid());
                    retMap.put("callTime",callTime);
                    retMap.remove("code");
                    break;
                }else{
                    retMap.put("code","1");
                    LOGGER.info("没有获取到视频信息");
                }
            } catch (InterruptedException e) {
                LOGGER.error("获取到视频信息异常：{}",e.getMessage());
            }
        }
    }

    @Override
    public Map<String, String> getRedisMS(MessageQueueVo messageQueueVo) {
        Map<String, String> retMap = new HashMap<String, String>();
        LOGGER.info("==getRedisMS====messageQueueVo.getCmd():"+messageQueueVo.getCmd());
        try {
             if(messageQueueVo.getCmd() == 11L){
                 Object type11 = redisTemplate.opsForList().rightPop("ring_agent:cmd_type_11");
                 LOGGER.info("通过调用getRedisMS把写redis队列振铃消息读出ring_agent:cmd_type_11:{}",type11.toString());
                 if(type11 != null) {
                     String rightPop = type11.toString();
                     if (rightPop != null) {
                         if (StringUtils.isNotBlank(rightPop)) {
                             JSONObject retJson = JSON.parseObject(rightPop);
                             //会话id
                             retMap.put("sid", retJson.getString("sid"));
                             //用户号码
                             retMap.put("mobile", retJson.getString("mobile"));
                             //呼叫时间
                             retMap.put("callTime", retJson.getString("crateTime"));
                             //判断是否为用户挂断电话：
                             String get19Value = stringRedisTemplate.opsForValue().get("cmd_type_19:"+retJson.getString("sid"));
                             String get17Value = stringRedisTemplate.opsForValue().get("cmd_type_17:"+retJson.getString("sid"));
                             LOGGER.info("==getRedisMS==sid:"+retJson.getString("sid")+"==get19Value:"+get19Value+",get17Value:"+get17Value);
                             if(StringUtils.isNotBlank(get17Value) || StringUtils.isNotBlank(get19Value) ){
                                 retMap.put("code", "1");
                             }
                         }
                     }
                 }

             }else{
                 String getValue = stringRedisTemplate.opsForValue().get("cmd_type_" + messageQueueVo.getCmd()+":"+messageQueueVo.getSid());
                 if(StringUtils.isNotBlank(getValue)){
                     JSONObject retJson = JSON.parseObject(getValue);
                     //会话id
                     retMap.put("sid",retJson.getString("sid"));
                     //cmd
                     retMap.put("cmd",String.valueOf(messageQueueVo.getCmd()));
                     switch (messageQueueVo.getCmd()){
                         case 12:
                             //发送视频流
                             retMap.put("sendurl",retJson.getString("sendurl"));
                             //播放视频流
                             retMap.put("playurl",retJson.getString("playurl"));
                             stringRedisTemplate.opsForValue().getAndSet("cmd_type_"+retJson.getString("cmd")+":"+retJson.getString("sid"), "视频流已获取");
                             break;
                         case 13:
                             // 收到截图之后的逻辑
                             //发送图片信息
                             retMap.put("fileurl",retJson.getString("fileurl"));
                             //图片附加类型
                             retMap.put("type",retJson.getString("type"));
                             stringRedisTemplate.opsForValue().getAndSet("cmd_type_"+retJson.getString("cmd")+":"+retJson.getString("sid"), "图片已下载");
                             break;
                         case 14:
                             //文字信息
                             retMap.put("msg",retJson.getString("msg"));
                             //会话序号
                             retMap.put("no",retJson.getString("no"));
                             break;
                         case 18:
                             //视频对象
                             List<Object> videos = new ArrayList<>();
                             //视频文件名
                             videos.add(retJson.getString("name"));
                             //下载视频URL
                             videos.add(retJson.getString("url"));
                             break;
                         case 17:
                             //客户挂断 1为挂断
                             //TimeUnit.SECONDS.sleep(30);
                             retMap.put("status","1");
                             break;
                         default:
                             break;
                     }
                 }
                 //30为自定义CMD
                 //查询是否有中断、离线的客户信息
                 String get17Value = stringRedisTemplate.opsForValue().get("cmd_type_17:"+messageQueueVo.getSid());
                 String get19Value = stringRedisTemplate.opsForValue().get("cmd_type_19:"+messageQueueVo.getSid());
                 if(StringUtils.isNotBlank(get17Value) || StringUtils.isNotBlank(get19Value)){
                     retMap.put("status","1");
                 }
             }
        } catch (Exception e) {
            LOGGER.error("获取队列消息为空{}",e.getMessage());
        }
        return retMap;
    }


    @Override
    public Map<String, String> setRedisMS(String key, String value) {
        Map<String, String> retMap = new HashMap<String, String>();
        try{
            if((key).equals("11")){
                //判断呼叫理赔座席放入队列
                //振铃事件
                redisTemplate.opsForList().leftPush("ring_agent:cmd_type_11", value.toString());
                LOGGER.info("写redis队列振铃消息ring_agent:cmd_type_11：{}",value.toString());
            }else{
                stringRedisTemplate.opsForValue().set("cmd_type_"+key+":", value.toString(), Long.valueOf(reidsTimeOut),TimeUnit.SECONDS);
                LOGGER.info("写redis的消息 ","cmd_type_"+key+":", value.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return retMap;
    }

    @Override
    public void downloadVideoFile() {
        SimpleDateFormat dfYY = new SimpleDateFormat("yyyy");
        SimpleDateFormat dfMM = new SimpleDateFormat("MM");
        SimpleDateFormat dfdd = new SimpleDateFormat("dd");
        FileOutputStream fileOut = null;
        InputStream inputStream = null;
        String  path = "";
        try {
            //从获取录音文件
            Set<String> historyVideoList = stringRedisTemplate.keys("cmd_type_18:*");
            LOGGER.info("获取历史录音文件 {} 个",historyVideoList.size());
            for (String historyVideo : historyVideoList) {
                LOGGER.info("获取历史录音信息:{}",historyVideo);
                //根据返回的key 获取value信息
                String historyVideoValue = stringRedisTemplate.opsForValue().get(historyVideo);
                historyVideoDto videos = JSON.parseObject(historyVideoValue, historyVideoDto.class);
//                String name = videos.getVideos().get(0).getName();
                String url = videos.getVideos().get(0).getUrl();
                String sid = videos.getSid();
                //根据录音连接下载文件流
                inputStream = HttpsUtils.downloadFile(url);
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                //判断当前系统是否为windows
                String os = System.getProperty("os.name");
                if( os != null && os.startsWith("Windows")){
                    path = winFilePath;
                }else{
                    path = linuxFilepath;
                }
                //拼文件保存路径
                StringBuffer filePath = new StringBuffer();
                filePath.append(path).append("/");
                //获取sid对应保存时间，解析目录路径
                String videoHistorySrt = stringRedisTemplate.opsForValue().get("cmd_type_videoHistory:"+sid);
                if(videoHistorySrt != null){
                    //获取接通时间
                    JSONObject videoHistoryJson = JSON.parseObject(videoHistorySrt);
                    String callTime = videoHistoryJson.getString("callTime");
                    String[] DateSplit = callTime.split("-");
                    //如果没有获取截取的日期则按当前时间去保存信息
                    if(DateSplit.length >0 ){
                        filePath.append(DateSplit[0]).append("/");
                        filePath.append(DateSplit[1]).append("/");
                        filePath.append(DateSplit[2]).append("/");
                    }
                }else{
                    //按日期层级保存视频文件
                    Calendar forCar = Calendar.getInstance();
                    Date today = forCar.getTime();
                    filePath.append(dfYY.format(today)).append("/");
                    filePath.append(dfMM.format(today)).append("/");
                    filePath.append(dfdd.format(today)).append("/");
                }
                //创建目录
                new ControlFileUtil().newFile(filePath.toString());
                //拼接文件名
                filePath.append(sid);
                filePath.append(".mp4");
                fileOut = new FileOutputStream(filePath.toString());
                BufferedOutputStream bos = new BufferedOutputStream(fileOut);
                byte[] buf = new byte[4096];
                int length = bis.read(buf);
                while(length != -1){
                    bos.write(buf, 0, length);
                    length = bis.read(buf);
                }
                bos.close();
                bis.close();
                LOGGER.info("{} 历史视频下载完成,路径地址：{}",historyVideo,filePath.toString());
                //修改key的名称,保证文件下载不再被轮询读取
                stringRedisTemplate.rename(historyVideo,"cmd_type_1801:"+sid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public HttpServletResponse getHistoryVideoRequset(HttpServletResponse response , String promp) {
        //录音下载
        try {
            //解密参数
            AESEncryptUtil aesEncryptUtil = new AESEncryptUtil();
            String decryption = aesEncryptUtil.decryption(promp , AESCode);
            String[] propSplit = decryption.split("&");
            String sid = propSplit[0];
            String file = propSplit[1].replaceAll("-","/");
            String outFile = "";
            String fileName ="";
            //判断当前系统是否为windows
            String os = System.getProperty("os.name");
            if( os != null && os.startsWith("Windows")){
                outFile = winFilePath;
            }else{
                outFile = linuxFilepath;
            }
            fileName = sid+".mp4";
            outFile = outFile+"/"+file+"/"+fileName;
            LOGGER.info("videoFilePath:{}",outFile);
            response.reset();
            File dfile = new File(outFile);
            FileInputStream in = new FileInputStream(outFile);
            //通过response对象获得输出流
            OutputStream out = response.getOutputStream();
            response.setContentType("Application/Octet-stream;charset=utf-8");
            // 下载文件的名字通过这里设置
            outFile = outFile.substring(outFile.lastIndexOf("/")-1, outFile.length());
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            response.setContentLength((int) dfile.length());
            byte[] bs =new byte[1024];
            int len = 0;
            while((len =in.read(bs))!=-1){
                out.write(bs);
            }
            in.close();
            out.flush();
            out.close();
            LOGGER.info("获取录音 sid:{}, 生成数据流发送给客户端成功！",sid);
        } catch (Exception e) {
            LOGGER.info("录音取消播放！,{}",e.getMessage());
        }
        return response;
    }

    @Override
    public String setHsitroyVIdeoCallTime(String sid) {
        String callTime = "";
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            JSONObject value = new JSONObject();
            callTime = sdf.format(new Date());
            value.put("sid",sid);
            value.put("callTime",callTime);
            //存入redis分组中，保存一天
            stringRedisTemplate.opsForValue().set("cmd_type_videoHistory:"+sid, value.toString(), Long.valueOf(reidsTimeOut), TimeUnit.SECONDS);
            LOGGER.info("写redis的消息 ", "cmd_type_videoHistory:"+sid, value.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callTime;
    }
}
