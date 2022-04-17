package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.ReturnSupplierInfo;

import java.util.List;

/**
 * <p>
 * 退回给供应商表 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
public interface ReturnSupplierInfoService extends IService<ReturnSupplierInfo> {

    /**
     * @Description: 分页查询药品退货记录信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.ReturnSupplierInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    IPage<ReturnSupplierInfo> selectReturnSupplierInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条药品退货记录信息
     * @param: [returnSupplierInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int addReturnSupplierInfo(ReturnSupplierInfo returnSupplierInfo);

    /**
     * @Description: 编辑修改一条药品退货记录信息
     * @param: [returnSupplierInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int editReturnSupplierInfo(ReturnSupplierInfo returnSupplierInfo);

    /**
     * @Description: 根据id来查询药品退货记录的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.ReturnSupplierInfo
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    ReturnSupplierInfo queryReturnSupplierInfoById(int id);

    /**
     * @Description: 根据id来删除药品退货记录的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int deleteReturnSupplierInfoByID(int id);

    /**
     * @Description: 获取所有的药品退货记录信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.ReturnSupplierInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    List<ReturnSupplierInfo> queryReturnSupplierInfoList();

}
