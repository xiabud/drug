package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.Supplier;
import com.xiecode.drug.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 供应商 前端控制器
 * </p>
 *
 * @author xiewc
 * @since 2022-02-21
 */
@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    /**
     * @Description: 转向供应商页面
     * @param:
     * @return:
     * @Author: Xiewc
     * @Date: 2022/2/22
     */
    @RequestMapping
    public String supplier() {
        return "/supplier";
    }


    /**
     * @Description: 转向分页查询供应商页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/2/22
     */
    @RequestMapping("/supplierQueryPage")
    @ResponseBody
    public Object supplierQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Supplier> iPage = supplierService.selectSupplierPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向供应商新增页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/2/25
     */
    @RequestMapping("/supplierPage")
    public String supplierPage() {

        return "/supplierPage";
    }


    /**
     * @Description: 转向供应商添加页面
     * @param: [supplier]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/supplierAdd")
    @ResponseBody
    public Object supplierAdd(Supplier supplier) {
        try {
            supplier.setCreateTime(new Date());
            int i = supplierService.addSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向供应商编辑页面
     * @param: [id, model]
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/supplierQueryById")
    public String supplierQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Supplier supplier = supplierService.querySupplierById(id);
        model.addAttribute("obj", supplier);
        return "/supplierPage";
    }


    /**
     * @Description: 修改一个供应商
     * @param: [supplier]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/supplierEdit")
    @ResponseBody
    public Object supplierEdit(Supplier supplier) {
        try {
            int i = supplierService.editSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
    * @Description: 删除供应商
    * @param: [id]
    * @return: java.lang.Object
    * @Author: Xiewc
    * @Date: 2022/3/1
    */
    @RequestMapping("/supplierDelById")
    @ResponseBody
    public Object supplierDelById(Integer id){
        try {
            int i = supplierService.deleteSupplierByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
    * @Description: 获取所有的厂商名称
    * @param: []
    * @return: java.lang.Object
    * @Author: Xiewc
    * @Date: 2022/4/16
    */
    @RequestMapping("/supplierList")
    @ResponseBody
    public Object supplierList() {
        List<Supplier> supplierList = supplierService.querySupplierList();
        return ResultMapUtil.getHashMapList(supplierList);
    }
}

