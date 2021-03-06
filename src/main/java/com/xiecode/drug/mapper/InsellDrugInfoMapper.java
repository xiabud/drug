package com.xiecode.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiecode.drug.pojo.InsellDrugInfo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xiewc
 * @since 2022-04-22
 */
public interface InsellDrugInfoMapper extends BaseMapper<InsellDrugInfo> {


    int selectMaxID();


    /**
     * @Description: 根据药品的名称获取药品的批号
     * @param: [dname]
     * @return: java.util.List<com.xiecode.drug.pojo.InsellDrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/23
     */
    List<InsellDrugInfo> insellDrugInfoListByDrugName(String dname);

    int updatebyDruginnum(InsellDrugInfo drugOutInfo);

    /**
     * @Description: 更新药品在售信息的库存（增加）
     * @param: [druginnum]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    int updateDrugCountByDruginnum(InsellDrugInfo drugOutInfo);

    /**
     * @Description: 根据药品在售信息批号来查询药品信息
     * @param: [druginnum]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    InsellDrugInfo selectDrugCountByDruginnum(String druginnum);

    /**
     * @Description: 更新药品在售信息的库存（退货）
     * @param: [drugOutInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/23
     */
    int updatebyDruginnumReduce(InsellDrugInfo drugOutInfo);

    List<InsellDrugInfo> drugInInfoListByDrugCount();
}
