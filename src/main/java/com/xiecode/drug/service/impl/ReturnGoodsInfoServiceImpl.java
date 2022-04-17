package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.ReturnGoodsInfoMapper;
import com.xiecode.drug.pojo.ReturnGoodsInfo;
import com.xiecode.drug.service.ReturnGoodsInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 收到退货表 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
@Service
public class ReturnGoodsInfoServiceImpl extends ServiceImpl<ReturnGoodsInfoMapper, ReturnGoodsInfo> implements ReturnGoodsInfoService {

    @Resource
    private ReturnGoodsInfoMapper returnGoodsInfoMapper;
    
    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品退货记录信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.ReturnGoodsInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public IPage<ReturnGoodsInfo> selectReturnGoodsInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnGoodsInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<ReturnGoodsInfo> page = new Page<>(pageNum,pageSize);
        return returnGoodsInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param returnDoodsInfo
     * @Description: 新增一条药品退货记录信息
     * @param: [returnDoodsInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int addReturnGoodsInfo(ReturnGoodsInfo returnDoodsInfo) {
        return returnGoodsInfoMapper.insert(returnDoodsInfo);
    }

    /**
     * @param returnDoodsInfo
     * @Description: 编辑修改一条药品退货记录信息
     * @param: [returnDoodsInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int editReturnGoodsInfo(ReturnGoodsInfo returnDoodsInfo) {
        return returnGoodsInfoMapper.updateById(returnDoodsInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询药品退货记录的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.ReturnGoodsInfo
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public ReturnGoodsInfo queryReturnGoodsInfoById(int id) {
        return returnGoodsInfoMapper.selectById(id);
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
    public int deleteReturnGoodsInfoByID(int id) {
        return returnGoodsInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的药品退货记录信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.ReturnGoodsInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public List<ReturnGoodsInfo> queryReturnGoodsInfoList() {
        return returnGoodsInfoMapper.selectList(null);
    }
}
