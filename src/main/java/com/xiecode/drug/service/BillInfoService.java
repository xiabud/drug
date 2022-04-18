package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.BillInfo;

import java.util.List;

/**
 * <p>
 * 销售记录 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
public interface BillInfoService extends IService<BillInfo> {
    /**
     * @Description: 分页查询账单信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.BillInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    IPage<BillInfo> selectBillInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条账单信息
     * @param: [billInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int addBillInfo(BillInfo billInfo);

    /**
     * @Description: 编辑修改一条账单信息
     * @param: [billInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int editBillInfo(BillInfo billInfo);

    /**
     * @Description: 根据id来查询账单的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.BillInfo
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    BillInfo queryBillInfoById(int id);

    /**
     * @Description: 根据id来删除账单的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int deleteBillInfoByID(int id);

    /**
     * @Description: 获取所有的账单信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.BillInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    List<BillInfo> queryBillInfoList();

    /**
     * @Description: 根据供应商名字查询药品信息
     * @param: [sname]
     * @return: java.util.List<com.xiecode.drug.pojo.BillInfo>
     * @Author: Xiewc
     * @Date: 2022/4/19
     */
    List<BillInfo> queryDrugInfoListBySName(String sname);
}
