package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.OutOrInInfo;

import java.util.List;

/**
 * <p>
 * 出入库 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-03-23
 */
public interface OutOrInInfoService extends IService<OutOrInInfo> {

    /** 
    * @Description: 分页查询药品出入库信息 
    * @param: [pageNum, pageSize, param]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.OutOrInInfo>
    * @Author: Xiewc
    * @Date: 2022/3/23
    */
    IPage<OutOrInInfo> selectOutOrInInfoPage(int pageNum, int pageSize, String param);

    /** 
    * @Description: 新增一条出入库信息 
    * @param: [outorinInfo]
    * @return: int
    * @Author: Xiewc
    * @Date: 2022/3/23
    */
    int addOutOrInInfo(OutOrInInfo outorinInfo);

    /** 
    * @Description: 编辑修改一条出入库信息 
    * @param: [outorinInfo]
    * @return: int
    * @Author: Xiewc
    * @Date: 2022/3/23
    */
    int editOutOrInInfo(OutOrInInfo outorinInfo);

    /** 
    * @Description: 根据id来查询药品出入库的信息 
    * @param: [id]
    * @return: com.xiecode.drug.pojo.OutOrInInfo
    * @Author: Xiewc
    * @Date: 2022/3/23
    */
    OutOrInInfo queryOutOrInInfoById(int id);

    /** 
    * @Description: 根据id来删除出入库的信息 
    * @param: [id]
    * @return: int
    * @Author: Xiewc
    * @Date: 2022/3/23
    */
    int deleteOutOrInInfoByID(int id);

    /** 
    * @Description: 获取所有的出入库信息 
    * @param: []
    * @return: java.util.List<com.xiecode.drug.pojo.OutOrInInfo>
    * @Author: Xiewc
    * @Date: 2022/3/23
    */
    List<OutOrInInfo> queryOutOrInInfoList();
}
