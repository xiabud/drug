package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.DrugInfo;
import com.xiecode.drug.pojo.InsellDrugInfo;
import com.xiecode.drug.pojo.SaleInfo;
import com.xiecode.drug.service.DrugInfoService;
import com.xiecode.drug.service.InsellDrugInfoService;
import com.xiecode.drug.service.SaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <p>
 * 账单信息表 前端控制器
 * </p>
 *
 * @author xiewc
 * @since 2022-04-16
 */
@Controller
@RequestMapping("/saleInfo")
public class SaleInfoController {

    @Autowired
    private SaleInfoService saleInfoService;

    @Autowired
    private DrugInfoService drugInfoService;

    @Autowired
    private InsellDrugInfoService insellDrugInfoService;


    /**
     * @Description: 转向药品出入库页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    public String saleInfo() {
        return "/saleInfo";
    }


    /**
     * @Description: 转向分页查询药品出入库页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/saleInfoQueryPage")
    @ResponseBody
    public Object saleInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<SaleInfo> iPage = saleInfoService.selectSaleInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品出入库新增页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/saleInfoPage")
    public String saleInfoPage() {

        return "/saleInfoPage";
    }


    /**
     * @Description: 转向药品出入库添加页面
     * @param: [saleInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/saleInfoAdd")
    @ResponseBody
    public Object saleInfoAdd(SaleInfo saleInfo) {
        try {
            //查询当前药品的价格
            DrugInfo drugInfo = drugInfoService.selectDrugInfoByDname(saleInfo.getDname());
            saleInfo.setOperateTime(new Date());
            saleInfo.setTotal(saleInfo.getCount() * drugInfo.getPrice());
            //更新药品在售信息表的库存
            InsellDrugInfo insellDrugInfo1 = insellDrugInfoService.selectDrugCountByDruginnum(saleInfo.getInnum());
            if (insellDrugInfo1.getSellcount() < saleInfo.getCount()) {
                return ResultMapUtil.getFailUpdateInSellForCount();
            }
            InsellDrugInfo insellDrugInfo = new InsellDrugInfo();
            insellDrugInfo.setSellcount(saleInfo.getCount());
            insellDrugInfo.setSellnum(saleInfo.getCount());
            insellDrugInfo.setOutprice(saleInfo.getTotal());
            insellDrugInfo.setInnum(saleInfo.getInnum());
            int i1 = insellDrugInfoService.updatebyDruginnum(insellDrugInfo);
            if (i1 == 0) {
                return ResultMapUtil.getFailUpdateInSell();
            }
            int i2 = drugInfoService.updateReduceStock(saleInfo.getCount(), saleInfo.getDname());
            if (i2 == 0) {
                return ResultMapUtil.getFailUpdateDrugInfo();
            }
            int i = saleInfoService.addSaleInfo(saleInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品出入库编辑页面
     * @param: [id, model]
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/saleInfoQueryById")
    public String saleInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        SaleInfo saleInfo = saleInfoService.querySaleInfoById(id);
        model.addAttribute("obj",saleInfo);
        return "/saleInfoPage";
    }


    /**
     * @Description: 修改一个药品出入库
     * @param: [saleInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/saleInfoEdit")
    @ResponseBody
    public Object saleInfoEdit(SaleInfo saleInfo) {
        try {
            int i = saleInfoService.editSaleInfo(saleInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品出入库
     * @param: [id]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/saleInfoDelById")
    @ResponseBody
    public Object saleInfoDelById(Integer id){
        try {
            int i = saleInfoService.deleteSaleInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}

