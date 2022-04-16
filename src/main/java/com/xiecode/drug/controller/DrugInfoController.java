package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.DrugInfo;
import com.xiecode.drug.service.DrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 药品 前端控制器
 * </p>
 *
 * @author xiewc
 * @since 2022-03-01
 */
@Controller
@RequestMapping(value = "/drugInfo")
public class DrugInfoController {

    @Autowired
    private DrugInfoService druginfoService;


    /**
     * @Description: 转向药品页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    public String drugInfo() {

        return "/drugInfo";
    }


    /**
     * @Description: 转向分页查询药品页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInfoQueryPage")
    @ResponseBody
    public Object drugInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<DrugInfo> iPage = druginfoService.selectDrugInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品新增页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInfoPage")
    public String drugInfoPage() {

        return "/drugInfoPage";
    }


    /**
     * @Description: 转向药品添加页面
     * @param: [drugInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInfoAdd")
    @ResponseBody
    public Object drugInfoAdd(DrugInfo druginfo) {
        try {
            int i = druginfoService.addDrugInfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向药品编辑页面
     * @param: [id, model]
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInfoQueryById")
    public String drugInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        DrugInfo druginfo = druginfoService.queryDrugInfoById(id);
        model.addAttribute("obj", druginfo);
        return "/drugInfoPage";
    }


    /**
     * @Description: 修改一个药品
     * @param: [drugInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInfoEdit")
    @ResponseBody
    public Object drugInfoEdit(DrugInfo druginfo) {
        try {
            int i = druginfoService.editDrugInfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品
     * @param: [id]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugInfoDelById")
    @ResponseBody
    public Object drugInfoDelById(Integer id) {
        try {
            int i = druginfoService.deleteDrugInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 获取所有的药品名称
     * @param: []
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    @RequestMapping("/drugInfoList")
    @ResponseBody
    public Object drugInfoList() {
        List<DrugInfo> drugList = druginfoService.queryDrugInfoList();
        return ResultMapUtil.getHashMapList(drugList);
    }


    @RequestMapping("/warranty")
    public Object warranty() {
        return "/warranty";
    }
}

