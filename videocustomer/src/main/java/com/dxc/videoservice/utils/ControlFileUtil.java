package com.dxc.videoservice.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ControlFileUtil {

	/**
	 * 判断目录是否存在，目录不存在自动创建
	 * @param path  目录名称
	 */
	public void newFile(String path){
		try{
			File myPath = new File(path);
			if(!myPath.exists() && !myPath.isDirectory()){
				myPath.mkdirs();
				System.out.println("创建目录成功!");
			}else{
			}
		}catch(Exception e){
			System.out.println("已经创建目录!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断文件名是否存在
	 * @param fileName		文件名称
	 * @return				返回文件是否存在， false：不存在， true：存在
	 */
	public boolean fileNameIsDirectory(String fileName){
		boolean ret = false;
		try{
			File myfileName = new File(fileName);
			if(myfileName.exists()){
				ret = true;
				System.out.println("录音已经下载!");
			}
		}catch(Exception e){
			ret = false;
			System.out.println("已经创建目录!");
			e.printStackTrace();
		}
		return ret;
	}
	
	
	/**
	 * 删除文件目录下文件如果没有文件则清空该目录
	 * @param path
	 */
	public void doDeleteFile(String path){
		try {
			//定义路径
			File dir = new File(path);
			//判断是否存在
			if(dir.exists() && dir.isDirectory()){
				//判断文件还是目录 是目录直接删除
				if(dir.listFiles().length == 0){
					dir.delete();
				}else{
					//删除目录下所有文件
					File delFile[] = dir.listFiles();
					int i = dir.listFiles().length;
					for(int j=0;j<i;j++){
						if(delFile[j].isDirectory()){
							doDeleteFile(delFile[j].getAbsolutePath());
						}
						delFile[j].delete();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SimpleDateFormat dfYY = new SimpleDateFormat("yyyy");
		SimpleDateFormat dfMM = new SimpleDateFormat("MM");
		SimpleDateFormat dfdd = new SimpleDateFormat("dd");
//		//删除指定目录下文件
        try {
        	String path ="";
        	//获取昨天日期
        	Calendar forCar = Calendar.getInstance();
    		forCar.add(Calendar.DATE, -1); 
            Date yesterday = forCar.getTime();
            //获取上个月日期
            forCar.add(Calendar.MONTH, -1);
            Date lastMonth = forCar.getTime();
            //获取上一年日期
            forCar.add(Calendar.YEAR, -1);
            Date lastYear = forCar.getTime();
            //调用执行删除文件及目录
            String yesterdayPath = path+"/"+dfYY.format(yesterday)+"/"+dfMM.format(yesterday)+"/"+dfdd.format(yesterday);
    		System.out.println(yesterdayPath);
//    		new ControlFileUtil().newFile(path);
    		String lastDayPath = path+"/"+dfYY.format(lastMonth)+"/"+dfMM.format(lastMonth);
    		System.out.println(lastDayPath);
    		String LastYearPath = path+"/"+dfYY.format(lastYear);
    		System.out.println(LastYearPath);
    		new ControlFileUtil().doDeleteFile(yesterdayPath);
    		new ControlFileUtil().doDeleteFile(lastDayPath);
    		new ControlFileUtil().doDeleteFile(LastYearPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar forCar = Calendar.getInstance();
		Date nowDate = new Date();
		SimpleDateFormat dfs  = new SimpleDateFormat("HH:mm:ss");
		//获取系统当前时间
	    String times = dfs.format(nowDate);
	    System.out.println("执行时间： "+times);
	    //replace方面替换：号为空，将其格式化为int类型
	    int nowTime = Integer.parseInt(times.replace(":", "").toString()) ;
	    System.out.println(nowTime);
	    if(nowTime < 15000){
	    	System.out.println("run <");
	    }else{
	    	System.out.println("run 》");
	    }
	}
}
