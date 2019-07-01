package com.dxc.utils;


import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 3/26/2019
 *
 * @author qzhang52
 * @version 1.0
 */

public class BeanUtil {

    public static <T> T copyBean(Object source, T target, String... ignoreProperties) {
        org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
        return target;
    }

    public static Object getFieldValueByName(String fieldName, Object bean) {
        try {
            if (StringUtils.isBlank(fieldName)) {
                return null;
            }
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = bean.getClass().getMethod(getter);
            return method.invoke(bean);
        } catch (Exception e) {
            LogUtil.error("failed to getFieldValueByName. ", e);
            return null;
        }
    }

    public static void setFieldValueByName(Object bean, String fieldName, Object value, Class<?> type) {
        try {
            if (StringUtils.isBlank(fieldName)) {
                return;
            }
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String setter = "set" + firstLetter + fieldName.substring(1);
            Method method = bean.getClass().getMethod(setter, type);
            method.invoke(bean, value);
        } catch (Exception e) {
            LogUtil.error("failed to setFieldValueByName. ", e);
        }
    }


    public static Object getBean(String className) throws Exception {
        Class cls = null;
        try {
            cls = Class.forName(className);//对应Spring ->bean -->class
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new Exception("类错误！");
        }

        Constructor[] cons = null;//得到所有构造器
        try {
            cons = cls.getConstructors();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("构造器错误！");
        }
        if (cons == null || cons.length < 1) {
            throw new Exception("没有默认构造方法！");
        }
        //如果上面没错，就有构造方法

        Constructor defCon = cons[0];//得到默认构造器,第0个是默认构造器，无参构造方法
        Object obj = defCon.newInstance();//实例化，得到一个对象 //Spring - bean -id
        return obj;
    }

    public static void setProperty(Object bean, String propertyName, Object propertyValue) throws Exception {
        Class cls = bean.getClass();
        Method[] methods = cls.getMethods();//得到所有方法
        //cls.getFields();//所有公开字段属性
        //注入属性 用户名：admin setUsername();
        // obj username admin
        //String propertyName = "username";//对应 Spring配置文件- property ->name
        //String propertyValue = "admin";//对应：Spring -- property -->ref/value
        for (Method m : methods) {
            if (m.getName().equalsIgnoreCase("set" + propertyName)) {
                //找到方法就注入
                m.invoke(bean, propertyValue);
                break;
            }
        }
    }
}
