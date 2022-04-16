package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiecode.drug.pojo.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 供应商 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-02-21
 */
public interface SupplierService extends IService<Supplier> {

    /**
    * @Description: 分页查询供应商数据
    * @param: [pageNum:第几页, pageSize：每一页的数据, param：查询参数]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.Supplier>
    * @Author: Xiewc
    * @Date: 2022/2/21
    */
    IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param);


    /**
    * @Description: 新增一条供应商信息
    * @param: [supplier]
    * @return: 返回添加成功的记录条数
    * @Author: Xiewc
    * @Date: 2022/2/21
    */
    int addSupplier(Supplier supplier);

    /**
    * @Description: 修改一条供应商信息
    * @param: [supplier]
    * @return: int 返回修改成功的记录条数
    * @Author: Xiewc
    * @Date: 2022/2/21
    */
    int editSupplier(Supplier supplier);

    /**
    * @Description: 根据主键ID来查询一个供应商对象
    * @param: [id] 传入供应商主键ID
    * @return: com.xiecode.drug.pojo.Supplier
    * @Author: Xiewc
    * @Date: 2022/2/21
    */
    Supplier querySupplierById(int id);

    /**
    * @Description: 根据主键ID来删除一个供应商对象
    * @param: [id 供应商主键id]
    * @return: com.xiecode.drug.pojo.Supplier
    * @Author: Xiewc
    * @Date: 2022/2/22
    */
    int deleteSupplierByID(int id);

    /**
    * @Description: 查询所有供应商的列表
    * @param: []
    * @return: java.util.List<com.xiecode.drug.pojo.Supplier>
    * @Author: Xiewc
    * @Date: 2022/2/22
    */
    List<Supplier> querySupplierList();



}
