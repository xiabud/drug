package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.ReturnSupplierInfo;
import com.xiecode.drug.service.ReturnSupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 退回给供应商表 前端控制器
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
@Controller
@RequestMapping("/returnSupplierInfo")
public class ReturnSupplierInfoController {

    @Autowired
    private ReturnSupplierInfoService returnSupplierInfoService;


    /**
     * @Description: 转向药品退货给供应商信息页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    public String returnSupplierInfo() {
        return "/returnSupplierInfo";
    }


    /**
     * @Description: 转向分页查询药品退货给供应商信息页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnSupplierInfoQueryPage")
    @ResponseBody
    public Object returnSupplierInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<ReturnSupplierInfo> iPage = returnSupplierInfoService.selectReturnSupplierInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品退货给供应商信息新增页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnSupplierInfoPage")
    public String returnSupplierInfoPage() {

        return "/returnSupplierInfoPage";
    }


    /**
     * @Description: 转向药品退货给供应商信息添加页面
     * @param: [returnSupplierInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnSupplierInfoAdd")
    @ResponseBody
    public Object returnSupplierInfoAdd(ReturnSupplierInfo returnSupplierInfo) {
        try {
            int i = returnSupplierInfoService.addReturnSupplierInfo(returnSupplierInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向药品退货给供应商信息编辑页面
     * @param: [id, model]
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnSupplierInfoQueryById")
    public String returnSupplierInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        ReturnSupplierInfo returnSupplierInfo = returnSupplierInfoService.queryReturnSupplierInfoById(id);
        model.addAttribute("obj",returnSupplierInfo);
        return "/returnSupplierInfoPage";
    }


    /**
     * @Description: 修改一个药品退货给供应商信息
     * @param: [returnSupplierInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnSupplierInfoEdit")
    @ResponseBody
    public Object returnSupplierInfoEdit(ReturnSupplierInfo returnSupplierInfo) {
        try {
            int i = returnSupplierInfoService.editReturnSupplierInfo(returnSupplierInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品退货给供应商信息
     * @param: [id]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnSupplierInfoDelById")
    @ResponseBody
    public Object returnSupplierInfoDelById(Integer id){
        try {
            int i = returnSupplierInfoService.deleteReturnSupplierInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}

