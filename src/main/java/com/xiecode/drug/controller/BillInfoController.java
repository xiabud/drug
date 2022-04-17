package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.BillInfo;
import com.xiecode.drug.service.BillInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
            int i = billInfoService.addBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
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
    public Object billInfoDelById(Integer id){
        try {
            int i = billInfoService.deleteBillInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    

}

