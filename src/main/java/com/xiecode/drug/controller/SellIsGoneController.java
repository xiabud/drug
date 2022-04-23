package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.DrugInfo;
import com.xiecode.drug.pojo.InsellDrugInfo;
import com.xiecode.drug.pojo.SellIsGone;
import com.xiecode.drug.service.BillInfoService;
import com.xiecode.drug.service.DrugInfoService;
import com.xiecode.drug.service.InsellDrugInfoService;
import com.xiecode.drug.service.SellIsGoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
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
 * @since 2022-04-23
 */
@Controller
@RequestMapping("/sellIsGone")
public class SellIsGoneController {


    @Autowired
    private SellIsGoneService sellIsGoneService;

    @Autowired
    private InsellDrugInfoService insellDrugInfoService;

    @Autowired
    private BillInfoService billInfoService;

    @Autowired
    private DrugInfoService drugInfoService;


    /**
     * @Description: 转向药品进货记录页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    @Transactional
    public String sellIsGone() {
        //找出库存为0的药品信息
        List<InsellDrugInfo> insellDrugInfos = insellDrugInfoService.drugInInfoListByDrugCount();
        if (insellDrugInfos != null) {
            for (InsellDrugInfo insellDrugInfo : insellDrugInfos) {
                SellIsGone sellIsGone = new SellIsGone();
                //根据药品进货编码主键查询药品进货时进货数量
                DrugInfo drugInfo = drugInfoService.selectDrugInfoByDname(insellDrugInfo.getDname());
                sellIsGone.setName(insellDrugInfo.getDname());
                sellIsGone.setSupplier(drugInfo.getSupplier());
                sellIsGone.setDruginnum(insellDrugInfo.getInnum());
                sellIsGone.setSellnnum(insellDrugInfo.getSellnum() - insellDrugInfo.getReturnnum());
                sellIsGone.setReturnnum(insellDrugInfo.getReturnnum());
                sellIsGone.setSellrate((Float.valueOf(insellDrugInfo.getSellnum()) / Float.valueOf(insellDrugInfo.getSellnum() + insellDrugInfo.getReturnnum())));
                //将数据插入药品售完信息表
                int i = sellIsGoneService.insert(sellIsGone);
                if (i == 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
                //插入成功后将删除库存为0的药品信息
                insellDrugInfoService.deleteInsellDrugInfoByID(insellDrugInfo.getId());
            }
        }
        return "/sellIsGone";
    }


    /**
     * @Description: 转向分页查询药品进货记录页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/sellIsGoneQueryPage")
    @ResponseBody
    public Object sellIsGoneQueryPage(String param, @RequestParam(value = "page", defaultValue = "1") int pageNum, @RequestParam(value = "limit", defaultValue = "10") int pageSize) {
        try {
            IPage<SellIsGone> iPage = sellIsGoneService.selectrugIsGonePage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品售完信息记录
     * @param: [id]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/sellIsGoneDelById")
    @ResponseBody
    public Object sellIsGoneDelById(Integer id) {
        try {
            int i = sellIsGoneService.deleteSellIsGoneByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}

