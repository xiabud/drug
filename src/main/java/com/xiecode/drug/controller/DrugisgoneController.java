package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.BillInfo;
import com.xiecode.drug.pojo.DrugInInfo;
import com.xiecode.drug.pojo.DrugIsGone;
import com.xiecode.drug.service.BillInfoService;
import com.xiecode.drug.service.DrugInInfoService;
import com.xiecode.drug.service.DrugIsGoneService;
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
 * @since 2022-04-22
 */
@Controller
@RequestMapping("/drugIsGone")
public class DrugisgoneController {


    @Autowired
    private DrugIsGoneService drugIsGoneService;

    @Autowired
    private DrugInInfoService drugInInfoService;

    @Autowired
    private BillInfoService billInfoService;


    /**
     * @Description: 转向药品进货记录页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    @Transactional
    public String drugIsGone() {
        //找出库存为0的药品信息
        List<DrugInInfo> drugInInfos = drugInInfoService.drugInInfoListByDrugCount();
        if (drugInInfos != null) {
            for (DrugInInfo drugInInfo : drugInInfos) {
                DrugIsGone drugIsGone = new DrugIsGone();
                //根据药品进货编码主键查询药品进货时进货数量
                BillInfo billInfo = billInfoService.selectCountByDrugInnum(drugInInfo.getDruginnum());
                drugIsGone.setName(drugInInfo.getName());
                drugIsGone.setSupplier(drugInInfo.getSupplier());
                drugIsGone.setDruginnum(drugInInfo.getDruginnum());
                drugIsGone.setSellnnum(billInfo.getCount() - drugInInfo.getDrugretuen());
                drugIsGone.setReturnnum(drugInInfo.getDrugretuen());
                drugIsGone.setSellrate((Float.valueOf(drugIsGone.getSellnnum()) / Float.valueOf(billInfo.getCount())));
                //将数据插入药品售完信息表
                int i = drugIsGoneService.insert(drugIsGone);
                if (i == 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
                //插入成功后将删除库存为0的药品信息
                drugInInfoService.deleteDrugInInfoByID(drugInInfo.getId());
            }
        }
        return "/drugIsGone";
    }


    /**
     * @Description: 转向分页查询药品进货记录页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/drugIsGoneQueryPage")
    @ResponseBody
    public Object drugIsGoneQueryPage(String param, @RequestParam(value = "page", defaultValue = "1") int pageNum, @RequestParam(value = "limit", defaultValue = "10") int pageSize) {
        try {
            IPage<DrugIsGone> iPage = drugIsGoneService.selectrugIsGonePage(pageNum, pageSize, param);
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
    @RequestMapping("/drugIsGoneDelById")
    @ResponseBody
    public Object drugIsGoneDelById(Integer id) {
        try {
            int i = drugIsGoneService.deleteDrugIsGoneByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


}

