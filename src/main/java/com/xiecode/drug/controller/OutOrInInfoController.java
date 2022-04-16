package com.xiecode.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.common.ResultMapUtil;
import com.xiecode.drug.pojo.OutOrInInfo;
import com.xiecode.drug.service.OutOrInInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <p>
 * 出入库 前端控制器
 * </p>
 *
 * @author xiewc
 * @since 2022-03-23
 */
@Controller
@RequestMapping("/outOrInInfo")
public class OutOrInInfoController {

    @Autowired
    private OutOrInInfoService outorininfoService;


    /**
     * @Description: 转向药品出入库页面
     * @param: []
     * @return: java.lang.String
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping
    public String outOrInInfo() {
        return "/outOrInInfo";
    }


    /**
     * @Description: 转向分页查询药品出入库页面
     * @param: [param, pageNum, pageSize]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/outOrInInfoQueryPage")
    @ResponseBody
    public Object outOrInInfoQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<OutOrInInfo> iPage = outorininfoService.selectOutOrInInfoPage(pageNum, pageSize, param);
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
    @RequestMapping("/outOrInInfoPage")
    public String outOrInInfoPage() {

        return "/outOrInInfoPage";
    }


    /**
     * @Description: 转向药品出入库添加页面
     * @param: [outOrInInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/outOrInInfoAdd")
    @ResponseBody
    public Object outOrInInfoAdd(OutOrInInfo outorininfo) {
        try {
            outorininfo.setCreateTime(new Date());
            int i = outorininfoService.addOutOrInInfo(outorininfo);
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
    @RequestMapping("/outOrInInfoQueryById")
    public String outOrInInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        OutOrInInfo outorininfo = outorininfoService.queryOutOrInInfoById(id);
        model.addAttribute("obj",outorininfo);
        return "/outOrInInfoPage";
    }


    /**
     * @Description: 修改一个药品出入库
     * @param: [outOrInInfo]
     * @return: java.lang.Object
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @RequestMapping("/outOrInInfoEdit")
    @ResponseBody
    public Object outOrInInfoEdit(OutOrInInfo outorininfo) {
        try {
            int i = outorininfoService.editOutOrInInfo(outorininfo);
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
    @RequestMapping("/outOrInInfoDelById")
    @ResponseBody
    public Object outOrInInfoDelById(Integer id){
        try {
            int i = outorininfoService.deleteOutOrInInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}

