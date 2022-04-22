package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.InsellDrugInfoMapper;
import com.xiecode.drug.pojo.InsellDrugInfo;
import com.xiecode.drug.service.InsellDrugInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-22
 */
@Service
public class InsellDrugInfoServiceImpl extends ServiceImpl<InsellDrugInfoMapper, InsellDrugInfo> implements InsellDrugInfoService {


    @Resource
    private InsellDrugInfoMapper insellDrugInfoMapper;

    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品入库登记记账
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public IPage<InsellDrugInfo> selectInsellDrugInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<InsellDrugInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<InsellDrugInfo> page = new Page<>(pageNum, pageSize);
        return insellDrugInfoMapper.selectPage(page, queryWrapper);
    }

    /**
     * @param insellDrugInfo
     * @Description: 新增一条药品入库登记记账信息
     * @param: [druginfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public int addInsellDrugInfo(InsellDrugInfo insellDrugInfo) {
        return insellDrugInfoMapper.insert(insellDrugInfo);
    }

    /**
     * @param insellDrugInfo
     * @Description: 修改一条药品入库登记记账信息
     * @param: [insellDrugInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public int editInsellDrugInfo(InsellDrugInfo insellDrugInfo) {
        return insellDrugInfoMapper.updateById(insellDrugInfo);
    }

    /**
     * @param id
     * @Description: 根据主键ID来查询一个药品入库登记记账对象
     * @param: [id]
     * @return: com.xiecode.drug.pojo.DrugInfo
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public InsellDrugInfo queryInsellDrugInfoById(int id) {
        return insellDrugInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据主键ID来删除一个药品入库登记记账对象
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public int deleteInsellDrugInfoByID(int id) {
        return insellDrugInfoMapper.deleteById(id);
    }

    /**
     * @Description: 查询所有药品入库登记记账的列表
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public List<InsellDrugInfo> queryInsellDrugInfoList() {
        return insellDrugInfoMapper.selectList(null);
    }

    /**
     * @Description: 查询药品在售信息表中最大的ID
     * @param: []
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public int selectMaxID() {
        return insellDrugInfoMapper.selectMaxID();
    }

    /**
     * @param insellDrugInfo
     * @Description: 新增药品在售信息表
     * @param: [insellDrugInfo]
     * @return: void
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public int insert(InsellDrugInfo insellDrugInfo) {
        return insellDrugInfoMapper.insert(insellDrugInfo);
    }

    /**
     * @Description: 获取所有的药品在售信息的进货编码
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.InsellDrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/20
     */
    @Override
    public List<InsellDrugInfo> insellDrugInfoListByDrugName(String dname) {
        return insellDrugInfoMapper.insellDrugInfoListByDrugName(dname);
    }

    /**
     * @param drugOutInfo
     * @Description: 更新药品在售信息单的数据通过药品单号(销售)
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.InsellDrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/20
     */
    @Override
    public int updatebyDruginnum(InsellDrugInfo drugOutInfo) {
        return insellDrugInfoMapper.updatebyDruginnum(drugOutInfo);
    }

    /**
     * @param drugOutInfo
     * @Description: 更新药品在售信息的库存（增加）
     * @param: []
     * @return: void
     * @Author: Xiewc
     * @Date: 2022/4/20
     */
    @Override
    public int updateDrugCountByDruginnum(InsellDrugInfo drugOutInfo) {
        return insellDrugInfoMapper.updateDrugCountByDruginnum(drugOutInfo);
    }

    /**
     * @param
     * @Description: 根据药品在售信息批号来查询药品信息
     * @param: []
     * @return: void
     * @Author: Xiewc
     * @Date: 2022/4/21
     */
    @Override
    public InsellDrugInfo selectDrugCountByDruginnum(String druginnum) {
        return insellDrugInfoMapper.selectDrugCountByDruginnum(druginnum);
    }
}
