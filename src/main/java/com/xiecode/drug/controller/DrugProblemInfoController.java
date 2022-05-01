package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.DrugInfo;
import com.xiecode.drug.pojo.DrugProblemInfo;
import com.xiecode.drug.pojo.ReturnSupplierInfo;
import com.xiecode.drug.service.DrugInInfoService;
import com.xiecode.drug.service.DrugInfoService;
import com.xiecode.drug.service.DrugProblemInfoService;
import com.xiecode.drug.service.ReturnSupplierInfoService;
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

    @Autowired
    private DrugInfoService drugInfoService;

    @Autowired
    private DrugInInfoService drugInInfoService;

    @Autowired
    private ReturnSupplierInfoService returnSupplierInfoService;


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
            DrugInfo drugInfo = drugInfoService.selectDrugInfoByDname(drugProblemInfo.getDname());
            int i1 = drugInInfoService.selectDrugCountByDruginnum(drugProblemInfo.getDruginnum());
            if (i1 < drugProblemInfo.getDcount()) {
                return ResultMapUtil.getStockLess();
            }
            drugProblemInfo.setCreateTime(new Date());
            drugProblemInfo.setDprice(drugInfo.getPrice());
            int i = drugProblemInfoService.addDrugProblemInfo(drugProblemInfo);
            return ResultMapUtil.returnDrugSave(i);
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
    public Object drugProblemInfoDelById(Integer id) {
        try {
            int i = drugProblemInfoService.deleteDrugProblemInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * @Description: 退货一个问题药品
     * @param: [drugProblemInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugProblemInfoReturn")
    @ResponseBody
    public Object drugProblemInfoReturn(Integer id) {
        try {
            //先获取要退货的药品信息
            DrugProblemInfo drugProblemInfo = drugProblemInfoService.queryDrugProblemInfoById(id);
            //已退货
            if ("已退货".equals(drugProblemInfo.getIsreturn())) {
                return ResultMapUtil.getisReturnSupplier();
            }
            //先获取要退货的药品所属的供应商
            DrugInfo drugInfo = drugInfoService.selectDrugInfoByDname(drugProblemInfo.getDname());
            //更新退货给供应商的数据
            ReturnSupplierInfo returnSupplierInfo = new ReturnSupplierInfo();
            returnSupplierInfo.setDname(drugProblemInfo.getDname());
            returnSupplierInfo.setDcount(drugProblemInfo.getDcount());
            returnSupplierInfo.setDruginnum(drugProblemInfo.getDruginnum());
            returnSupplierInfo.setSupplierName(drugInfo.getSupplier());
            returnSupplierInfo.setReason("问题药品导入退货：" + drugProblemInfo.getReason());
            returnSupplierInfo.setCreateTime(new Date());
            int i1 = returnSupplierInfoService.addReturnSupplierInfo(returnSupplierInfo);
            if (i1 == 0) {
                return ResultMapUtil.getFailInsertReturnSupplier();
            }
            //更新药品信息的总库存
            int i3 = drugInfoService.updateReduceStock(drugProblemInfo.getDcount(), drugProblemInfo.getDname());
            if (i3 == 0) {
                return ResultMapUtil.getFailUpdateDrugInfo();
            }
            //更新问题药品表的退货标识
            int i = drugProblemInfoService.updateDrugProblemInfoBydrugInNum(drugProblemInfo.getDruginnum(), drugProblemInfo.getCreateTime());
            return ResultMapUtil.getReturnSupplierSuccess(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


}

