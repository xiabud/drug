package com.xiecode.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiecode.drug.pojo.DrugInInfo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xiewc
 * @since 2022-04-18
 */
public interface DrugInInfoMapper extends BaseMapper<DrugInInfo> {

    int selectMaxID();

    List<DrugInInfo> drugInInfoListByDrugName(String dname);

    int updatebyDruginnum(DrugInInfo drugOutInfo);

    int updateDrugCountByDruginnum(DrugInInfo drugOutInfo);

    int selectDrugCountByDruginnum(String druginnum);

    int updateDrugRetuenByDruginnum(DrugInInfo drugInInfo);
}
