package com.xiecode.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiecode.drug.pojo.DrugInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 药品信息 Mapper 接口
 * </p>
 *
 * @author xiewc
 * @since 2022-03-01
 */
@Mapper
@Repository
public interface DrugInfoMapper extends BaseMapper<DrugInfo> {

    /**
     * @Description: 更新药品的库存
     * @param: [count]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    int updateAddStock(@Param("count") int count, @Param("dName") String dName);

    int updateReduceStock(@Param("count") int count, @Param("dName") String dName);

    int selectStock(@Param("dName") String dName);

    DrugInfo selectDrugInfoByDname(@Param("dName") String dName);

    List<DrugInfo> drugInfoListBySName(@Param("sName") String sName);
}
