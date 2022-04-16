package com.xiecode.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiecode.drug.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 供应商 Mapper 接口
 * </p>
 *
 * @author xiewc
 * @since 2022-02-21
 */
@Repository
@Mapper
public interface SupplierMapper extends BaseMapper<Supplier> {

}
