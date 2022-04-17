package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.ReturnSupplierInfoMapper;
import com.xiecode.drug.pojo.ReturnSupplierInfo;
import com.xiecode.drug.service.ReturnSupplierInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 退回给供应商表 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
@Service
public class ReturnSupplierInfoServiceImpl extends ServiceImpl<ReturnSupplierInfoMapper, ReturnSupplierInfo> implements ReturnSupplierInfoService {

    @Resource
    private ReturnSupplierInfoMapper returnSupplierInfoMapper;


    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品退货记录信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.ReturnSupplierInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public IPage<ReturnSupplierInfo> selectReturnSupplierInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnSupplierInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<ReturnSupplierInfo> page = new Page<>(pageNum,pageSize);
        return returnSupplierInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param returnSupplierInfo
     * @Description: 新增一条药品退货记录信息
     * @param: [returnSupplierInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int addReturnSupplierInfo(ReturnSupplierInfo returnSupplierInfo) {
        return returnSupplierInfoMapper.insert(returnSupplierInfo);
    }

    /**
     * @param returnSupplierInfo
     * @Description: 编辑修改一条药品退货记录信息
     * @param: [returnSupplierInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int editReturnSupplierInfo(ReturnSupplierInfo returnSupplierInfo) {
        return returnSupplierInfoMapper.updateById(returnSupplierInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询药品退货记录的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.ReturnSupplierInfo
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public ReturnSupplierInfo queryReturnSupplierInfoById(int id) {
        return returnSupplierInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据id来删除药品退货记录的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int deleteReturnSupplierInfoByID(int id) {
        return returnSupplierInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的药品退货记录信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.ReturnSupplierInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public List<ReturnSupplierInfo> queryReturnSupplierInfoList() {
        return returnSupplierInfoMapper.selectList(null);
    }
}
