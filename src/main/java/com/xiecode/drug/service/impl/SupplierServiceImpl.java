package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiecode.drug.mapper.SupplierMapper;
import com.xiecode.drug.pojo.Supplier;
import com.xiecode.drug.service.SupplierService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 供应商 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-02-21
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {


    @Resource
    private SupplierMapper supplierMapper;

    /**
     * @param pageNum
     * @param pageSize
     * @param param 供应商名称
     * @Description: 分页查询供应商数据
     * @param: [pageNum:第几页, pageSize：每一页的数据, param：查询参数]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.Supplier>
     * @Author: Xiewc
     * @Date: 2022/2/21
     */
    @Override
    public IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<Supplier> page = new Page<>(pageNum, pageSize);
        return supplierMapper.selectPage(page, queryWrapper);
    }

    /**
     * @param supplier
     * @Description: 新增一条供应商信息
     * @param: [supplier]
     * @return: 返回添加成功的记录条数
     * @Author: Xiewc
     * @Date: 2022/2/21
     */
    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    /**
     * @param supplier
     * @Description: 修改一条供应商信息
     * @param: [supplier]
     * @return: int 返回修改成功的记录条数
     * @Author: Xiewc
     * @Date: 2022/2/21
     */
    @Override
    public int editSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    /**
     * @param id
     * @Description: 根据主键ID来查询一个供应商对象
     * @param: [id] 传入供应商主键ID
     * @return: com.xiecode.drug.pojo.Supplier
     * @Author: Xiewc
     * @Date: 2022/2/21
     */
    @Override
    public Supplier querySupplierById(int id) {
        return supplierMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据主键ID来删除一个供应商对象
     * @param: [id 供应商主键id]
     * @return: com.xiecode.drug.pojo.Supplier
     * @Author: Xiewc
     * @Date: 2022/2/22
     */
    @Override
    public int deleteSupplierByID(int id) {
        return supplierMapper.deleteById(id);
    }

    /**
     * @Description: 查询所有供应商的列表
     * @param: []
     * @return: java.util.List<com.xiecode.drug.pojo.Supplier>
     * @Author: Xiewc
     * @Date: 2022/2/22
     */
    @Override
    public List<Supplier> querySupplierList() {
        return supplierMapper.selectList(null);
    }
}
