package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.DrugInfo;

import java.util.List;

/**
 * <p>
 * 药品信息 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-03-01
 */
public interface DrugInfoService extends IService<DrugInfo> {

    /** 
    * @Description: 分页查询药品数据 
    * @param: [pageNum, pageSize, param]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.DrugInfo>
    * @Author: Xiewc
    * @Date: 2022/3/1
    */
    IPage<DrugInfo> selectDrugInfoPage(int pageNum, int pageSize, String param);


    /**
    * @Description: 新增一条药品信息
    * @param: [druginfo]
    * @return: int
    * @Author: Xiewc
    * @Date: 2022/3/1
    */
    int addDrugInfo(DrugInfo druginfo);

    /**
    * @Description: 修改一条药品信息
    * @param: [druginfo]
    * @return: int
    * @Author: Xiewc
    * @Date: 2022/3/1
    */
    int editDrugInfo(DrugInfo druginfo);

    /**
    * @Description: 根据主键ID来查询一个药品对象
    * @param: [id]
    * @return: com.xiecode.drug.pojo.DrugInfo
    * @Author: Xiewc
    * @Date: 2022/3/1
    */
    DrugInfo queryDrugInfoById(int id);

    /**
    * @Description: 根据主键ID来删除一个药品对象
    * @param: [id]
    * @return: int
    * @Author: Xiewc
    * @Date: 2022/3/1
    */
    int deleteDrugInfoByID(int id);

    /**
     * @Description: 查询所有药品的列表
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    List<DrugInfo> queryDrugInfoList();


    /**
     * @Description: 修改药品的库存（添加）
     * @param:
     * @return:
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int updateAddStock(int count, String dname);

    /**
     * @Description: 修改药品的库存（减少）
     * @param:
     * @return:
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int updateReduceStock(int count, String dname);

    /**
     * @Description: 查询药品的库存
     * @param: [dname]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int selectStock(String dname);
}
