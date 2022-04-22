package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.InsellDrugInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-22
 */
public interface InsellDrugInfoService extends IService<InsellDrugInfo> {
    /**
     * @Description: 分页查询药品入库登记记账
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    IPage<InsellDrugInfo> selectInsellDrugInfoPage(int pageNum, int pageSize, String param);


    /**
     * @Description: 新增一条药品入库登记记账信息
     * @param: [druginfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int addInsellDrugInfo(InsellDrugInfo insellDrugInfo);

    /**
     * @Description: 修改一条药品入库登记记账信息
     * @param: [insellDrugInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int editInsellDrugInfo(InsellDrugInfo insellDrugInfo);

    /**
     * @Description: 根据主键ID来查询一个药品入库登记记账对象
     * @param: [id]
     * @return: com.xiecode.drug.pojo.DrugInfo
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    InsellDrugInfo queryInsellDrugInfoById(int id);

    /**
     * @Description: 根据主键ID来删除一个药品入库登记记账对象
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int deleteInsellDrugInfoByID(int id);

    /**
     * @Description: 查询所有药品入库登记记账的列表
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    List<InsellDrugInfo> queryInsellDrugInfoList();


    /**
     * @Description: 查询药品进货表中最大的ID
     * @param: []
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int selectMaxID();

    /**
     * @Description: 新增药品进货表
     * @param: [insellDrugInfo]
     * @return: void
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int insert(InsellDrugInfo insellDrugInfo);

    /**
     * @Description: 获取所有的药品进货的进货编码
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.InsellDrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/20
     */
    List<InsellDrugInfo> insellDrugInfoListByDrugName(String dname);

    /**
     * @Description: 更新药品进货单的数据通过药品单号
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.InsellDrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/20
     */
    int updatebyDruginnum(InsellDrugInfo drugOutInfo);

    /**
     * @Description: 根据进货编号来更新库存
     * @param: []
     * @return: void
     * @Author: Xiewc
     * @Date: 2022/4/20
     */
    int updateDrugCountByDruginnum(InsellDrugInfo drugOutInfo);

    /**
     * @Description: 根据药品进货批号来查询药品数量
     * @param: [druginnum]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/21
     */
    int selectDrugCountByDruginnum(String druginnum);
}
