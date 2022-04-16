package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiecode.drug.pojo.DrugInfo;
import com.xiecode.drug.mapper.DrugInfoMapper;
import com.xiecode.drug.service.DrugInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 药品信息 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-03-01
 */
@Service
public class DrugInfoServiceImpl extends ServiceImpl<DrugInfoMapper, DrugInfo> implements DrugInfoService {


    @Resource
    private DrugInfoMapper drugInfoMapper;


    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品数据
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @Override
    public IPage<DrugInfo> selectDrugInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<DrugInfo> page = new Page<>(pageNum,pageSize);
        return drugInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param druginfo
     * @Description: 新增一条药品信息
     * @param: [druginfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @Override
    public int addDrugInfo(DrugInfo druginfo) {
        return drugInfoMapper.insert(druginfo);
    }

    /**
     * @param druginfo
     * @Description: 修改一条药品信息
     * @param: [druginfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @Override
    public int editDrugInfo(DrugInfo druginfo) {
        return drugInfoMapper.updateById(druginfo);
    }

    /**
     * @param id
     * @Description: 根据主键ID来查询一个药品对象
     * @param: [id]
     * @return: com.xiecode.drug.pojo.DrugInfo
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @Override
    public DrugInfo queryDrugInfoById(int id) {
        return drugInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据主键ID来删除一个药品对象
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @Override
    public int deleteDrugInfoByID(int id) {
        return drugInfoMapper.deleteById(id);
    }

    /**
     * @Description: 查询所有药品的列表
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/3/1
     */
    @Override
    public List<DrugInfo> queryDrugInfoList() {
        return drugInfoMapper.selectList(null);
    }
}
