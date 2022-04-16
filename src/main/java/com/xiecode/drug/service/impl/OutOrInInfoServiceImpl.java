package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.OutOrInInfoMapper;
import com.xiecode.drug.pojo.OutOrInInfo;
import com.xiecode.drug.service.OutOrInInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 出入库 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-03-23
 */
@Service
public class OutOrInInfoServiceImpl extends ServiceImpl<OutOrInInfoMapper, OutOrInInfo> implements OutOrInInfoService {

    @Resource
    private OutOrInInfoMapper outOrInInfoMapper;
    
    
    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品出入库信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.OutOrInInfo>
     * @Author: Xiewc
     * @Date: 2022/3/23
     */
    @Override
    public IPage<OutOrInInfo> selectOutOrInInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<OutOrInInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<OutOrInInfo> page = new Page<>(pageNum,pageSize);
        return outOrInInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param outorinInfo
     * @Description: 新增一条出入库信息
     * @param: [outorinInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/3/23
     */
    @Override
    public int addOutOrInInfo(OutOrInInfo outorinInfo) {
        return outOrInInfoMapper.insert(outorinInfo);
    }

    /**
     * @param outorinInfo
     * @Description: 编辑修改一条出入库信息
     * @param: [outorinInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/3/23
     */
    @Override
    public int editOutOrInInfo(OutOrInInfo outorinInfo) {
        return outOrInInfoMapper.updateById(outorinInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询药品出入库的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.OutOrInInfo
     * @Author: Xiewc
     * @Date: 2022/3/23
     */
    @Override
    public OutOrInInfo queryOutOrInInfoById(int id) {
        return outOrInInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据id来删除出入库的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/3/23
     */
    @Override
    public int deleteOutOrInInfoByID(int id) {
        return outOrInInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的出入库信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.OutOrInInfo>
     * @Author: Xiewc
     * @Date: 2022/3/23
     */
    @Override
    public List<OutOrInInfo> queryOutOrInInfoList() {
        return outOrInInfoMapper.selectList(null);
    }
}
