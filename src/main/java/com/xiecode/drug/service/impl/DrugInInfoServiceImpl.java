package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.DrugInInfoMapper;
import com.xiecode.drug.pojo.DrugInInfo;
import com.xiecode.drug.service.DrugInInfoService;
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
 * @since 2022-04-18
 */
@Service
public class DrugInInfoServiceImpl extends ServiceImpl<DrugInInfoMapper, DrugInInfo> implements DrugInInfoService {

    @Resource
    private DrugInInfoMapper drugInInfoMapper;

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
    public IPage<DrugInInfo> selectDrugInInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugInInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<DrugInInfo> page = new Page<>(pageNum, pageSize);
        return drugInInfoMapper.selectPage(page, queryWrapper);
    }

    /**
     * @param drugInInfo
     * @Description: 新增一条药品入库登记记账信息
     * @param: [druginfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public int addDrugInInfo(DrugInInfo drugInInfo) {
        return drugInInfoMapper.insert(drugInInfo);
    }

    /**
     * @param drugInInfo
     * @Description: 修改一条药品入库登记记账信息
     * @param: [drugInInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public int editDrugInInfo(DrugInInfo drugInInfo) {
        return drugInInfoMapper.updateById(drugInInfo);
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
    public DrugInInfo queryDrugInInfoById(int id) {
        return drugInInfoMapper.selectById(id);
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
    public int deleteDrugInInfoByID(int id) {
        return drugInInfoMapper.deleteById(id);
    }

    /**
     * @Description: 查询所有药品入库登记记账的列表
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public List<DrugInInfo> queryDrugInInfoList() {
        return drugInInfoMapper.selectList(null);
    }

    /**
     * @Description: 查询药品进货表中最大的ID
     * @param: []
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public int selectMaxID() {
        return drugInInfoMapper.selectMaxID();
    }

    /**
     * @param drugInInfo
     * @Description: 新增药品进货表
     * @param: [drugInInfo]
     * @return: void
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    @Override
    public int insert(DrugInInfo drugInInfo) {
        return drugInInfoMapper.insert(drugInInfo);
    }

    /**
     * @Description: 获取所有的药品进货的进货编码
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugInInfo>
     * @Author: Xiewc
     * @Date: 2022/4/20
     */
    @Override
    public List<DrugInInfo> drugInInfoListByDrugName(String dname) {
        return drugInInfoMapper.drugInInfoListByDrugName(dname);
    }

    /**
     * @param drugOutInfo
     * @Description: 更新药品进货单的数据通过药品单号
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.DrugInInfo>
     * @Author: Xiewc
     * @Date: 2022/4/20
     */
    @Override
    public int updatebyDruginnum(DrugInInfo drugOutInfo) {
        return drugInInfoMapper.updatebyDruginnum(drugOutInfo);
    }

    /**
     * @param drugOutInfo
     * @Description: 根据进货编号来更新库存
     * @param: []
     * @return: void
     * @Author: Xiewc
     * @Date: 2022/4/20
     */
    @Override
    public int updateDrugCountByDruginnum(DrugInInfo drugOutInfo) {
        return drugInInfoMapper.updateDrugCountByDruginnum(drugOutInfo);
    }

}
