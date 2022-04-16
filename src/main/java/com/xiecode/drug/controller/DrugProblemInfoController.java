package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.DrugProblemInfo;
import com.xiecode.drug.service.DrugProblemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <p>
 * 问题药品表 前端控制器
 * </p>
 *
 * @author xiewc
 * @since 2022-04-16
 */
@Controller
@RequestMapping("/drugProblemInfo")
public class DrugProblemInfoController {
    @Autowired
    private DrugProblemInfoService drugProblemInfoService;


    /**
     * @Description: 转向问题药品页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    public String drugProblemInfo() {
        return "/drugProblemInfo";
    }


    /**
     * @Description: 转向分页查询问题药品页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugProblemInfoQueryPage")
    @ResponseBody
    public Object drugProblemInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<DrugProblemInfo> iPage = drugProblemInfoService.selectDrugProblemInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向问题药品记录新增页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugProblemInfoPage")
    public String drugProblemInfoPage() {

        return "/drugProblemInfoPage";
    }


    /**
     * @Description: 转向问题药品记录添加页面
     * @param: [drugProblemInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugProblemInfoAdd")
    @ResponseBody
    public Object drugProblemInfoAdd(DrugProblemInfo drugProblemInfo) {
        try {
            drugProblemInfo.setCreateTime(new Date());
            int i = drugProblemInfoService.addDrugProblemInfo(drugProblemInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向问题药品记录编辑页面
     * @param: [id, model]
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugProblemInfoQueryById")
    public String drugProblemInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        DrugProblemInfo drugProblemInfo = drugProblemInfoService.queryDrugProblemInfoById(id);
        model.addAttribute("obj",drugProblemInfo);
        return "/drugProblemInfoPage";
    }


    /**
     * @Description: 修改一个问题药品记录
     * @param: [drugProblemInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugProblemInfoEdit")
    @ResponseBody
    public Object drugProblemInfoEdit(DrugProblemInfo drugProblemInfo) {
        try {
            int i = drugProblemInfoService.editDrugProblemInfo(drugProblemInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个问题药品记录
     * @param: [id]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugProblemInfoDelById")
    @ResponseBody
    public Object drugProblemInfoDelById(Integer id){
        try {
            int i = drugProblemInfoService.deleteDrugProblemInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    

}

