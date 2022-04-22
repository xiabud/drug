package com.xiecode.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiecode.drug.pojo.BillInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 销售记录 Mapper 接口
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
public interface BillInfoMapper extends BaseMapper<BillInfo> {

    List<BillInfo> queryDrugInfoListBySName(@Param("sName") String sname);

    BillInfo selectCountByDrugInnum(@Param("druginnum") String druginnum);
}
