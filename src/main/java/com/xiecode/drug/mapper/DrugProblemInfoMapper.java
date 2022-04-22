package com.xiecode.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiecode.drug.pojo.DrugProblemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * <p>
 * 问题药品表 Mapper 接口
 * </p>
 *
 * @author xiewc
 * @since 2022-04-16
 */
@Mapper
@Repository
public interface DrugProblemInfoMapper extends BaseMapper<DrugProblemInfo> {


    int updateDrugProblemInfoBydrugInNum(@Param("druginnum") String drugInNum, @Param("createtime") Date createTime);
}
