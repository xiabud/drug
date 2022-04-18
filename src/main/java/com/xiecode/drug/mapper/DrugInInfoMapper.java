package com.xiecode.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiecode.drug.pojo.DrugInInfo;

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
}
