package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.DrugInInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-18
 */
public interface DrugInInfoService extends IService<DrugInInfo> {
    /**
     * @Description: 分页查询药品入库登记记账
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    IPage<DrugInInfo> selectDrugInInfoPage(int pageNum, int pageSize, String param);


    /**
     * @Description: 新增一条药品入库登记记账信息
     * @param: [druginfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int addDrugInInfo(DrugInInfo drugInInfo);

    /**
     * @Description: 修改一条药品入库登记记账信息
     * @param: [drugInInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int editDrugInInfo(DrugInInfo drugInInfo);

    /**
     * @Description: 根据主键ID来查询一个药品入库登记记账对象
     * @param: [id]
     * @return: com.xiecode.drug.pojo.DrugInfo
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    DrugInInfo queryDrugInInfoById(int id);

    /**
     * @Description: 根据主键ID来删除一个药品入库登记记账对象
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int deleteDrugInInfoByID(int id);

    /**
     * @Description: 查询所有药品入库登记记账的列表
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    List<DrugInInfo> queryDrugInInfoList();


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
     * @param: [drugInInfo]
     * @return: void
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int insert(DrugInInfo drugInInfo);
}
