package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.SaleInfoMapper;
import com.xiecode.drug.pojo.SaleInfo;
import com.xiecode.drug.service.SaleInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 账单信息表 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-16
 */
@Service
public class SaleInfoServiceImpl extends ServiceImpl<SaleInfoMapper, SaleInfo> implements SaleInfoService {


    @Resource
    private SaleInfoMapper saleInfoMapper;


    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品销售记录信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.SaleInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public IPage<SaleInfo> selectSaleInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<SaleInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<SaleInfo> page = new Page<>(pageNum,pageSize);
        return saleInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param saleInfo
     * @Description: 新增一条药品销售记录信息
     * @param: [saleInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int addSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.insert(saleInfo);
    }

    /**
     * @param saleInfo
     * @Description: 编辑修改一条药品销售记录信息
     * @param: [saleInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int editSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.updateById(saleInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询药品销售记录的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.SaleInfo
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public SaleInfo querySaleInfoById(int id) {
        return saleInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据id来删除药品销售记录的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int deleteSaleInfoByID(int id) {
        return saleInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的药品销售记录信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.SaleInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public List<SaleInfo> querySaleInfoList() {
        return saleInfoMapper.selectList(null);
    }
}
