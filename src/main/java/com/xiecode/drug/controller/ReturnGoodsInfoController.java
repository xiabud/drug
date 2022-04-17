package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.ReturnGoodsInfo;
import com.xiecode.drug.service.ReturnGoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 收到退货表 前端控制器
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
@Controller
@RequestMapping("/returnGoodsInfo")
public class ReturnGoodsInfoController {

    @Autowired
    private ReturnGoodsInfoService returnGoodsInfoService;


    /**
     * @Description: 转向药品退货信息页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    public String returnGoodsInfo() {
        return "/returnGoodsInfo";
    }


    /**
     * @Description: 转向分页查询药品退货信息页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnGoodsInfoQueryPage")
    @ResponseBody
    public Object returnGoodsInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<ReturnGoodsInfo> iPage = returnGoodsInfoService.selectReturnGoodsInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品退货信息新增页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnGoodsInfoPage")
    public String returnGoodsInfoPage() {

        return "/returnGoodsInfoPage";
    }


    /**
     * @Description: 转向药品退货信息添加页面
     * @param: [returnGoodsInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnGoodsInfoAdd")
    @ResponseBody
    public Object returnGoodsInfoAdd(ReturnGoodsInfo returnGoodsInfo) {
        try {
            int i = returnGoodsInfoService.addReturnGoodsInfo(returnGoodsInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向药品退货信息编辑页面
     * @param: [id, model]
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnGoodsInfoQueryById")
    public String returnGoodsInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        ReturnGoodsInfo returnGoodsInfo = returnGoodsInfoService.queryReturnGoodsInfoById(id);
        model.addAttribute("obj",returnGoodsInfo);
        return "/returnGoodsInfoPage";
    }


    /**
     * @Description: 修改一个药品退货信息
     * @param: [returnGoodsInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnGoodsInfoEdit")
    @ResponseBody
    public Object returnGoodsInfoEdit(ReturnGoodsInfo returnGoodsInfo) {
        try {
            int i = returnGoodsInfoService.editReturnGoodsInfo(returnGoodsInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品退货信息
     * @param: [id]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/returnGoodsInfoDelById")
    @ResponseBody
    public Object returnGoodsInfoDelById(Integer id){
        try {
            int i = returnGoodsInfoService.deleteReturnGoodsInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}

