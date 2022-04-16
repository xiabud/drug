package com.xiecode.drug.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 药品出入库
 * </p>
 *
 * @author xiewc
 * @since 2022-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OutOrInInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 药品名称
     */
    private String dname;

    /**
     * 出库？入库？类型
     */
    private String type;

    /**
     * 出入库数量
     */
    private Integer count;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date createTime;


}
