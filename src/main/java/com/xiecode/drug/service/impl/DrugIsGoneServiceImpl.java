package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.DrugIsGoneMapper;
import com.xiecode.drug.pojo.DrugIsGone;
import com.xiecode.drug.service.DrugIsGoneService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-22
 */
@Service
public class DrugIsGoneServiceImpl extends ServiceImpl<DrugIsGoneMapper, DrugIsGone> implements DrugIsGoneService {


    @Resource
    private DrugIsGoneMapper drugIsGoneMapper;

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
    public IPage<DrugIsGone> selectrugIsGonePage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugIsGone> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<DrugIsGone> page = new Page<>(pageNum, pageSize);
        return drugIsGoneMapper.selectPage(page, queryWrapper);
    }

    /**
     * @param drugIsGone
     * @Description: 将数据插入药品售完信息表
     * @param: [drugIsGone]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    @Override
    public int insert(DrugIsGone drugIsGone) {
        return drugIsGoneMapper.insert(drugIsGone);
    }

    /**
     * @param id
     * @Description: 删除一个药品售完信息记录
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    @Override
    public int deleteDrugIsGoneByID(Integer id) {
        return drugIsGoneMapper.deleteById(id);
    }
}
