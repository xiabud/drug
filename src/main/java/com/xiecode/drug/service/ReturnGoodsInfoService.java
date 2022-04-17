package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.ReturnGoodsInfo;

import java.util.List;

/**
 * <p>
 * 收到退货表 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
public interface ReturnGoodsInfoService extends IService<ReturnGoodsInfo> {
    /**
     * @Description: 分页查询药品退货记录信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.ReturnGoodsInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    IPage<ReturnGoodsInfo> selectReturnGoodsInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条药品退货记录信息
     * @param: [returnDoodsInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int addReturnGoodsInfo(ReturnGoodsInfo returnDoodsInfo);

    /**
     * @Description: 编辑修改一条药品退货记录信息
     * @param: [returnDoodsInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int editReturnGoodsInfo(ReturnGoodsInfo returnDoodsInfo);

    /**
     * @Description: 根据id来查询药品退货记录的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.ReturnGoodsInfo
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    ReturnGoodsInfo queryReturnGoodsInfoById(int id);

    /**
     * @Description: 根据id来删除药品退货记录的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    int deleteReturnGoodsInfoByID(int id);

    /**
     * @Description: 获取所有的药品退货记录信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.ReturnGoodsInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    List<ReturnGoodsInfo> queryReturnGoodsInfoList();

}
