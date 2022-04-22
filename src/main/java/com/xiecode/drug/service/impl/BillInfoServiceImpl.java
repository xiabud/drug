package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.BillInfoMapper;
import com.xiecode.drug.pojo.BillInfo;
import com.xiecode.drug.service.BillInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 销售记录 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-17
 */
@Service
public class BillInfoServiceImpl extends ServiceImpl<BillInfoMapper, BillInfo> implements BillInfoService {

    @Resource
    private BillInfoMapper billInfoMapper;


    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询账单信息
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.BillInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public IPage<BillInfo> selectBillInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<BillInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            //根据供应商名称精确查询
            queryWrapper.like("sname", param);
        }
        Page<BillInfo> page = new Page<>(pageNum,pageSize);
        return billInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param billInfo
     * @Description: 新增一条账单信息
     * @param: [billInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int addBillInfo(BillInfo billInfo) {
        return billInfoMapper.insert(billInfo);
    }

    /**
     * @param billInfo
     * @Description: 编辑修改一条账单信息
     * @param: [billInfo]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int editBillInfo(BillInfo billInfo) {
        return billInfoMapper.updateById(billInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询账单的信息
     * @param: [id]
     * @return: com.xiecode.drug.pojo.BillInfo
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public BillInfo queryBillInfoById(int id) {
        return billInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据id来删除账单的信息
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public int deleteBillInfoByID(int id) {
        return billInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的账单信息
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.BillInfo>
     * @Author: Xiewc
     * @Date: 2022/4/17
     */
    @Override
    public List<BillInfo> queryBillInfoList() {
        return billInfoMapper.selectList(null);
    }

    /**
     * @param sname
     * @Description: 根据供应商名字查询药品信息
     * @param: [sname]
     * @return: java.util.List<com.xiecode.drug.pojo.BillInfo>
     * @Author: Xiewc
     * @Date: 2022/4/19
     */
    @Override
    public List<BillInfo> queryDrugInfoListBySName(String sname) {
        return billInfoMapper.queryDrugInfoListBySName(sname);
    }

    /**
     * @param druginnum
     * @Description: 根据药品进货编码主键查询药品进货时进货数量
     * @param: [druginnum]
     * @return: com.xiecode.drug.pojo.BillInfo
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    @Override
    public BillInfo selectCountByDrugInnum(String druginnum) {
        return billInfoMapper.selectCountByDrugInnum(druginnum);
    }
}
