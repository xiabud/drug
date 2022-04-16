package com.xiecode.drug.common;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Description: 日期处理相关类
* @param:
* @return:
* @Author: Xiewc
* @Date: 2022/3/16
*/
public class DateUtil {


    public static String dataConvert(Date date) {
        //"yyyy-MM-dd HH:mm:ss"
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

}
