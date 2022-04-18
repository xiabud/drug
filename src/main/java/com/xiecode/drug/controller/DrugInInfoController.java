package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.DrugInInfo;
import com.xiecode.drug.service.DrugInInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiewc
 * @since 2022-04-18
 */
@Controller
@RequestMapping("/drugInInfo")
public class DrugInInfoController {

    @Autowired
    private DrugInInfoService drugininfoService;


    /**
     * @Description: 转向药品进货记录页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    public String drugInInfo() {

        return "/drugInInfo";
    }


    /**
     * @Description: 转向分页查询药品进货记录页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInInfoQueryPage")
    @ResponseBody
    public Object drugInInfoQueryPage(String param, @RequestParam(value = "page", defaultValue = "1") int pageNum, @RequestParam(value = "limit", defaultValue = "10") int pageSize) {
        try {
            IPage<DrugInInfo> iPage = drugininfoService.selectDrugInInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品进货记录新增页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    //@RequestMapping("/drugInInfoPage")
    //public String drugInInfoPage() {
    //
    //    return "/drugInInfoPage";
    //}


    /**
     * @Description: 转向药品进货记录添加页面
     * @param: [drugInInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInInfoAdd")
    @ResponseBody
    public Object drugInInfoAdd(DrugInInfo drugininfo) {
        try {
            int i = drugininfoService.addDrugInInfo(drugininfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向药品进货记录编辑页面
     * @param: [id, model]
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    //@RequestMapping("/drugInInfoQueryById")
    //public String drugInInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
    //    DrugInInfo druginfo = drugininfoService.queryDrugInInfoById(id);
    //    model.addAttribute("obj", druginfo);
    //    return "/drugInInfoPage";
    //}


    /**
     * @Description: 修改一个药品进货记录
     * @param: [drugInInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInInfoEdit")
    @ResponseBody
    public Object drugInInfoEdit(DrugInInfo druginfo) {
        try {
            int i = drugininfoService.editDrugInInfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品进货记录
     * @param: [id]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInInfoDelById")
    @ResponseBody
    public Object drugInInfoDelById(Integer id) {
        try {
            int i = drugininfoService.deleteDrugInInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 获取所有的药品进货记录名称
     * @param: []
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @RequestMapping("/drugInInfoList")
    @ResponseBody
    public Object drugInInfoList() {
        List<DrugInInfo> drugList = drugininfoService.queryDrugInInfoList();
        return ResultMapUtil.getHashMapList(drugList);
    }


}

