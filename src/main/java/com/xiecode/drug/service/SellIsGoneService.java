package com.xiecode.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiecode.drug.pojo.SellIsGone;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-04-23
 */
public interface SellIsGoneService extends IService<SellIsGone> {

    /**
     * @Description: 分页查询药品入库登记记账
     * @param: [pageNum, pageSize, param]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.xiecode.drug.pojo.DrugInfo>
     * @Author: Xiewc
     * @Date: 2022/4/18
     */
    IPage<SellIsGone> selectrugIsGonePage(int pageNum, int pageSize, String param);

    /**
     * @Description: 将数据插入药品售完信息表
     * @param: [sellIsGone]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    int insert(SellIsGone sellIsGone);

    /**
     * @Description: 删除一个药品售完信息记录
     * @param: [id]
     * @return: int
     * @Author: Xiewc
     * @Date: 2022/4/22
     */
    int deleteSellIsGoneByID(Integer id);

}
