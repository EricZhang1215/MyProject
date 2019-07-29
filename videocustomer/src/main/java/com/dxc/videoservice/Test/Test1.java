package com.dxc.videoservice.Test;

import com.dxc.videoservice.utils.AESEncryptUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author He Biao
 * @date 2018-10-17
 */
public class Test1 {

    public static void main(String []args ){
        try {

            SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//           SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long startDate = sf.parse("1970-01-01 00:00:00").getTime();
            String formatDateSrt = sf.format(new Date());
            System.out.println("formatDateSrt："+formatDateSrt);
            long newDate = sf.parse(formatDateSrt).getTime();
            long interval = ( newDate - startDate)/1000;
            System.out.println("newDate:"+newDate);
            System.out.println("startDate:"+startDate);
            System.out.println("interval："+interval);
            long  val= new Date().getTime()/1000;
            System.out.println("val："+val);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

