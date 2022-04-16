package com.xiecode.drug.common;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: 给前端返回json
 * @return: json
 * @Author: Xiewc
 * @Date: 2022/2/15
 */

public class ResultMapUtil {

    /**
     * @Description: 登录返回结果
     * @return:
     * @Author: Xiewc
     * @Date: 2022/2/15
     */
    public static HashMap<String, Object> getHashMapLogin(String msg, String code) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", msg);
        resultMap.put("code", code);
        if ("1".equals(code)) {
            resultMap.put("icon", 1);
        } else {
            resultMap.put("icon", 3);
        }
        resultMap.put("anim", 4);
        return resultMap;
    }

    /**
    * @Description: 分页查询结果
    * @param: [Object]
    * @return: java.util.HashMap<java.lang.String,java.lang.Object>
    * @Author: Xiewc
    * @Date: 2022/2/22
    */
    public static HashMap<String, Object> getHashMapMysqlPage(IPage<?> Object) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", Object.getTotal());
        resultMap.put("data", Object.getRecords());
        return resultMap;
    }

    /**
    * @Description: 异常数据统一处理
    * @param: [e]
    * @return: java.util.HashMap<java.lang.String,java.lang.Object>
    * @Author: Xiewc
    * @Date: 2022/2/21
    */
    public static HashMap<String, Object> getHashMapException(Exception e) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 0);
        resultMap.put("msg", e.getMessage());
        return resultMap;
    }


    /**
    * @Description: 保存成功统一返回格式
    * @param: [i]
    * @return: java.util.HashMap<java.lang.String,java.lang.Object>
    * @Author: Xiewc
    * @Date: 2022/3/1
    */
    public static HashMap<String, Object> getHashMapSave(int i) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if (i == 0) {
            resultMap.put("msg", "保存失败");
            resultMap.put("code", 1);
            resultMap.put("icon", 5);
            resultMap.put("anim", 6);
        }else {
            resultMap.put("msg", "保存成功");
            resultMap.put("code", 0);
            resultMap.put("icon", 1);
            resultMap.put("anim", 4);
        }
        return resultMap;
    }

    /**
     * @Description: 删除成功统一返回格式
     * @param: [i]
     * @return: java.util.HashMap<java.lang.String,java.lang.Object>
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    public static HashMap<String, Object> getHashMapDel(int i) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if (i == 0) {
            resultMap.put("msg", "删除失败");
            resultMap.put("code", 1);
            resultMap.put("icon", 5);
            resultMap.put("anim", 6);
        }else {
            resultMap.put("msg", "删除成功");
            resultMap.put("code", 0);
            resultMap.put("icon", 1);
            resultMap.put("anim", 4);
        }
        return resultMap;
    }

    /**
    * @Description: 查询list统一返回格式
    * @param: [list]
    * @return: java.util.HashMap<java.lang.String,java.lang.Object>
    * @Author: Xiewc
    * @Date: 2022/3/17
    */
    public static HashMap<String, Object> getHashMapList(List<?> list) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 0);
        if (list != null && list.size() > 0) {
            resultMap.put("msg", "");

        } else {
            resultMap.put("msg", "没有查询到数据");
        }
        resultMap.put("data", list);
        return resultMap;
    }




}
