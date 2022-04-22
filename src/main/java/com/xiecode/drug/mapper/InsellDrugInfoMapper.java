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

    List<InsellDrugInfo> insellDrugInfoListByDrugName(String dname);

    int updatebyDruginnum(InsellDrugInfo drugOutInfo);

    int updateDrugCountByDruginnum(InsellDrugInfo drugOutInfo);

    int selectDrugCountByDruginnum(String druginnum);

}
