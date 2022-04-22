package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.DrugIsGone;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-22
 */
public interface DrugIsGoneService extends IService<DrugIsGone> {

    /**
     * @Description: 分页查询药品入库登记记账
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    IPage<DrugIsGone> selectrugIsGonePage(int pageNum, int pageSize, String param);

    /**
     * @Description: 将数据插入药品售完信息表
     * @param: [drugIsGone]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    int insert(DrugIsGone drugIsGone);

    /**
     * @Description: 删除一个药品售完信息记录
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    int deleteDrugIsGoneByID(Integer id);
}
