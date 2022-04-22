package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.InsellDrugInfo;
import com.xiecode.drug.service.InsellDrugInfoService;
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
 * @since 2022-04-22
 */
@Controller
@RequestMapping("/insellDrugInfo")
public class InsellDrugInfoController {

    @Autowired
    private InsellDrugInfoService insellDrugInfoService;


    /**
     * @Description: 转向药品在售记录页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    public String insellDrugInfo() {

        //查询药品在售记录里边库存为零的的记录

        return "/insellDrugInfo";
    }


    /**
     * @Description: 转向分页查询药品在售记录页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/insellDrugInfoQueryPage")
    @ResponseBody
    public Object insellDrugInfoQueryPage(String param, @RequestParam(value = "page", defaultValue = "1") int pageNum, @RequestParam(value = "limit", defaultValue = "10") int pageSize) {
        try {
            IPage<InsellDrugInfo> iPage = insellDrugInfoService.selectInsellDrugInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品在售记录新增页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    //@RequestMapping("/insellDrugInfoPage")
    //public String insellDrugInfoPage() {
    //
    //    return "/insellDrugInfoPage";
    //}


    /**
     * @Description: 转向药品在售记录添加页面
     * @param: [insellDrugInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/insellDrugInfoAdd")
    @ResponseBody
    public Object insellDrugInfoAdd(InsellDrugInfo insellDrugInfo) {
        try {
            int i = insellDrugInfoService.addInsellDrugInfo(insellDrugInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向药品在售记录编辑页面
     * @param: [id, model]
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    //@RequestMapping("/insellDrugInfoQueryById")
    //public String insellDrugInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
    //    InsellDrugInfo druginfo = insellDrugInfoService.queryInsellDrugInfoById(id);
    //    model.addAttribute("obj", druginfo);
    //    return "/insellDrugInfoPage";
    //}


    /**
     * @Description: 修改一个药品在售记录
     * @param: [insellDrugInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/insellDrugInfoEdit")
    @ResponseBody
    public Object insellDrugInfoEdit(InsellDrugInfo druginfo) {
        try {
            int i = insellDrugInfoService.editInsellDrugInfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品在售记录
     * @param: [id]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/insellDrugInfoDelById")
    @ResponseBody
    public Object insellDrugInfoDelById(Integer id) {
        try {
            int i = insellDrugInfoService.deleteInsellDrugInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 获取所有的药品在售记录名称
     * @param: []
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @RequestMapping("/insellDrugInfoList")
    @ResponseBody
    public Object insellDrugInfoList() {
        List<InsellDrugInfo> drugList = insellDrugInfoService.queryInsellDrugInfoList();
        return ResultMapUtil.getHashMapList(drugList);
    }

    /**
     * @Description: 获取所有的药品进货的进货编码
     * @param: []
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @RequestMapping("/insellDrugInfoListByDrugName")
    @ResponseBody
    public Object insellDrugInfoListByDrugName(String dname) {
        List<InsellDrugInfo> drugList = insellDrugInfoService.insellDrugInfoListByDrugName(dname);
        return ResultMapUtil.getHashMapList(drugList);
    }

}

