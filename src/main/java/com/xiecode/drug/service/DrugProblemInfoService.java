package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.DrugProblemInfo;

import java.util.List;

/**
 * <p>
 * 问题药品表 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-16
 */
public interface DrugProblemInfoService extends IService<DrugProblemInfo> {

    /**
     * @Description: 分页查询问题药品信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.DrugProblemInfo>
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    IPage<DrugProblemInfo> selectDrugProblemInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条问题药品信息
     * @param: [drugProblemInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    int addDrugProblemInfo(DrugProblemInfo drugProblemInfo);

    /**
     * @Description: 编辑修改一条问题药品信息
     * @param: [drugProblemInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    int editDrugProblemInfo(DrugProblemInfo drugProblemInfo);

    /**
     * @Description: 根据id来查询问题药品的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.DrugProblemInfo
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    DrugProblemInfo queryDrugProblemInfoById(int id);

    /**
     * @Description: 根据id来删除问题药品的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    int deleteDrugProblemInfoByID(int id);

    /**
     * @Description: 获取所有的问题药品信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugProblemInfo>
     * @Author: Xiewc
     * @Date: 2022/4/16
     */
    List<DrugProblemInfo> queryDrugProblemInfoList();

}
