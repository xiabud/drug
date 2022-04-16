package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.SaleInfo;

import java.util.List;

/**
 * <p>
 * 账单信息表 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-16
 */
public interface SaleInfoService extends IService<SaleInfo> {
    /**
     * @Description: 分页查询药品销售记录信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.SaleInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    IPage<SaleInfo> selectSaleInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条药品销售记录信息
     * @param: [saleInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int addSaleInfo(SaleInfo saleInfo);

    /**
     * @Description: 编辑修改一条药品销售记录信息
     * @param: [saleInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int editSaleInfo(SaleInfo saleInfo);

    /**
     * @Description: 根据id来查询药品销售记录的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.SaleInfo
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    SaleInfo querySaleInfoById(int id);

    /**
     * @Description: 根据id来删除药品销售记录的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int deleteSaleInfoByID(int id);

    /**
     * @Description: 获取所有的药品销售记录信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.SaleInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    List<SaleInfo> querySaleInfoList();

}
