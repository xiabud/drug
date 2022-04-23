package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.SellIsGoneMapper;
import com.xiecode.drug.pojo.SellIsGone;
import com.xiecode.drug.service.SellIsGoneService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-23
 */
@Service
public class SellIsGoneServiceImpl extends ServiceImpl<SellIsGoneMapper, SellIsGone> implements SellIsGoneService {


    @Resource
    private SellIsGoneMapper sellIsGoneMapper;

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
    public IPage<SellIsGone> selectrugIsGonePage(int pageNum, int pageSize, String param) {
        QueryWrapper<SellIsGone> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<SellIsGone> page = new Page<>(pageNum, pageSize);
        return sellIsGoneMapper.selectPage(page, queryWrapper);
    }

    /**
     * @param sellIsGone
     * @Description: 将数据插入药品售完信息表
     * @param: [sellIsGone]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    @Override
    public int insert(SellIsGone sellIsGone) {
        return sellIsGoneMapper.insert(sellIsGone);
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
    public int deleteSellIsGoneByID(Integer id) {
        return sellIsGoneMapper.deleteById(id);
    }
}
