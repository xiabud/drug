package com.xiecode.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.OrderCoderUtil;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.BillInfo;
import com.xiecode.drug.pojo.DrugInInfo;
import com.xiecode.drug.pojo.DrugInfo;
import com.xiecode.drug.service.BillInfoService;
import com.xiecode.drug.service.DrugInInfoService;
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
 * 销售记录 前端控制器
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
@Controller
@RequestMapping("/billInfo")
public class BillInfoController {
    @Autowired
    private BillInfoService billInfoService;

    @Autowired
    private DrugInfoService drugInfoService;

    @Autowired
    private DrugInInfoService drugInInfoService;


    /**
     * @Description: 转向账单信息页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    public String billInfo() {
        return "/billInfo";
    }


    /**
     * @Description: 转向分页查询账单信息页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/billInfoQueryPage")
    @ResponseBody
    public Object billInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<BillInfo> iPage = billInfoService.selectBillInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向账单信息新增页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/billInfoPage")
    public String billInfoPage() {

        return "/billInfoPage";
    }


    /**
     * @Description: 转向账单信息添加页面
     * @param: [billInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/billInfoAdd")
    @ResponseBody
    public Object billInfoAdd(BillInfo billInfo) {
        try {
            //获取药的信息
            DrugInfo drugInfo = drugInfoService.selectDrugInfoByDname(billInfo.getDname());
            //获取药品进货信息中最大的id
            int id = drugInInfoService.selectMaxID();
            //添加账单的同时更新药品进货信息
            DrugInInfo drugInInfo = new DrugInInfo();
            drugInInfo.setName(drugInfo.getName());
            drugInInfo.setSupplier(drugInfo.getSupplier());
            drugInInfo.setWarranty(drugInfo.getWarrenty());
            drugInInfo.setDruginnum(OrderCoderUtil.getOrderCode((long) id));
            drugInInfo.setDruginprice(billInfo.getCount() * drugInfo.getPrice());
            drugInInfo.setDrugcount(billInfo.getCount());
            drugInInfo.setIntime(billInfo.getBuyTime());
            int insert = drugInInfoService.insert(drugInInfo);
            billInfo.setDruginnum(drugInInfo.getDruginnum());
            billInfo.setSname(drugInfo.getSupplier());
            billInfo.setTotal(drugInInfo.getDruginprice());
            if (insert == 0) {
                return ResultMapUtil.getFailInsert();
            }
            int i = billInfoService.addBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultMapUtil.getHashMapException(e);

        }

    }


    /**
     * @Description: 转向账单信息编辑页面
     * @param: [id, model]
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/billInfoQueryById")
    public String billInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        BillInfo billInfo = billInfoService.queryBillInfoById(id);
        model.addAttribute("obj",billInfo);
        return "/billInfoPage";
    }


    /**
     * @Description: 修改一个账单信息
     * @param: [billInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/billInfoEdit")
    @ResponseBody
    public Object billInfoEdit(BillInfo billInfo) {
        try {
            int i = billInfoService.editBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个账单信息
     * @param: [id]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/billInfoDelById")
    @ResponseBody
    public Object billInfoDelById(Integer id) {
        try {
            int i = billInfoService.deleteBillInfoByID(id);
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
    @RequestMapping("/billInfoList")
    @ResponseBody
    public Object drugInfoList(String sname) {
        List<BillInfo> billInfoList = billInfoService.queryDrugInfoListBySName(sname);
        return ResultMapUtil.getHashMapList(billInfoList);
    }


}

